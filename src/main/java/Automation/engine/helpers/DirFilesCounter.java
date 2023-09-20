package Automation.engine.helpers;

import Automation.engine.loggers.JavaLogger;
import org.checkerframework.checker.units.qual.C;

import java.io.File;

public class DirFilesCounter {

    public static int CountDirFiles(String DirRelativePath) {
        JavaLogger.JavaInfo("Counting files at folder : " + DirRelativePath);

        int Count = 0;

        try {
            File Dir = new File(DirRelativePath);
            File[] files = Dir.listFiles();
            Count = files.length;

            if (files != null) {
                return Count;
            }

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Counting files at folder : " + DirRelativePath, E);
        }
        return Count;
    }

    public static void main(String[] args) {
        String folderPath = "src/main/java/Autofox/apais"; // Replace with your folder path
        int fileCount = CountDirFiles(folderPath);
        System.out.println("Number of files in the directory: " + fileCount);
    }


}
