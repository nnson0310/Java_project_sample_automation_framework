package commons;

import PageUIs.BasePageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.List;
import java.util.Set;

public class BasePage {

    private int explicitWaitTimeout = 20;

    public static BasePage getBasePage() {
        return new BasePage();
    }

    private WebDriverWait explicitWait;

    private JavascriptExecutor jsExecutor;

    private Actions action;

    private void sleepInSecond(int seconds) {
        try {
            Thread.sleep(seconds *  1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected void redirectBack(WebDriver driver) {
        driver.navigate().back();
    }

    protected void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void redirectToPage(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    protected void redirectForward(WebDriver driver) {
        driver.navigate().forward();
    }

    protected Alert waitForAlertPresent(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, explicitWaitTimeout);

        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        waitForAlertPresent(driver).accept();
    }

    protected void cancelAlert(WebDriver driver) {
        waitForAlertPresent(driver).dismiss();
    }

    protected void getAlertText(WebDriver driver) {
        waitForAlertPresent(driver).getText();
    }

    protected void sendKeyToAlert(WebDriver driver, String str) {
        waitForAlertPresent(driver).sendKeys(str);
    }

    protected void switchWindowById(WebDriver driver, String currentWindowId) {
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id : allWindowIds) {
            if (!id.equals(currentWindowId)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    protected void switchWindowByTitle(WebDriver driver, String tabTitle) {
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id : allWindowIds) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(tabTitle)) {
                break;
            }
        }
    }

    protected void closeAllExceptParentWindow(WebDriver driver, String parentWindowId) {
        Set<String> windowId = driver.getWindowHandles();

        for (String id : windowId) {
            if (!id.equals(parentWindowId)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentWindowId);
        }
    }

    private String getLocatorValue(String locator) {
        return locator.substring(locator.indexOf("=") + 1);
    }

    private By getByLocator(String locatorType) {
        By by = null;

        System.out.println("Locator is " + locatorType);

        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
            by = By.id(getLocatorValue(locatorType));
        }
        else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
            by = By.cssSelector(getLocatorValue(locatorType));
        }
        else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
            by = By.className(getLocatorValue(locatorType));
        }
        else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
            by = By.name(getLocatorValue(locatorType));
        }
        else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
            by = By.xpath(getLocatorValue(locatorType));
        }
        else {
            throw new RuntimeException("Locator type is invalid");
        }
        return by;
    }

    private WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    private List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    protected void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String str) {
        getElement(driver, locator).sendKeys(str);
    }

    protected void selectItemInDropDown(WebDriver driver, String locator, String text) {
        Select select = new Select(getElement(driver, locator));
        select.selectByVisibleText(text);
    }

    protected void getSelectedItemInDropDown(WebDriver driver, String locator) {
        Select select = new Select(getElement(driver, locator));

        select.getFirstSelectedOption();
    }

    protected boolean isDropdownMultiple(WebDriver driver, String locator) {
        Select select = new Select(getElement(driver, locator));

        return select.isMultiple();
    }

    protected void selectItemInCustomDropDown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);

        explicitWait =  new WebDriverWait(driver, explicitWaitTimeout);
        List<WebElement> elements = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for(WebElement element: elements) {
            if (element.getText().trim().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
                sleepInSecond(1);

                element.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    protected String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    protected String getTextElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    protected String getCssValue(WebDriver driver, String locator, String cssSelector) {
        return getElement(driver, locator).getCssValue(cssSelector);
    }

    protected String getHexColorFromRgbColor(String rgbaColor) {
        return Color.fromString(rgbaColor).asHex();
    }

    protected int getElementSize(WebDriver driver, String locator) {
        return getElements(driver, locator).size();
    }

    protected void checkCheckboxOrRadio(WebDriver driver, String locator) {
        List<WebElement> elements = getElements(driver, locator);

        for (WebElement element:  elements) {
            if (element.isSelected()) {
                element.click();
                break;
            }
        }
    }

    protected void uncheckCheckboxOrRadio(WebDriver driver, String locator) {
        List<WebElement> elements = getElements(driver, locator);

        for (WebElement element:  elements) {
            if (!element.isSelected()) {
                element.click();
                break;
            }
        }
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    protected boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    protected void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    protected void hoverToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    protected String getInnerText(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    protected void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void highlightElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    protected void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
    }

    protected void scrollToElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, explicitWaitTimeout);
        jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    protected String getElementValidationMessage(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    protected boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
        return status;
    }

    protected void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, explicitWaitTimeout);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForAllElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, explicitWaitTimeout);

        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    protected void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, explicitWaitTimeout);

        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    protected void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, explicitWaitTimeout);

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForAllElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, explicitWaitTimeout);

        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
    }

    public ComputersPageObject openComputersPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.headerMenuComputer);
        clickToElement(driver, BasePageUI.headerMenuComputer);
        return PageInitManager.getComputerPageObject(driver);
    }

    public BooksPageObject openBooksPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.headerMenuBooks);
        clickToElement(driver, BasePageUI.headerMenuBooks);
        return PageInitManager.getBooksPageObject(driver);
    }

    public ApparelPageObject openApparelPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.headerMenuApparel);
        clickToElement(driver, BasePageUI.headerMenuApparel);
        return PageInitManager.getApparelPageObject(driver);
    }

    public ElectronicsPageObject openElectronicsPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.headerMenuElectronics);
        clickToElement(driver, BasePageUI.headerMenuElectronics);
        return PageInitManager.getElectronicsPageObject(driver);
    }

    public GiftCardsPageObject openGiftCardsPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.headerMenuGiftCards);
        clickToElement(driver, BasePageUI.headerMenuGiftCards);
        return PageInitManager.getGiftCardsPageObject(driver);
    }

    public JewelryPageObject openJewelryPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.headerMenuJewelry);
        clickToElement(driver, BasePageUI.headerMenuJewelry);
        return PageInitManager.getJewelryPageObject(driver);
    }

    public DigitalDownloadsPageObject openDigitalDownloadsPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.headerMenuDigitalDownloads);
        clickToElement(driver, BasePageUI.headerMenuDigitalDownloads);
        return PageInitManager.getDigitalDownloadsPageObject(driver);
    }


}
