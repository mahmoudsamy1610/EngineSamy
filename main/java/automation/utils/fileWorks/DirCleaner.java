package automation.utils.fileWorks;

import automation.utils.loggers.JavaLogger;

import java.io.File;

public class DirCleaner {

    public static void CleanDirFromFiles(String DirRelativePath) {
        JavaLogger.JavaInfo("Cleaning Directory on : " + DirRelativePath);

        try {

            File directory = new File(DirRelativePath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                        JavaLogger.JavaInfo("Cleaning file : " +file.getName()+ " , from directory" + DirRelativePath);
                    }
                }
            } else {
                JavaLogger.JavaInfo("cannot find directory  to clean : " + DirRelativePath);
                throw new NullPointerException();
            }

        } catch (Exception E) {
            E.printStackTrace();
            JavaLogger.JavaExceptionError("Failed cleaning Directory at : " + DirRelativePath, E);
        }
    }


    public static void CleanDirFromFolders(String DirRelativePath) {
        JavaLogger.JavaInfo("Cleaning all folders inside Directory on : " + DirRelativePath);

        try {

            File directory = new File(DirRelativePath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        file.delete();
                        JavaLogger.JavaInfo("Cleaning folder : " +file.getName()+ " , from directory" + DirRelativePath);
                    }
                }
            }else {
                JavaLogger.JavaInfo("cannot find directory to clean folders inside : " + DirRelativePath);
                throw new NullPointerException();
            }
        } catch (Exception E){
            E.printStackTrace();
            JavaLogger.JavaExceptionError("Failed cleaning folders inside Directory at : " + DirRelativePath, E);
        }
    }

    public static void CleanDir(String DirRelativePath) {
        JavaLogger.JavaInfo("Cleaning Directory on : " + DirRelativePath);

        try {
            File directory = new File(DirRelativePath);
            File[] files = directory.listFiles();

                for (File file : files) {
                    if (file.isFile() || file.isDirectory()) {
                        file.delete();
                        JavaLogger.JavaInfo("Cleaning file : " +file.getName()+ " , from directory" + DirRelativePath);
                    }else {
                        JavaLogger.JavaInfo("cannot find directory to clean : " + DirRelativePath);
                        throw new NullPointerException();
                    }
                }
        } catch (Exception E){
            E.printStackTrace();
            JavaLogger.JavaExceptionError("Failed cleaning Directory at : " + DirRelativePath, E);
        }
    }




    public static void main(String[] args) {
        String dirPath = "1"; // Replace with your directory path
        CleanDir("src/test/resources/testReports");
        System.out.println("cleaned");
    }

}
