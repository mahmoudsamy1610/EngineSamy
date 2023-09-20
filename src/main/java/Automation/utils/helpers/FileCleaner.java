package Automation.utils.helpers;

import Automation.utils.loggers.JavaLogger;

import java.io.File;

public class FileCleaner {

    public static void CleanFile (String FileRelativePath){
        JavaLogger.JavaInfo("Deleting file from : " + FileRelativePath );

        try {
            File File = new File(FileRelativePath);
            if (File.exists()) {
                File.delete();
            }else{
                JavaLogger.JavaError("Cannot find the file at path : " + FileRelativePath);
                throw new NullPointerException();
            }

        } catch (Exception E){
            JavaLogger.JavaExceptionError("Failed deleting file from : " + FileRelativePath , E);
        }

    }


    public static void main(String[] args) {
        CleanFile("src/main/resources/AutomationResources/TomlFiles/GridHubNodes/Linux/Chrome/LinuxchromeNode_631asdadsadsasd9.toml");
    }

}
