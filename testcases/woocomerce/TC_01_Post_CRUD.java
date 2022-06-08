package woocomerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.woocomerce.admin.*;

public class TC_01_Post_CRUD extends BaseTest {

    WebDriver driver;

    String username = "tomanyeuem";
    String password = "tomanyeuem";

    String randomNum = String.valueOf(generateRandomNumber());
    String postTitle = "Automation " + randomNum;
    String postBody = "Post Body " + randomNum;

    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    AdminPostSearchPageObject adminPostSearchPage;
    AdminPostCreatePageObject adminPostCreatePage;
    AdminPageGenerator adminPageGenerator;

    @Parameters({"browser", "adminUrl"})
    @BeforeClass
    public void setup(String browserName, String pageUrl) {

        driver = getBrowserDriver(browserName, pageUrl);

        loginPage = adminPageGenerator.getLoginPageObject(driver);

        log.info("Pre-condition - Step 01: Input username " + username);
        loginPage.inputUsernameTextbox(driver, username);

        log.info("Pre-condition - Step 02: Input password " + password);
        loginPage.inputPasswordTextBox(driver, password);

        log.info("Pre-condition - Step 03: Click login button");
        dashboardPage = loginPage.clickLoginButton(driver);
    }

    @Test
    public void Post_01_Create_New_Post() {

        log.info("Post_01_Create_New_Post - Step 01: Open posts management page");
        adminPostSearchPage = dashboardPage.openAdminPostSearchPage(driver);

        log.info("Post_01_Create_New_Post - Step 02: Open add_new_post page");
        adminPostCreatePage = adminPostSearchPage.openAdminPostCreatePage(driver);

        log.info("Post_01_Create_New_Post - Step 03: Add post title");
        adminPostCreatePage.enterNewPostTitle(driver, postTitle);

        log.info("Post_01_Create_New_Post - Step 04: Add post body");
        adminPostCreatePage.enterNewPostBody(driver, postBody);

        log.info("Post_01_Create_New_Post - Step 05: Click pre-publish button");
        adminPostCreatePage.clickToPrePublishButton(driver);

        log.info("Post_01_Create_New_Post - Step 06: Click confirm-publish button");
        adminPostCreatePage.clickToConfirmPublishButton(driver);

        log.info("Post_01_Create_New_Post - Step 07: Verify 'post published' notice is displayed");
        verifyTrue(adminPostCreatePage.isPostPublishedNoticeDisplayed(driver, "Post published.", "View Post"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }

}
