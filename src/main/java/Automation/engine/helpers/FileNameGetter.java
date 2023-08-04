package Automation.engine.helpers;

import java.io.File;

public class FileNameGetter {

    public static String GetFileName(String FileRelativePath) {

        try {
            String FileName;
            File file = new File(FileRelativePath);
            FileName = file.getName();
            return FileName;

        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while Getting the file name");
        }

        return null;
    }
}