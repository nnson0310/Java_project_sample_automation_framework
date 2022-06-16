package bankguru;

import commons.BaseTest;
import envConfig.Environment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TC_Multiple_Environments_Java_Project extends BaseTest {

    WebDriver driver;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void setUp(String browserName, String environment) {
        ConfigFactory.setProperty("env", environment);
        Environment env = ConfigFactory.create(Environment.class);

        System.out.println(env.appUrl());
        System.out.println(env.databasePassword());
        System.out.println(env.databaseUsername());

        driver = getBrowserDriver(browserName, env.appUrl());
    }

    @Test
    public void TC_01() {

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
