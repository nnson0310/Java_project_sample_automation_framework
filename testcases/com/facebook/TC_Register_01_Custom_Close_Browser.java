package com.facebook;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.com.facebook.PageInitManager;
import pageObjects.com.facebook.RegisterPageObject;

public class TC_Register_01_Custom_Close_Browser extends BaseTest {
    WebDriver driver;

    RegisterPageObject registerPageObject;

    PageInitManager pageInitManager;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setup(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);

        registerPageObject = pageInitManager.getRegisterPageObject(driver);

        //make beforeClass fails
//        Assert.assertTrue(false);
    }

    @Test
    public void TC_01_Verify_Displayed_Elements() {

        log.info("Verify Displayed Elements - Step 01: Click register button");
        registerPageObject.clickRegisterButton();

        log.info("Verify Displayed Elements - Step 02: Vefiry if register email field is displayed");
        Assert.assertTrue(registerPageObject.isRegEmailFieldDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
