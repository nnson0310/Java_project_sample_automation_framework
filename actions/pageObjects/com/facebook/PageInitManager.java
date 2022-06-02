package pageObjects.com.facebook;

import org.openqa.selenium.WebDriver;

public class PageInitManager {

    public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

}
