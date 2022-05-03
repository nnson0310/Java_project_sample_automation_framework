package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class User_03_Switch_Between_Page extends BaseTest {

    WebDriver driver;
    PageInitManager pageInitManager;

    HomePageObject homePage;

    ComputersPageObject computersPage;

    ApparelPageObject apparelPage;

    BooksPageObject booksPage;

    GiftCardsPageObject giftCardsPage;

    ElectronicsPageObject electronicsPage;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageInitManager.getHomePageObject(driver);
    }

    @Test
    public void TC_01_Switch_Page()
    {
        computersPage = homePage.openComputersPage(driver);

        apparelPage = computersPage.openApparelPage(driver);

        booksPage = apparelPage.openBooksPage(driver);

        giftCardsPage = booksPage.openGiftCardsPage(driver);

        electronicsPage = giftCardsPage.openElectronicsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
