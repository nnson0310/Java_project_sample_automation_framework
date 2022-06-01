package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User_01_Register_Apply_Page_Object_Level_1 extends BasePage {

    /*
     * Có 3 cách để apply BasePage class để dùng được các hàm của BasePage
     * Trong BasePage chứa các common method để tương tác với WebBrowser va WebElement
     * C1: khởi tạo đối tượng
     * C2: dùng static method getBasePage()
     * C3: kế thừa class BasePage
     * Chỉ nên dùng cách 3 vì đây là cách tối ưu nhất
     * */
    String projectPath = System.getProperty("user.dir");
    WebDriver driver;
    // BasePage basePage;

    private String firstName, lastName, email, password;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        // basePage = new BasePage();
        // basePage = getBasePage();

        firstName = "Nguyen";
        lastName = "Son";
        email = "son" + generateRandomNumber() + "@gmail.com";
        password = "123456";

        driver.get("https://demo.nopcommerce.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Empty_Data() {
        waitForElementClickable(driver, "//a[contains(@class,'ico-register')]");
        clickToElement(driver, "//a[contains(@class,'ico-register')]");

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
        Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
    }

    @Test
    public void TC_02_Invalid_Email() {
        waitForElementClickable(driver, "//a[contains(@class,'ico-register')]");
        clickToElement(driver, "//a[contains(@class,'ico-register')]");

        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);
        sendKeyToElement(driver, "//input[@id='Email']", "son@gb");
        sendKeyToElement(driver, "//input[@id='Password']", password);
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'validation-summary-errors')]"), "Wrong email");
    }

    @Test
    public void TC_03_Valid_Info() {
        waitForElementClickable(driver, "//a[contains(@class,'ico-register')]");
        clickToElement(driver, "//a[contains(@class,'ico-register')]");

        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);
        sendKeyToElement(driver, "//input[@id='Email']", email);
        sendKeyToElement(driver, "//input[@id='Password']", password);
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");
    }

    @Test
    public void TC_04_Existed_Email() {
        waitForElementClickable(driver, "//a[contains(@class,'logout')]");
        clickToElement(driver, "//a[contains(@class,'logout')]");

        waitForElementClickable(driver, "//a[contains(@class,'ico-register')]");
        clickToElement(driver, "//a[contains(@class,'ico-register')]");

        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);
        sendKeyToElement(driver, "//input[@id='Email']", email);
        sendKeyToElement(driver, "//input[@id='Password']", password);
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'validation-summary-errors')]"), "The specified email already exists");
    }

    @Test
    public void TC_05_Password_Under_Six_Characters() {
        waitForElementClickable(driver, "//a[contains(@class,'ico-register')]");
        clickToElement(driver, "//a[contains(@class,'ico-register')]");

        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);
        sendKeyToElement(driver, "//input[@id='Email']", email);
        sendKeyToElement(driver, "//input[@id='Password']", "12345");
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
                "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_06_Confirm_Password_Unmatch() {
        waitForElementClickable(driver, "//a[contains(@class,'ico-register')]");
        clickToElement(driver, "//a[contains(@class,'ico-register')]");

        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);
        sendKeyToElement(driver, "//input[@id='Email']", email);
        sendKeyToElement(driver, "//input[@id='Password']", "123456");
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
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
