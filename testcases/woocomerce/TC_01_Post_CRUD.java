package woocomerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.woocomerce.admin.*;
import pageObjects.woocomerce.user.HomePageObject;
import pageObjects.woocomerce.user.UserPageGenerator;
import pageObjects.woocomerce.user.UserSearchResultPageObject;

public class TC_01_Post_CRUD extends BaseTest {

    WebDriver driver;

    String username = "tomanyeuem";
    String password = "tomanyeuem";
    String adminPostSearchPageUrl = "https://woocomerce.test/wp-admin/edit.php";
    String adminUrl, userUrl;

    String randomNum = String.valueOf(generateRandomNumber());
    String postTitle = "Automation " + randomNum;
    String postBody = "Post Body " + randomNum;
    String today = getToday();

    // Admin Page Objects
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    AdminPostSearchPageObject adminPostSearchPage;
    AdminPostCreatePageObject adminPostCreatePage;

    // User Page Objects
    HomePageObject homePage;
    UserSearchResultPageObject userSearchResultPage;

    //Page Generator
    AdminPageGenerator adminPageGenerator;
    UserPageGenerator userPageGenerator;

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void setup(String browserName, String adminUrl, String userUrl) {

        this.adminUrl = adminUrl;
        this.userUrl = userUrl;

        driver = getBrowserDriver(browserName, adminUrl);

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
        adminPostSearchPage = dashboardPage.openAdminPostSearchPageByUrl(driver, adminPostSearchPageUrl);

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

    @Test
    public void Post_02_Search_Post() {
        log.info("Post_02_Search_Post - Step 01: Open post search page ");
        adminPostSearchPage = adminPostCreatePage.openAdminPostSearchPageByUrl(driver, adminPostSearchPageUrl);

        log.info("Post_02_Search_Post - Step 02: Enter keyword into post_search textbox ");
        adminPostSearchPage.enterKeywordIntoSearchTextBox(driver, postTitle);

        log.info("Post_02_Search_Post - Step 03: Click search button ");
        adminPostSearchPage.clickToSearchButton(driver);

        log.info("Post_02_Search_Post - Step 04: Verify that corresponding post title: " + postTitle + " and author: " + username + " are displayed in table as search result");
        verifyTrue(adminPostSearchPage.isPostSearchResultDisplayed(driver, postTitle, username));

    }

    @Test
    public void Post_03_View_Post() {
        log.info("Post_03_View_Post - Step 01: Open user page ");
        homePage = adminPostSearchPage.openUserHomePageByUrl(driver, this.userUrl);

        log.info("Post_03_View_Post - Step 02: Enter post title: " + postTitle + " as keyword to search textbox ");
        homePage.enterKeywordIntoSearchTextBox(driver, postTitle);

        log.info("Post_03_View_Post - Step 03: Click search button ");
        userSearchResultPage = homePage.clickToSearchButton(driver);

        log.info("Post_03_View_Post - Step 04: Verify that 'Search Result For: " + postTitle + " ' is displayed");
        verifyTrue(userSearchResultPage.isSearchResultForHeaderDisplayed(driver, postTitle));

        log.info("Post_03_View_Post - Step 04: Verify that post title: " + postTitle + " author: " + username + " are all displayed");
        verifyTrue(userSearchResultPage.isSearchResultDisplayed(driver, postTitle, username));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }

}
