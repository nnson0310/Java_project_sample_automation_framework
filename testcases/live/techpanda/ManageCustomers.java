package live.techpanda;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.live.techpanda.HomePageObject;
import pageObjects.live.techpanda.LoginPageObject;
import pageObjects.live.techpanda.PageInitManager;

public class ManageCustomers extends BaseTest {

    WebDriver driver;

    HomePageObject homePageObject;

    LoginPageObject loginPageObject;

    PageInitManager pageInitManager;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setup(String browserName, String browserUrl) {
        driver = getBrowserDriver(browserName, browserUrl);
        loginPageObject = pageInitManager.getLoginPageObject(driver);

        String username = "user01";
        String password = "guru99com";

        loginPageObject.loginToAdminPanel("username", "login", username, password);

        homePageObject = new HomePageObject(driver);

        homePageObject.isAdminPanelDisplayed();
    }

    @Test
    public void filterCustomerByEmail() {

        String email = "automationfullstack@gmail.net";
        String emailField = "customerGrid_filter_email";
        String searchButton = "Search";
        String filterNameResult = "automation fullstack";
        String filterEmailResult = "automationfullstack@gmail.net";

        homePageObject.filterCustomerByEmail(searchButton, emailField, email, filterNameResult, filterEmailResult);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
