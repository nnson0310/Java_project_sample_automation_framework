package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    /*
    * Headless browser ám chỉ việc trình duyệt được chạy ngầm mà k hiển
    * thị giao diện. Chủ yếu dùng trong
    * + test UI frontend
    * + crawl data (data analyst...)
    * */
    private WebDriver driver;

    private String projectPath = System.getProperty("user.dir");

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }

    public WebDriver getBrowserDriver(String browserName, String browserUrl) {
        if (browserName.equals("firefox")) {
            // System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            // System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            //System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equals("h_firefox")) {
            // System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            //set up headless options for firefox browser
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1200");
            driver = new FirefoxDriver(options);
        }
        else if (browserName.equals("brave")) {
            // System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

            driver = new ChromeDriver(options);
        }
        else {
            throw new RuntimeException("Browser name is invalid");
        }

        driver.get(browserUrl);
        driver.manage().timeouts().implicitlyWait(GlobalConstants.shortTimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}
