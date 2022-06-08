package WoocomercePageUIs.admin;

public class AdminPostSearchPageUI {

    public static final String ADD_NEW_POST_BUTTON = "css=a.page-title-action";

    public static final String SEARCH_TEXT_BOX = "css=input#post-search-input";

    public static final String SEARCH_BUTTON = "css=input#search-submit";

    public static final String TABLE_POST_SEARCH_RESULT = "xpath=//table//a[@class='row-title' and text()='%s']//ancestor::td//following-sibling::td[contains(@class, 'column-author')]/a[text()='%s']";

}
