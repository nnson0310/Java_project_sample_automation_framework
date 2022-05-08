package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class OrdersPageObject extends BasePage {
    WebDriver driver;

    public OrdersPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
