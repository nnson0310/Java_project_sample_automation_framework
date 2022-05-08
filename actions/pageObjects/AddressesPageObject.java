package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressesPageObject extends BasePage {
    WebDriver driver;

    public AddressesPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
