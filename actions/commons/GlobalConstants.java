package commons;

import java.io.File;

public class GlobalConstants {
    public static final int longTimeOut = 30;

    public static final int middleTimeOut = 15;

    public static final int shortTimeOut = 5;

    public static final int threadSleepMillis = 1000;

    public static final String uploadFileLocation = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;

}
