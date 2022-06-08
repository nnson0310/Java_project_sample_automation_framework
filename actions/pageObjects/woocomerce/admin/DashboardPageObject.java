package pageObjects.woocomerce.admin;

import WoocomercePageUIs.admin.DashboardPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage {

    WebDriver driver;

    AdminPageGenerator adminPageGenerator;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPostSearchPageObject openAdminPostSearchPage(WebDriver driver) {
        waitForElementClickable(driver, DashboardPageUI.MENU_POSTS);
        clickToElement(driver, DashboardPageUI.MENU_POSTS);

        return adminPageGenerator.getPostSearchPageObject(driver);
    }
}
