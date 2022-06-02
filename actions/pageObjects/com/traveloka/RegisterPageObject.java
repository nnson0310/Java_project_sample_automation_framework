package pageObjects.com.traveloka;

import TravelokaPageUIs.RegisterPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterButton(String buttonName) {
        waitForElementVisible(driver, RegisterPageUI.registerButton, buttonName);
        clickToElement(driver, RegisterPageUI.registerButton, buttonName);
    }

}
