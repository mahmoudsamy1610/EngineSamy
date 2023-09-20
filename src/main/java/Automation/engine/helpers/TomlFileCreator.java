package Automation.engine.helpers;

import Automation.engine.loggers.JavaLogger;

import java.io.FileWriter;


public class TomlFileCreator {

        public static void CreateToml(String Content , String TomlRelativePath) {

            JavaLogger.JavaInfo("Creating TOML file at : " + TomlRelativePath);

            try {
                    FileWriter writer = new FileWriter(TomlRelativePath) ;
                    writer.write(Content);
                } catch (Exception E) {
                    JavaLogger.JavaExceptionError("Failed creating TOML file at : " + TomlRelativePath , E);
                }

            }
    }


