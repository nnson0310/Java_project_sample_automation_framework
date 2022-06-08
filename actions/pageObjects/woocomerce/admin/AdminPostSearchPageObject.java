package pageObjects.woocomerce.admin;

import WoocomercePageUIs.admin.AdminPostCreatePageUI;
import WoocomercePageUIs.admin.AdminPostSearchPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminPostSearchPageObject extends BasePage {

    WebDriver driver;

    AdminPageGenerator adminPageGenerator;

    public AdminPostSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPostCreatePageObject openAdminPostCreatePage(WebDriver driver) {
        waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);

        return adminPageGenerator.getAdminPostCreatePageObject(driver);
    }

    public void enterKeywordIntoSearchTextBox(WebDriver driver, String postTitle) {
        waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXT_BOX);
        sendKeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXT_BOX, postTitle);
    }

    public void clickToSearchButton(WebDriver driver) {
        waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
    }

    public boolean isPostSearchResultDisplayed(WebDriver driver, String postTitle, String author) {
        waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_POST_SEARCH_RESULT, postTitle, author);
        return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_POST_SEARCH_RESULT, postTitle, author);
    }
}
