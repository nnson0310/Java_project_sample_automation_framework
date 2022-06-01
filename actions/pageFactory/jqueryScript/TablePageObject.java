package pageFactory.jqueryScript;

import JqueryScriptPageUIs.TablePageUI;
import com.google.gson.Gson;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TablePageObject extends BasePage {

    WebDriver driver;

    public TablePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchPagination(String page) {
        waitForElementClickable(driver, TablePageUI.paginationDynamicLink, page);
        clickToElement(driver, TablePageUI.paginationDynamicLink, page);

        isElementDisplayed(driver, TablePageUI.activePaginationLink, page);
    }

    public void filterBySearchBox(String searchBoxName, String keyword) {
        waitForElementVisible(driver, TablePageUI.tableSearchBox, searchBoxName);
        sendKeyToElement(driver, TablePageUI.tableSearchBox, keyword, searchBoxName);
        pressEnterButton(driver);
        isElementDisplayed(driver, TablePageUI.filterResult, keyword);
    }

    public void getAllRowData() {
        waitForAllElementVisible(driver, TablePageUI.row);

        int numberOfRows = getElementSize(driver, TablePageUI.row);
        int numberOfCols = getElementSize(driver, TablePageUI.col);

        List<String> tableData = new ArrayList<String>();

        int numberOfPages = getElementSize(driver, TablePageUI.paginationLink);

        for(int i = 1; i <= numberOfPages; i++) {
            clickToElement(driver, TablePageUI.paginationDynamicLink, String.valueOf(i));

            List<WebElement> allRows = getElements(driver, TablePageUI.row);

            for (WebElement row : allRows) {
                tableData.add(row.getText());
            }
        }

        System.out.println(tableData);

    }

}
