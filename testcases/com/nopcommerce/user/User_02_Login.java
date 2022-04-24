package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.util.Random;

public class User_02_Login extends BaseTest {

    private WebDriver driver;

    private HomePageObject homePage;

    private RegisterPageObject registerPage;

    private LoginPageObject loginPage;

    private String firstName, lastName, email, password;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browserName) {

        driver = getBrowserDriver(browserName);

        driver.get("https://demo.nopcommerce.com/");

        firstName = "Son";
        lastName = "Nguyen";
        email = "son" + generateRandomNumber() + "@gmail.com";
        password = "123456";

        //khoi tao doi tuong homePageObject
        homePage = new HomePageObject(driver);
        homePage.clickRegisterLink();

        //pre-conditon - set up registered account for login with registered email test case
        //moi lan chuyen page deu phai khoi tao pageObject moi
        registerPage = new RegisterPageObject(driver);

        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);

        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        registerPage.clickLogoutLink();
    }

    @Test
    public void Login_01_Empty_Data() {
        homePage.clickLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getEmailTextBoxErrorMessage(), "Please enter your email");
    }

    @Test
    public void Login_02_Invalid_Email() {
        homePage.clickLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputEmailTextBox("son@");
        loginPage.inputPasswordTextBox(password);

        Assert.assertEquals(loginPage.getEmailTextBoxErrorMessage(), "Wrong email");
    }

    @Test
    public void Login_03_Unregistered_Email() {
        homePage.clickLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputEmailTextBox("son@gmail.com");
        loginPage.inputPasswordTextBox("123456");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getSummaryValidationErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Registered_Email_And_Empty_Password() {
        homePage.clickLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputEmailTextBox(email);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getSummaryValidationErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_05_Registered_Email_And_Invalid_Password() {
        homePage.clickLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputEmailTextBox(email);
        loginPage.inputPasswordTextBox(email);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getSummaryValidationErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_06_Valid_Credentials() {
        homePage.clickLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputEmailTextBox(email);
        loginPage.inputPasswordTextBox(password);
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
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
