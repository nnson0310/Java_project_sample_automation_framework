package com.nopcommerce.user;

import com.nopcommerce.commons.Register_With_Share_Data;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.nop.commerce.HomePageObject;
import pageObjects.nop.commerce.LoginPageObject;
import pageObjects.nop.commerce.PageInitManager;
import pageObjects.nop.commerce.RegisterPageObject;

public class User_05_Login_With_Share_Data extends BaseTest {

    private WebDriver driver;

    private RegisterPageObject registerPage;

    private PageInitManager pageInitManager;

    private LoginPageObject loginPage;

    private HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setUp(String browserName, String pageUrl) {

        pageUrl = "https://demo.nopcommerce.com/login";
        driver = getBrowserDriver(browserName, pageUrl);

    }

    @Test
    public void Login_01_Valid_Email_Valid_Password() {
        loginPage = pageInitManager.getLoginPageObject(driver);

        loginPage.inputEmailTextBox(Register_With_Share_Data.email);

        loginPage.inputPasswordTextBox(Register_With_Share_Data.password);

        loginPage.clickLoginButton();

        homePage = pageInitManager.getHomePageObject(driver);

        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
