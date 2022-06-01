package pageObjects.nop.commerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ComputersPageObject extends BasePage {

    WebDriver driver;

    public ComputersPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
