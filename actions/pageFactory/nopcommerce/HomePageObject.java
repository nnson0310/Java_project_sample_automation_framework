package pageFactory.nopcommerce;

import NopCommercePageUIs.HomePageUI;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/*
* PageFactory là 1 design pattern tạo ra bởi project leader của Selenium
* Trong đó, tầng PageUI sẽ bị loại bỏ, đồng thời khai báo tất cả element
* của trong pageObject để quản lí. PageFactory sử dụng @FindBy, @FindBys
* annotation để thay thế driver.findElement()
* Ưu điểm:
* + che giấu việc tìm element, không còn hàm driver.findElement()
* + giúp cú pháp ngắn gọn hơn
* + bở bớt 1 layer pageUI khiến framework gọn nhẹ hơn
* + sử dụng @CacheLookup để tránh việc tìm lại element => tăng performance
* Nhược điểm
* + vì phải khai báo element trong pageObject => khiến code dài, khó bảo trì, k phù họp
* với những dự án lớn
* + k phù hợp với dynamic locator (text) vì @findBy không cung cấp việc tìm element
* bằng text
* + cacheLookup vô dụng khi DOM change, page reload khiến element thay đổi (với
* các công nghệ frontend hiện tại, element trong DOM thường xuyên bị update)
* + chỉ cung cấp 1 lựa chọn duy nhất khi sử dụng với explicitWait (các hàm
* của ExpectedConditions chỉ có thể sử dụng với tham số là WebElement)
* + chịu ảnh hưởng của hàm implicitWait khiến việc xác định element invisible
* rất tốn thời gian
* */
public class HomePageObject extends BasePageFactory {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    @CacheLookup
    private WebElement REGISTER_LINK;

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement MY_ACCOUNT_LINK;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement LOGOUT_LINK;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement LOGIN_LINK;

    public void clickRegisterLink() {
        waitForElementClickable(driver, REGISTER_LINK);
        clickToElement(driver, REGISTER_LINK);
    }

    public void clickLoginLink() {
        waitForElementClickable(driver, LOGIN_LINK);
        clickToElement(driver, LOGIN_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, MY_ACCOUNT_LINK);
    }

    public boolean isLogoutLinkDisplayed() {
        waitForElementVisible(driver, LOGOUT_LINK);
        return isElementDisplayed(driver, LOGOUT_LINK);
    }
}
