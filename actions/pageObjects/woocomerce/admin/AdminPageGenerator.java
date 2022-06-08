package pageObjects.woocomerce.admin;

import org.openqa.selenium.WebDriver;

public class AdminPageGenerator {

    public static LoginPageObject getLoginPageObject(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
        return new DashboardPageObject(driver);
    }

    public static AdminPostSearchPageObject getPostSearchPageObject(WebDriver driver) {
        return new AdminPostSearchPageObject(driver);
    }

    public static AdminPostCreatePageObject getAdminPostCreatePageObject(WebDriver driver) {
        return new AdminPostCreatePageObject(driver);
    }
}
