package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class JewelryPageObject extends BasePage {

    WebDriver driver;

    public JewelryPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
