package pageObjects;

import PageUIs.LoginPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public void inputEmailTextBox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public String getEmailTextBoxErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX_ERROR_MSG);
        return getTextElement(driver, LoginPageUI.EMAIL_TEXTBOX_ERROR_MSG);
    }

    public String getSummaryValidationErrorMsg() {
        waitForElementVisible(driver, LoginPageUI.SUMMARY_VALIDATION_ERROR_MSG);
        return getTextElement(driver, LoginPageUI.SUMMARY_VALIDATION_ERROR_MSG);
    }
}
