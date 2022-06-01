package pageObjects.live.techpanda;

import LiveTechPandaPageUIs.HomePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void isAdminPanelDisplayed() {
        isElementDisplayed(driver, HomePageUI.adminPanelTitle);
    }

    public void filterCustomerByEmail(
            String dynamicFilterButtonName,
            String dynamicFilterFieldName,
            String email,
            String filterNameResult,
            String filterEmailResult
    ) {
        waitForElementVisible(driver, HomePageUI.customerGridFilter, dynamicFilterFieldName);
        sendKeyToElement(driver, HomePageUI.customerGridFilter, email, dynamicFilterFieldName);

        sleepInSecond(5);
        waitForElementClickable(driver, HomePageUI.filterButton, dynamicFilterButtonName);
        clickToElement(driver, HomePageUI.filterButton, dynamicFilterButtonName);

        isElementDisplayed(driver, HomePageUI.filterResult, filterNameResult, filterEmailResult);
    }
}
