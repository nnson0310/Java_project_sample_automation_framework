package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nop.commerce.*;

public class User_04_Apply_Dynamic_Xpath extends BaseTest {

    WebDriver driver;
    PageInitManager pageInitManager;

    HomePageObject homePage;
    RegisterPageObject registerPage;
    CustomerInfoPageObject customerInfoPage;
    ChangePasswordPageObject changePasswordPage;
    OrdersPageObject ordersPage;
    AddressesPageObject addressesPage;

    String firstName, lastName, email, password;

    @Parameters({ "browser", "url"})
    @BeforeClass
    public void setUp(String browserUrl, String browserName) {
        driver = getBrowserDriver(browserUrl, browserName);

        pageInitManager = new PageInitManager();

        firstName = "Son";
        lastName = "Nguyen";
        email = "son" + generateRandomNumber() + "@gmail.com";
        password = "123456";

        //khoi tao doi tuong homePageObject
//        homePage = pageInitManager.getHomePageObject(driver);
        homePage.clickRegisterLink();

        //pre-conditon - set up registered account for login with registered email test case
        //moi lan chuyen page deu phai khoi tao pageObject moi
//        registerPage = pageInitManager.getRegisterPageObject(driver);

        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);

        registerPage.clickRegisterButton(driver);

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

//        homePage = pageInitManager.getHomePageObject(driver);
        homePage.clickMyAccountLink();
    }

    @Test
    public void TC_01_Switch_Page()
    {
        homePage.openPageByDynamicLocator(driver, "block-account-navigation", "Customer info");
        customerInfoPage = pageInitManager.getCustomerInfoPageObject(driver);

        customerInfoPage.openPageByDynamicLocator(driver, "block-account-navigation", "Addresses");
        addressesPage = pageInitManager.getAddressesPageObject(driver);

        addressesPage.openPageByDynamicLocator(driver, "block-account-navigation", "Orders");
        ordersPage = pageInitManager.getOrdersPageObject(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
