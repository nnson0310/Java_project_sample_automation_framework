package pageObjects;

import PageUIs.HomePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public void clickMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public boolean isLogoutLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
        return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
    }
}
