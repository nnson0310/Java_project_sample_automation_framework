package com.nopcommerce.commons;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nop.commerce.HomePageObject;
import pageObjects.nop.commerce.PageInitManager;
import pageObjects.nop.commerce.RegisterPageObject;
import java.util.Set;

public class Register_With_Cookie extends BaseTest {

    WebDriver driver;

    PageInitManager pageInitManager;

    RegisterPageObject registerPage;

    HomePageObject homePage;

    private String firstName, lastName, email, password;

    public static Set<Cookie> cookies;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void registerNewAccount(String browserName, String pageUrl) {

        firstName = "Thu";

        lastName = "Minh";

        email = "thuminh" + generateRandomNumber() + "@gmail.com";

        password = "123456";

        driver = getBrowserDriver(browserName, pageUrl);

        registerPage = pageInitManager.getRegisterPageObject(driver);

        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);

        homePage = registerPage.clickRegisterButton(driver);

        verifyTrue(registerPage.isRegisterSuccess());

        cookies = homePage.getAllCookies(driver);

        for(Cookie cookie : cookies) {
            System.out.println("Cookie name: " + cookie.getName() + " Cookie Value: " + cookie.getValue() + "\n");
        }

        driver.quit();
    }
}
