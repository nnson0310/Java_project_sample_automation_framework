package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ElectronicsPageObject extends BasePage {

    WebDriver driver;

    public ElectronicsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
