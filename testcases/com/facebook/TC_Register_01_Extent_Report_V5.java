package com.facebook;

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
import java.lang.reflect.Method;

public class TC_Register_01_Extent_Report_V5 extends BaseTest {

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

        registerPageObject.clickRegisterButton();

        Assert.assertTrue(registerPageObject.isRegEmailFieldDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
