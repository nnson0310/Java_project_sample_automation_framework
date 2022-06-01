package pageObjects.live.techpanda;

import pageObjects.live.techpanda.LoginPageObject;
import org.openqa.selenium.WebDriver;

public class PageInitManager {

    public static LoginPageObject getLoginPageObject(WebDriver driver) {
        return new LoginPageObject(driver);
    }

}
