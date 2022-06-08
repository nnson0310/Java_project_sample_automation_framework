package pageObjects.woocomerce.admin;

import WoocomercePageUIs.admin.LoginPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    WebDriver driver;

    AdminPageGenerator adminPageGenerator;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsernameTextbox(WebDriver driver, String username) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
    }

    public void inputPasswordTextBox(WebDriver driver, String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public DashboardPageObject clickLoginButton(WebDriver driver) {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return adminPageGenerator.getDashboardPageObject(driver);
    }
}
