package commons;

import java.io.File;

public class GlobalConstants {
    public static final int longTimeOut = 20;

    public static final int shortTimeOut = 10;

    public static final int threadSleepMillis = 1000;

    public static final String uploadFileLocation = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;

}
