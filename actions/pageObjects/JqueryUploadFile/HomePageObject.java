package pageObjects.JqueryUploadFile;

import UploadFilePageUI.HomePageUI;
import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadMultipleFiles(String... fileNames) {

        String fullFileNames = "";
        for(String fileName: fileNames) {
            fullFileNames = fullFileNames + GlobalConstants.UPLOAD_FILE_LOCATION + fileName + "\n";
        }
        fullFileNames = fullFileNames.trim();
        System.out.println(fullFileNames);

        waitForElementVisible(driver, HomePageUI.addFilesButton);
        sendKeyToElement(driver, HomePageUI.uploadFilesInput, fullFileNames);

        waitForAllElementVisible(driver, HomePageUI.startUploadFilesButton);
        int startButtonNumber = getElementSize(driver, HomePageUI.startUploadFilesButton);
        for(int i = 1; i <= startButtonNumber; i++) {
            clickToElement(driver, HomePageUI.dynamicStartUploadFilesButton, String.valueOf(i));
        }

        int linkNumber = getElementSize(driver, HomePageUI.uploadedFileLinks);
        for(int i = 1; i <= linkNumber; i++) {
            isElementDisplayed(driver, HomePageUI.dynamicUploadedFileLinks, String.valueOf(i), fileNames[i-1]);
        }
    }

}
