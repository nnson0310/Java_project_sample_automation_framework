package pageObjects.woocomerce.admin;

import WoocomercePageUIs.admin.AdminPostCreatePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminPostCreatePageObject extends BasePage {

    WebDriver driver;

    public AdminPostCreatePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterNewPostTitle(WebDriver driver, String postTitle) {
        waitForElementVisible(driver, AdminPostCreatePageUI.ADD_POST_TITLE_TEXTBOX);
        sendKeyToElement(driver, AdminPostCreatePageUI.ADD_POST_TITLE_TEXTBOX, postTitle);
    }

    public void enterNewPostBody(WebDriver driver, String postBody) {
        waitForElementClickable(driver, AdminPostCreatePageUI.PRE_ADD_POST_BODY_TEXTBOX);
        clickToElement(driver, AdminPostCreatePageUI.PRE_ADD_POST_BODY_TEXTBOX);
        sleepInSecond(1);

        waitForElementVisible(driver, AdminPostCreatePageUI.POST_ADD_POST_BODY_TEXTBOX);
        sendKeyToElement(driver, AdminPostCreatePageUI.POST_ADD_POST_BODY_TEXTBOX, postBody);
    }

    public void clickToPrePublishButton(WebDriver driver) {
        waitForElementClickable(driver, AdminPostCreatePageUI.PREVIEW_PUBLISH_BUTTON);
        clickToElement(driver, AdminPostCreatePageUI.PREVIEW_PUBLISH_BUTTON);
    }

    public void clickToConfirmPublishButton(WebDriver driver) {
        waitForElementClickable(driver, AdminPostCreatePageUI.CONFIRM_PUBLISH_BUTTON);
        clickToElement(driver, AdminPostCreatePageUI.CONFIRM_PUBLISH_BUTTON);
    }

    public boolean isPostPublishedNoticeDisplayed(WebDriver driver, String postPublishedNotice, String viewPostNotice) {
        waitForElementVisible(driver, AdminPostCreatePageUI.POST_PUBLISHED_NOTICE, postPublishedNotice, viewPostNotice);
        return isElementDisplayed(driver, AdminPostCreatePageUI.POST_PUBLISHED_NOTICE, postPublishedNotice, viewPostNotice);
    }
}
