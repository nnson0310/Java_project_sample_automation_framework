package pageObjects.nop.commerce;

import NopCommercePageUIs.RegisterPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageObject clickRegisterButton(WebDriver driver) {
        waitForElementClickable(driver, RegisterPageUI.Register_Button);
        clickToElement(driver, RegisterPageUI.Register_Button);

        return new HomePageObject(driver);
    }

    public String getFirstNameInputErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.FirstName_Input_Error_Msg);
        return getElementText(driver, RegisterPageUI.FirstName_Input_Error_Msg);
    }

    public String getLastNameInputErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.LastName_Input_Error_Msg);
        return getElementText(driver, RegisterPageUI.LastName_Input_Error_Msg);
    }

    public String getEmailInputErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.Email_Input_Error_Msg);
        return getElementText(driver, RegisterPageUI.Email_Input_Error_Msg);
    }

    public String getPasswordInputErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.Password_Input_Error_Msg);
        return getElementText(driver, RegisterPageUI.Password_Input_Error_Msg);
    }

    public String getConfirmPasswordInputErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.ConfirmPassword_Input_Error_Msg);
        return getElementText(driver, RegisterPageUI.ConfirmPassword_Input_Error_Msg);
    }

    public void inputFirstName(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FirstName_Input);
        sendKeyToElement(driver, RegisterPageUI.FirstName_Input, firstName);
    }

    public void inputLastName(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LastName_Input);
        sendKeyToElement(driver, RegisterPageUI.LastName_Input, lastName);
    }

    public void inputEmail(String email) {
        waitForElementVisible(driver, RegisterPageUI.Email_Input);
        sendKeyToElement(driver, RegisterPageUI.Email_Input, email);
    }

    public void inputPassword(String password) {
        waitForElementVisible(driver, RegisterPageUI.Password_Input);
        sendKeyToElement(driver, RegisterPageUI.Password_Input, password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.ConfirmPassword_Input);
        sendKeyToElement(driver, RegisterPageUI.ConfirmPassword_Input, confirmPassword);
    }

    public String getSummaryValidationErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.Summary_Validation_Error_Msg);
        return getElementText(driver, RegisterPageUI.Summary_Validation_Error_Msg);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, RegisterPageUI.Register_Success_Msg);
        return getElementText(driver, RegisterPageUI.Register_Success_Msg);
    }

    public boolean isRegisterSuccess() {
        waitForElementVisible(driver, RegisterPageUI.Register_Success_Msg);
        return isElementDisplayed(driver, RegisterPageUI.Register_Success_Msg);
    }

    public void clickLogoutLink() {
        waitForElementClickable(driver, RegisterPageUI.Logout_Link);
        clickToElement(driver, RegisterPageUI.Logout_Link);
    }
}
