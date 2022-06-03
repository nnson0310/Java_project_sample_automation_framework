package com.facebook;

import com.relevantcodes.extentreports.LogStatus;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.com.facebook.PageInitManager;
import pageObjects.com.facebook.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_Register_01_Extent_Report extends BaseTest {

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
    public void TC_01_Verify_Displayed_Elements(Method method) {

        ExtentTestManager.startTest(method.getName(), "Verify displayed elements");
        ExtentTestManager.getTest().log(LogStatus.INFO, method.getName() + " - Step 01: Click Register Button");
        registerPageObject.clickRegisterButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, method.getName() + " - Step 01: Verify register email field is displayed");
        Assert.assertFalse(registerPageObject.isRegEmailFieldDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
