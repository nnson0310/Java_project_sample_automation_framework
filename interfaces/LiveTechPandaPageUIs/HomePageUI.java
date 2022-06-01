package LiveTechPandaPageUIs;

public class HomePageUI {
    public static final String adminPanelTitle = "xpath=//div[@id='page:main-container']//h3[text()='Manage Customers']";

    public static final String customerGridFilter = "xpath=//tr[@class='filter']//input[@id='%s']";

    public static final String filterButton = "xpath=//td[contains(@class, 'filter-actions')]//button[@title='%s']";

    public static final String filterResult = "xpath=//td[contains(text(), '%s')]//following-sibling::td[contains(text(),'%s')]";
}
