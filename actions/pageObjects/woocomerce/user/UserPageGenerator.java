package pageObjects.woocomerce.user;

import org.openqa.selenium.WebDriver;

public class UserPageGenerator {

    public static HomePageObject getHomePageObject(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static UserSearchResultPageObject getUserSearchResultPageObject(WebDriver driver) {
        return new UserSearchResultPageObject(driver);
    }

}
