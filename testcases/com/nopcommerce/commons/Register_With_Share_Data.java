package com.nopcommerce.commons;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nop.commerce.PageInitManager;
import pageObjects.nop.commerce.RegisterPageObject;

public class Register_With_Share_Data extends BaseTest {

    WebDriver driver;

    PageInitManager pageInitManager;
    RegisterPageObject registerPage;

    public static String email, password;

    private String firstName, lastName;

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

        registerPage.clickRegisterButton(driver);

        verifyTrue(registerPage.isRegisterSuccess());

        driver.quit();
    }
}
