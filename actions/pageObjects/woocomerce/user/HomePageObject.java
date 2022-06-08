package pageObjects.woocomerce.user;

import WoocomercePageUIs.user.HomePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

    WebDriver driver;

    UserPageGenerator userPageGenerator;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterKeywordIntoSearchTextBox(WebDriver driver, String postTitle) {
        waitForElementVisible(driver, HomePageUI.SEARCH_TEXT_BOX);
        sendKeyToElement(driver, HomePageUI.SEARCH_TEXT_BOX, postTitle);
    }

    public UserSearchResultPageObject clickToSearchButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
        clickToElement(driver, HomePageUI.SEARCH_BUTTON);

        return userPageGenerator.getUserSearchResultPageObject(driver);
    }
}
