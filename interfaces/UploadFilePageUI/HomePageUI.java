package UploadFilePageUI;

public class HomePageUI {

    public static final String uploadFilesInput = "css=input[type='file']";

    public static final String addFilesButton = "xpath=//span[contains(@class, 'fileinput-button')]//span[text()='Add files...']";

    public static final String dynamicStartUploadFilesButton = "xpath=//table//tr[%s]//td[4]//button[contains(@class,'start')]";

    public static final String uploadedFileLinks = "css=table p.name";

    public static final String dynamicUploadedFileLinks = "xpath=//table//tr[%s]//td[2]//p[@class='name']//a[text()='%s']";

    public static final String startUploadFilesButton = "css=table[role='presentation'] button.start";

}
