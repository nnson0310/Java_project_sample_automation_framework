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

}
