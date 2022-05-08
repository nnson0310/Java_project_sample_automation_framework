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

    public static ComputersPageObject getComputerPageObject(WebDriver driver) {
        return new ComputersPageObject(driver);
    }

    public static ElectronicsPageObject getElectronicsPageObject(WebDriver driver) {
        return new ElectronicsPageObject(driver);
    }

    public static ApparelPageObject getApparelPageObject(WebDriver driver) {
        return new ApparelPageObject(driver);
    }

    public static BooksPageObject getBooksPageObject(WebDriver driver) {
        return new BooksPageObject(driver);
    }

    public static DigitalDownloadsPageObject getDigitalDownloadsPageObject(WebDriver driver) {
        return new DigitalDownloadsPageObject(driver);
    }

    public static JewelryPageObject getJewelryPageObject(WebDriver driver) {
        return new JewelryPageObject(driver);
    }

    public static GiftCardsPageObject getGiftCardsPageObject(WebDriver driver) {
        return new GiftCardsPageObject(driver);
    }

    public static CustomerInfoPageObject getCustomerInfoPageObject(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }

    public static AddressesPageObject getAddressesPageObject(WebDriver driver) {
        return new AddressesPageObject(driver);
    }

    public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {
        return new ChangePasswordPageObject(driver);
    }

    public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
        return new OrdersPageObject(driver);
    }

}
