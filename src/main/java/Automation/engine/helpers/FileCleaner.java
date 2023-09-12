package Automation.engine.helpers;

import java.io.File;

public class FileCleaner {

    public static void CleanFile (String FileRelativePath){

        try {
            File File = new File(FileRelativePath);

            if (File.exists()) {
                File.delete();
                System.out.println("File deleted successfully");
            }else{
                System.out.println("File path not found");
            }

        } catch (Exception E){
            System.out.println(E.getMessage());

        }

    }


    public static void main(String[] args) {
        CleanFile("src/main/resources/AutomationResources/TomlFiles/GridHubNodes/Linux/Chrome/LinuxchromeNode_631asdadsadsasd9.toml");
    }

}
