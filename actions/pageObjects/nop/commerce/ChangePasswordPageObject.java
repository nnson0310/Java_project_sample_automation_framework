package pageObjects.nop.commerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPageObject extends BasePage {
    WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
