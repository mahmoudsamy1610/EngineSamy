package Automation.engine.helpers;

import java.io.File;

public class DirCleaner {

    public static void CleanDirFromFiles(String DirRelativePath) {

        try {

            File directory = new File(DirRelativePath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
        } catch (IllegalArgumentException IAE){IAE.getMessage();}
    }


    public static void CleanDirFromFolders(String DirRelativePath) {

        try {

            File directory = new File(DirRelativePath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        file.delete();
                    }
                }
            }
        } catch (IllegalArgumentException IAE){IAE.getMessage();}
    }

    public static void CleanDir(String DirRelativePath) {

        try {
            File directory = new File(DirRelativePath);
            File[] files = directory.listFiles();

                for (File file : files) {
                    if (file.isFile() || file.isDirectory()) {
                        file.delete();
                        System.out.println("good");

                    }
                }

        } catch (Exception E){
            E.printStackTrace();
            System.out.println("bad");
        }
    }




    public static void main(String[] args) {
        String dirPath = "1"; // Replace with your directory path
        CleanDir(dirPath);
        System.out.println("cleaned");
    }

}
