package com.facebook;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

public class TC_Register_01_Allure_Report extends BaseTest {

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

    @Description("TC 01 - Verify register email input field display")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_01_Verify_Displayed_Elements(Method method) {

        registerPageObject.clickRegisterButton();

        Assert.assertFalse(registerPageObject.isRegEmailFieldDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
