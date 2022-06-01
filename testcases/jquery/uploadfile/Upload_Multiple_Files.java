package jquery.uploadfile;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.JqueryUploadFile.HomePageObject;
import pageObjects.JqueryUploadFile.PageInitManager;

public class Upload_Multiple_Files extends BaseTest {

    WebDriver driver;

    HomePageObject homePageObject;

    PageInitManager pageInitManager;

    private String[] fileNames = {"image_1.jpg", "image_2.jpg", "image_3.jpg"};

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setup(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        homePageObject = pageInitManager.getHomePageObject(driver);
    }

    @Test
    public void uploadMultipleFiles() {
        homePageObject.uploadMultipleFiles(fileNames);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
