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
        waitForElementClickable(driver, HomePageUI.Register_Link);
        clickToElement(driver, HomePageUI.Register_Link);
    }
}
