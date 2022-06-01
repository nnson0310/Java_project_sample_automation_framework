package net.jqueryscript;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.jqueryScript.TablePageObject;
import pageObjects.nop.commerce.PageInitManager;

public class Table extends BaseTest {

    WebDriver driver;

    PageInitManager pageInitManager;

    TablePageObject tablePageObject;

    String searchBoxName = "Country";
    String keyword = "Aruba";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setUp(String browserName, String browserUrl) {
        driver = getBrowserDriver(browserName, browserUrl);

        tablePageObject = PageInitManager.getTablePageObject(driver);
    }

//    @Test
//    public void switchPageByPaginationLink() {
//        tablePageObject.switchPagination("2");
//        tablePageObject.switchPagination("11");
//        tablePageObject.switchPagination("9");
//        tablePageObject.switchPagination("5");
//    }

//    @Test
//    public void filterData() {
//        driver.navigate().refresh();
//        tablePageObject.filterBySearchBox(searchBoxName, keyword);
//    }

    @Test
    public void getAllRowData() {
        tablePageObject.getAllRowData();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
