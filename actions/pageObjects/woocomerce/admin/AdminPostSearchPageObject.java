package pageObjects.woocomerce.admin;

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
}
