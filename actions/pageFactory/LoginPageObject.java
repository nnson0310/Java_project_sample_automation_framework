package pageFactory;

import PageUIs.LoginPageUI;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {

    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='Email']")
    private WebElement EMAIL_TEXTBOX;

    @FindBy(xpath="//input[@id='Password']")
    private WebElement PASSWORD_TEXTBOX;

    @FindBy(xpath="//span[@id='Email-error']")
    private WebElement EMAIL_TEXTBOX_ERROR_MSG;

    @FindBy(xpath="//div[contains(@class, 'validation-summary-errors')]")
    private WebElement SUMMARY_VALIDATION_ERROR_MSG;

    @FindBy(xpath="//button[contains(@class,'login-button')]")
    private WebElement LOGIN_BUTTON;

    public void clickLoginButton() {
        waitForElementClickable(driver, LOGIN_BUTTON);
        clickToElement(driver, LOGIN_BUTTON);
    }

    public void inputEmailTextBox(String email) {
        waitForElementVisible(driver, EMAIL_TEXTBOX);
        sendKeyToElement(driver, EMAIL_TEXTBOX, email);
    }

    public void inputPasswordTextBox(String password) {
        waitForElementVisible(driver, PASSWORD_TEXTBOX);
        sendKeyToElement(driver, PASSWORD_TEXTBOX, password);
    }

    public String getEmailTextBoxErrorMessage() {
        waitForElementVisible(driver, EMAIL_TEXTBOX_ERROR_MSG);
        return getTextElement(driver, EMAIL_TEXTBOX_ERROR_MSG);
    }

    public String getSummaryValidationErrorMsg() {
        waitForElementVisible(driver, SUMMARY_VALIDATION_ERROR_MSG);
        return getTextElement(driver, SUMMARY_VALIDATION_ERROR_MSG);
    }
}
