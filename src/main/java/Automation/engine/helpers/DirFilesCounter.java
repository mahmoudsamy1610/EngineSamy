package Automation.engine.helpers;

import java.io.File;

public class DirFilesCounter {

    public static int CountDirFiles(String DirRelativePath) {

      try {
          File Dir = new File(DirRelativePath);
          File[] files = Dir.listFiles();
          if (files != null) {
              return files.length;
          }
      }catch (IllegalArgumentException IAE){IAE.getMessage();}

        return 0;
        }

    public static void main(String[] args) {
        String folderPath = "src/main/java/Automation/engine/gridWorks/modules"; // Replace with your folder path
        int fileCount = CountDirFiles(folderPath);
        System.out.println("Number of files in the directory: " + fileCount);
    }


}
