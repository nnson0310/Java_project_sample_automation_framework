package JqueryScriptPageUIs;

public class TablePageUI {

    public static final String paginationLink = "xpath=//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link']";

    public static final String paginationDynamicLink = "xpath=//li[@class='qgrd-pagination-page']//a[contains(@class, 'qgrd-pagination-page-link') and text()='%s']";

    public static final String activePaginationLink = "xpath=//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";

    public static final String tableSearchBox = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";

    public static final String filterResult = "xpath=//td[@data-key='country' and text()='%s']//parent::tr";

    public static final String row = "css=tr";

    public static final String col = "css=th";
}
