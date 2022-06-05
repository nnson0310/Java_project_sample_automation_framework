package pageObjects.com.facebook;

import FacebookPageUIs.RegisterPageUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Register Button")
    public void clickRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.createNewAccountButton);
        clickToElement(driver, RegisterPageUI.createNewAccountButton);
    }

    @Step("Verify that register email input field is displayed")
    public boolean isRegEmailFieldDisplayed() {
        waitForElementVisible(driver, RegisterPageUI.regEmailInput);
        return isElementDisplayed(driver, RegisterPageUI.regEmailInput);
    }

    @Step("Verify that register email input field is undisplayed")
    public boolean isRegEmailFieldUnDisplayed() {
        waitForElementInvisible(driver, RegisterPageUI.regEmailInput);
        return isElementUndisplayed(driver, RegisterPageUI.regEmailConfirmInput);
    }

    @Step("Input {0} into email field of register form")
    public void enterRegEmail(String email) {
        waitForElementVisible(driver, RegisterPageUI.regEmailInput);
        sendKeyToElement(driver, RegisterPageUI.regEmailInput, email);
    }

    @Step("Verify that register email confirmation input field is displayed")
    public boolean isRegEmailConfirmationDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.regEmailConfirmInput);
    }

    @Step("Verify that register email confirmation input field is undisplayed")
    public boolean isRegEmailConfirmationUnDisplayed() {
        waitForElementInvisible(driver, RegisterPageUI.regEmailConfirmInput);
        return isElementUndisplayed(driver, RegisterPageUI.regEmailConfirmInput);
    }

    @Step("Close Register Popup")
    public void closeRegisterPopup() {
        waitForElementClickable(driver, RegisterPageUI.closeRegisterPopupButton);
        clickToElement(driver, RegisterPageUI.closeRegisterPopupButton);
    }

    @Step("Stop threads run in seconds")
    public void sleepInSecond(long seconds) {
        super.sleepInSecond(seconds);
    }

}
