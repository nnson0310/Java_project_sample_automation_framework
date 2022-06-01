package pageObjects.JqueryUploadFile;

import org.openqa.selenium.WebDriver;

public class PageInitManager {

    public static HomePageObject getHomePageObject(WebDriver driver) {
        return new HomePageObject(driver);
    }

}
