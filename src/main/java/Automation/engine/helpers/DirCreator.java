package Automation.engine.helpers;

import Automation.engine.loggers.JavaLogger;
import org.checkerframework.checker.units.qual.C;

import java.io.File;

public class DirCreator {


    public static String CreateDir(String ParentDirRelativePath , String DirName) {
        JavaLogger.JavaInfo("Creating new Directory named : " + DirName+ " , at : "  +ParentDirRelativePath);

        try {

            String CreatedDirPath ;
            File Dir = new File(ParentDirRelativePath , DirName);

            if (!Dir.exists()) {
                boolean created = Dir.mkdirs();
                if (created) {
                    CreatedDirPath = ParentDirRelativePath + "\\" + DirName;
                    return CreatedDirPath;
                        }
            }else {
                    JavaLogger.JavaError("Directory required is already existing : " + ParentDirRelativePath);
                    throw new IllegalArgumentException();
                }

        }catch (Exception E){
            JavaLogger.JavaExceptionError("Failed Creating new Directory named : " + DirName+ " , at : "  +ParentDirRelativePath, E);
        }

        return null;

        }


    public static void main(String[] args) {
        CreateDir("src/test/resources" , "testSuites");

    }

    }


