package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nop.commerce.PageInitManager;
import pageObjects.nop.commerce.RegisterPageObject;

public class User_07_Apply_Pattern_Object extends BaseTest {

    WebDriver driver;

    PageInitManager pageInitManager;
    RegisterPageObject registerPage;

    public static String email, password;

    private String firstName, lastName;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void setup(String browserName, String pageUrl) {

        //user's credentials
        firstName = "Thu";
        lastName = "Minh";
        email = "thuminh" + generateRandomNumber() + "@gmail.com";
        password = "123456";

        driver = getBrowserDriver(browserName, pageUrl);

        registerPage = pageInitManager.getRegisterPageObject(driver);

    }

    @Test
    public void TC_01_Valid_Data() {

//        registerPage.checkToRadioCheckboxById(driver, "gender-female");
//
//        registerPage.clickToSelectByNameAttribute(driver, "DateOfBirthDay", "1");
//        registerPage.clickToSelectByNameAttribute(driver, "DateOfBirthMonth", "January");
//        registerPage.clickToSelectByNameAttribute(driver, "DateOfBirthYear", "1986");
//
//        registerPage.enterToInputByNameAttribute(driver, "FirstName", firstName);
//        registerPage.enterToInputByNameAttribute(driver, "LastName", lastName);
//        registerPage.enterToInputByNameAttribute(driver, "Email", email);
//
//        registerPage.enterToInputByNameAttribute(driver, "Password", password);
//        registerPage.enterToInputByNameAttribute(driver, "ConfirmPassword", password);
//
//        registerPage.clickToButtonById(driver, "register-button");
//
//        Assert.assertTrue(registerPage.isRegisterSuccess());
    }

//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        closeBrowserAndKillProcess();
//    }

}
