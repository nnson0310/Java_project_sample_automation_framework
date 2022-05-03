package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ApparelPageObject extends BasePage {

    WebDriver driver;

    public ApparelPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
