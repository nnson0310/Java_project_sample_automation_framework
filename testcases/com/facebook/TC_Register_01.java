package com.facebook;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.com.facebook.PageInitManager;
import pageObjects.com.facebook.RegisterPageObject;

public class TC_Register_01 extends BaseTest {

    WebDriver driver;

    RegisterPageObject registerPageObject;

    PageInitManager pageInitManager;

    SoftAssert soft;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setup(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);

        registerPageObject = pageInitManager.getRegisterPageObject(driver);
    }

    @Test
    public void TC_01_Verify_Displayed_Elements() {

        log.info("Verify Displayed Elements - Step 01: Click register button");
        registerPageObject.clickRegisterButton();

        log.info("Verify Displayed Elements - Step 02: Vefiry if register email field is displayed");
        verifyTrue(registerPageObject.isRegEmailFieldDisplayed());
    }

//    @Test
//    public void TC_02_Verify_Undisplayed_In_Dom_Elements() {
//
//        //enter email address
//        registerPageObject.enterRegEmail("haha@gmail.com");
//        registerPageObject.sleepInSecond(2);
//
//        //verify that email confirmation field display
//        verifyTrue(registerPageObject.isRegEmailConfirmationDisplayed());
//
//        //clear email field
//        registerPageObject.enterRegEmail(" ");
//        registerPageObject.sleepInSecond(2);
//
//        //verify that email confirmation field disappear
//        verifyTrue(registerPageObject.isRegEmailConfirmationUnDisplayed());
//    }
//
//    @Test
//    public void TC_03_Verify_Undisplayed_Not_In_Dom_Elements() {
//        registerPageObject.closeRegisterPopup();
//
//        verifyTrue(registerPageObject.isRegEmailFieldUnDisplayed());
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
