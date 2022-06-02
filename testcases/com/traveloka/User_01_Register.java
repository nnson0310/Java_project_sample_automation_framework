package com.traveloka;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.com.traveloka.PageInitManager;
import pageObjects.com.traveloka.RegisterPageObject;
import org.testng.asserts.SoftAssert;

@Listeners(commons.MethodListener.class)
public class User_01_Register extends BaseTest {

    WebDriver driver;

    RegisterPageObject registerPageObject;

    PageInitManager pageInitManager;

    SoftAssert soft;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setup(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        registerPageObject = pageInitManager.getRegisterPageObject(driver);
        soft = new SoftAssert();
    }

    /*
    * Khi su dung softAssert
    * ta can su dung ham assertAll de bat tat ca cac Exception
    * Soft Assert khac voi Hard Assert (thu vien mac dinh cua TestNG)
    * o cho: soft assert khong throw ra exception ngay lap tuc
    * ma van chay het test case
    * */
    public void User_01_Soft_Assert() {
        String buttonName = "Tham gia";
        registerPageObject.clickRegisterButton(buttonName);

        //fail
        checkTrue(isElementDisplayed("//div[text()='Mục bắt buộc..']"));

        //pass
        checkTrue(isElementDisplayed("//div[@aria-label='Hamburger Menu']//following-sibling::a/img"));

        //required
        soft.assertAll();
    }

    @Test
    public void User_02_Custom_Assert() {
        String buttonName = "Tham gia";
        registerPageObject.clickRegisterButton(buttonName);

        //fail
        verifyTrue(driver.findElement(By.xpath("//div[text()='Mục bắt buộc..']")).isDisplayed());

        //pass
        verifyTrue(driver.findElement(By.xpath("//div[@aria-label='Hamburger Menu']//following-sibling::a/img")).isDisplayed());
    }

    public boolean isElementDisplayed(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception = " + e.getMessage());
            return false;
        }
    }

    public boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            soft.assertTrue(condition);
        } catch (Throwable e) {
            System.out.println("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }

    public boolean checkFalse(boolean condition) {
        boolean pass = true;
        try {
            soft.assertFalse(condition);
        } catch (Throwable e) {
            System.out.println("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }

    public boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            soft.assertEquals(actual, expected);
        } catch (Throwable e) {
            System.out.println("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
