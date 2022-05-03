package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class BooksPageObject extends BasePage {

    WebDriver driver;

    public BooksPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
