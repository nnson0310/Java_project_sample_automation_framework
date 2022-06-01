package pageObjects.live.techpanda;

import LiveTechPandaPageUIs.HomePageUI;
import LiveTechPandaPageUIs.LoginPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToAdminPanel(String usernameField, String passwordField, String username, String password) {
        waitForElementVisible(driver, LoginPageUI.credentialInputField, usernameField);
        sendKeyToElement(driver, LoginPageUI.credentialInputField, username, usernameField);

        waitForElementVisible(driver, LoginPageUI.credentialInputField, passwordField);
        sendKeyToElement(driver, LoginPageUI.credentialInputField, password, passwordField);

        waitForElementClickable(driver, LoginPageUI.loginButton);
        clickToElement(driver, LoginPageUI.loginButton);
    }
}
