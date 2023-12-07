package automation.utils.fileWorks;

import automation.utils.loggers.JavaLogger;

import java.io.File;

public class FileNameGetter {

    public static String GetFileName(String FileRelativePath) {
        JavaLogger.JavaInfo("Getting file name of : " + FileRelativePath);

        try {
            String FileName;
            File file = new File(FileRelativePath);
            FileName = file.getName();
            return FileName;

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed getting file name of : " + FileRelativePath , E);
        }

        return null;
    }
}