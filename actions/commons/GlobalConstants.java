package commons;

import java.io.File;

public class GlobalConstants {
    public static final int longTimeOut = 30;

    public static final int middleTimeOut = 15;

    public static final int shortTimeOut = 5;

    public static final int threadSleepMillis = 1000;

    public static final String projectPath = System.getProperty("user.dir");

    public static final String uploadFileLocation = projectPath + File.separator + "uploadFiles" + File.separator;

    public static final String reportNGCapturedScreenshot = projectPath + File.separator + "reportScreenshot" + File.separator + "reportNG" + File.separator;

    public static final String extentReportCapturedScreenshot = projectPath + File.separator + "reportScreenshot" + File.separator + "extentReport" + File.separator;

}
