package com.nopcommerce.user;

import com.nopcommerce.commons.Register_With_Cookie;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.nop.commerce.HomePageObject;
import pageObjects.nop.commerce.LoginPageObject;
import pageObjects.nop.commerce.PageInitManager;
import pageObjects.nop.commerce.RegisterPageObject;

import java.util.Set;

public class User_06_Login_With_Cookie extends BaseTest {

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

        loginPage.setCookies(driver, Register_With_Cookie.cookies);

        loginPage.refreshCurrentPage(driver);

        homePage = pageInitManager.getHomePageObject(driver);

        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
