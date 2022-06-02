package pageObjects.com.facebook;

import FacebookPageUIs.RegisterPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.createNewAccountButton);
        clickToElement(driver, RegisterPageUI.createNewAccountButton);
    }

    public boolean isRegEmailFieldDisplayed() {
        waitForElementVisible(driver, RegisterPageUI.regEmailInput);
        return isElementDisplayed(driver, RegisterPageUI.regEmailInput);
    }

    public boolean isRegEmailFieldUnDisplayed() {
        waitForElementInvisible(driver, RegisterPageUI.regEmailInput);
        return isElementUndisplayed(driver, RegisterPageUI.regEmailConfirmInput);
    }

    public void enterRegEmail(String email) {
        waitForElementVisible(driver, RegisterPageUI.regEmailInput);
        sendKeyToElement(driver, RegisterPageUI.regEmailInput, email);
    }

    public boolean isRegEmailConfirmationDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.regEmailConfirmInput);
    }
    public boolean isRegEmailConfirmationUnDisplayed() {
        waitForElementInvisible(driver, RegisterPageUI.regEmailConfirmInput);
        return isElementUndisplayed(driver, RegisterPageUI.regEmailConfirmInput);
    }


    public void closeRegisterPopup() {
        waitForElementClickable(driver, RegisterPageUI.closeRegisterPopupButton);
        clickToElement(driver, RegisterPageUI.closeRegisterPopupButton);
    }

    public void sleepInSecond(long seconds) {
        super.sleepInSecond(seconds);
    }

}
