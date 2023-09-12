package Automation.engine.helpers;

import org.checkerframework.checker.units.qual.C;

import java.io.File;

public class DirCreator {


    public static String CreateDir(String ParentDirRelativePath , String DirName) {


        try {

            String CreatedDirPath ;

            File Dir = new File(ParentDirRelativePath , DirName);
            if (!Dir.exists()) {
                boolean created = Dir.mkdirs();
                if (created) {
                    CreatedDirPath = ParentDirRelativePath+"\\"+DirName;
                    System.out.println("Directory created successfully: " + CreatedDirPath);
                    return CreatedDirPath ;
                } else {
                    System.err.println("Failed to create directory: ");
                }
            } else {
                System.out.println("Directory already exists: ");
            }
        }catch (IllegalArgumentException IAE){IAE.getMessage();}

        return null;

        }


    public static void main(String[] args) {
        CreateDir("AllureResults" , "_Test2");

    }

    }


