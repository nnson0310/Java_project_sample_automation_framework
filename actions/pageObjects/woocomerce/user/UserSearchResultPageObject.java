package pageObjects.woocomerce.user;

import WoocomercePageUIs.user.HomePageUI;
import WoocomercePageUIs.user.UserSearchResultPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserSearchResultPageObject extends BasePage {

    WebDriver driver;

    public UserSearchResultPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchResultForHeaderDisplayed(WebDriver driver, String postTitle) {
        waitForElementVisible(driver, UserSearchResultPageUI.SEARCH_RESULT_HEADER, postTitle);
        return isElementDisplayed(driver, UserSearchResultPageUI.SEARCH_RESULT_HEADER, postTitle);
    }

    public boolean isSearchResultDisplayed(WebDriver driver, String postTitle, String username) {
        waitForElementVisible(driver, UserSearchResultPageUI.SEARCH_RESULT, postTitle, username);
        return isElementDisplayed(driver, UserSearchResultPageUI.SEARCH_RESULT, postTitle, username);
    }
}
