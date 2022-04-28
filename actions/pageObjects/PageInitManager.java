package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageInitManager {

    public static HomePageObject getHomePageObject(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPageObject(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
        return new RegisterPageObject(driver);
    }
}
