package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User_01_Register extends BasePage {

    /*
     * Có 3 cách để apply BasePage class để dùng được các hàm của BasePage
     * Trong BasePage chứa các common method để tương tác với WebBrowser va WebElement
     * C1: khởi tạo đối tượng
     * C2: dùng static method getBasePage()
     * C3: kế thừa class BasePage
     * Chỉ nên dùng cách 3 vì đây là cách tối ưu nhất
     * */

    private final String projectPath = System.getProperty("user.dir");
    private WebDriver driver;

    //khoi tao doi tuong cua 2 trang home va register
    private HomePageObject homePageObject;
    private RegisterPageObject registerPageObject;

    private String firstName, lastName, email, password;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        homePageObject = new HomePageObject(driver);
        registerPageObject = new RegisterPageObject(driver);

        //data
        firstName = "Nguyen";
        lastName = "Son";
        email = "son" + generateRandomNumber() + "@gmail.com";
        password = "123456";

        driver.get("https://demo.nopcommerce.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    // tạo mã giả trước, sau đó generate method bên phía HomePageObject class
    @Test
    public void TC_01_Empty_Data() {

        homePageObject.clickRegisterLink();

        registerPageObject.clickRegisterButton();

        Assert.assertEquals(registerPageObject.getFirstNameInputErrorMsg(), "First name is required.");
        Assert.assertEquals(registerPageObject.getLastNameInputErrorMsg(), "Last name is required.");
        Assert.assertEquals(registerPageObject.getEmailInputErrorMsg(), "Email is required.");
        Assert.assertEquals(registerPageObject.getPasswordInputErrorMsg(), "Password is required.");
        Assert.assertEquals(registerPageObject.getConfirmPasswordInputErrorMsg(), "Password is required.");
    }

    @Test
    public void TC_02_Invalid_Email() {
        homePageObject.clickRegisterLink();

        registerPageObject.inputFirstName(firstName);
        registerPageObject.inputLastName(lastName);
        registerPageObject.inputEmail("son@gmail");
        registerPageObject.inputPassword(password);
        registerPageObject.inputConfirmPassword(password);

        registerPageObject.clickRegisterButton();

        Assert.assertEquals(registerPageObject.getSummaryValidationErrorMsg(), "Wrong email");
    }

    @Test
    public void TC_03_Valid_Info() {

        homePageObject.clickRegisterLink();

        registerPageObject.inputFirstName(firstName);
        registerPageObject.inputLastName(lastName);
        registerPageObject.inputEmail(email);
        registerPageObject.inputPassword(password);
        registerPageObject.inputConfirmPassword(password);

        registerPageObject.clickRegisterButton();

        Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void TC_04_Existed_Email() {

        registerPageObject.clickLogoutLink();

        homePageObject.clickRegisterLink();

        registerPageObject.inputFirstName(firstName);
        registerPageObject.inputLastName(lastName);
        registerPageObject.inputEmail(email);
        registerPageObject.inputPassword(password);
        registerPageObject.inputConfirmPassword(password);

        registerPageObject.clickRegisterButton();

        Assert.assertEquals(registerPageObject.getSummaryValidationErrorMsg(), "The specified email already exists");
    }

    @Test
    public void TC_05_Password_Under_Six_Characters() {

        homePageObject.clickRegisterLink();

        registerPageObject.inputFirstName(firstName);
        registerPageObject.inputLastName(lastName);
        registerPageObject.inputEmail(email);
        registerPageObject.inputPassword("12345");
        registerPageObject.inputConfirmPassword("12345");

        registerPageObject.clickRegisterButton();

        Assert.assertEquals(registerPageObject.getPasswordInputErrorMsg(),
                "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_06_Confirm_Password_Unmatch() {

        homePageObject.clickRegisterLink();

        registerPageObject.inputFirstName(firstName);
        registerPageObject.inputLastName(lastName);
        registerPageObject.inputEmail(email);
        registerPageObject.inputPassword(password);
        registerPageObject.inputConfirmPassword(firstName);

        registerPageObject.clickRegisterButton();

        Assert.assertEquals(registerPageObject.getConfirmPasswordInputErrorMsg(),
                "The password and confirmation password do not match.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }
}
