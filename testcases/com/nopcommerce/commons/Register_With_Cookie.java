package com.nopcommerce.commons;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nop.commerce.HomePageObject;
import pageObjects.nop.commerce.PageInitManager;
import pageObjects.nop.commerce.RegisterPageObject;
import utilities.DataFaker;

import java.util.Set;

public class Register_With_Cookie extends BaseTest {

    WebDriver driver;

    PageInitManager pageInitManager;

    RegisterPageObject registerPage;

    HomePageObject homePage;

    DataFaker dataFaker = DataFaker.getDataFaker();

    private String firstName, lastName, email, password;

    public static Set<Cookie> cookies;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void registerNewAccount(String browserName, String pageUrl) {

        firstName = dataFaker.getFirstName();

        lastName = dataFaker.getLastName();

        email = dataFaker.getEmail();

        password = "123456";

        driver = getBrowserDriver(browserName, pageUrl);

        registerPage = pageInitManager.getRegisterPageObject(driver);

        registerPage.inputFirstName(firstName);
        sleepInSeconds(2);

        registerPage.inputLastName(lastName);
        sleepInSeconds(2);

        registerPage.inputEmail(email);
        sleepInSeconds(2);

        registerPage.inputPassword(password);
        sleepInSeconds(2);

        registerPage.inputConfirmPassword(password);
        sleepInSeconds(2);

        homePage = registerPage.clickRegisterButton(driver);

        verifyTrue(registerPage.isRegisterSuccess());

        cookies = homePage.getAllCookies(driver);

        for(Cookie cookie : cookies) {
            System.out.println("Cookie name: " + cookie.getName() + " Cookie Value: " + cookie.getValue() + "\n");
        }

        driver.quit();
    }
}
