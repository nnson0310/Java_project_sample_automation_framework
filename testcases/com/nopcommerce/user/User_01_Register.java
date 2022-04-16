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

public class User_01_Register extends BasePage {

    String projectPath = System.getProperty("user.dir");
    WebDriver driver;
//    BasePage basePage;
    String firstName = "Nguyen";
    String lastName = "Son";
    String email = "son" + generateRandomNumber() + "@gmail.com";
    String password = "123456";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

    //        basePage = new BasePage();
    //        basePage = getBasePage();

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

        Assert.assertEquals(getTextElement(driver, "//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(getTextElement(driver, "//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password is required.");
        Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
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

        Assert.assertEquals(getTextElement(driver, "//div[contains(@class, 'validation-summary-errors')]"), "Wrong email");
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

        Assert.assertEquals(getTextElement(driver, "//div[@class = 'result']"), "Your registration completed");
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

        Assert.assertEquals(getTextElement(driver, "//div[contains(@class, 'message-error')]"), "The specified email already exists");
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

        Assert.assertEquals(getTextElement(driver, "//span[contains(@class, 'field-validation-error')]"),
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

        Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"),
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
