package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.nopcommerce.HomePageObject;
import pageFactory.nopcommerce.LoginPageObject;

import java.util.concurrent.TimeUnit;

public class User_02_Login_Page_Factory {

    private WebDriver driver;

    private HomePageObject homePage;

    private LoginPageObject loginPage;

    private String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

        driver = new FirefoxDriver();

        homePage = new HomePageObject(driver);

        driver.get("https://demo.nopcommerce.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_Empty_Data() {
        homePage.clickLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getEmailTextBoxErrorMessage(), "Please enter your email");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
