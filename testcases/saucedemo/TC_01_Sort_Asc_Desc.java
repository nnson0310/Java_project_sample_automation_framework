package saucedemo;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.saucedemo.InventoryPageObject;
import pageObjects.saucedemo.LoginPageObject;
import pageObjects.saucedemo.PageGeneratorManager;

public class TC_01_Sort_Asc_Desc extends BaseTest {

    WebDriver driver;

    private String username, password;

    LoginPageObject loginPage;

    InventoryPageObject inventoryPage;

    PageGeneratorManager pageGeneratorManager;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setUp(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);

        username = "standard_user";
        password = "secret_sauce";

        loginPage = pageGeneratorManager.getLoginPageObject(driver);
        loginPage.enterUsername(driver, username);
        loginPage.enterPassword(driver, password);
        inventoryPage = loginPage.clickLoginButton(driver);
    }

    @Test

    public void TC_01() {
        inventoryPage.sortBySelectDropdown(driver, "Name (Z to A)");
        verifyTrue(inventoryPage.isProductNameSortedDescending(driver));

        inventoryPage.sortBySelectDropdown(driver, "Name (A to Z)");
        verifyTrue(inventoryPage.isProductNameSortedAscending(driver));

    }

    @Test
    public void TC_02() {
        inventoryPage.sortBySelectDropdown(driver, "Price (high to low)");
        verifyTrue(inventoryPage.isProductPriceSortedDescending(driver));

        inventoryPage.sortBySelectDropdown(driver, "Price (low to high)");
        verifyTrue(inventoryPage.isProductPriceSortedAscending(driver));

    }

    @Test
    public void TC_03() {
        inventoryPage.sortBySelectDropdown(driver, "Price (high to low)");
        verifyTrue(inventoryPage.isProductPriceSortedAscending(driver));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
