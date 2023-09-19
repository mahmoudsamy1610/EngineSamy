package Automation.engine.propertyWorks;

import Automation.engine.loggers.CoreJavaLogger;
import Automation.engine.loggers.EngineLogger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties ReadProperty(String Path ) {
        //Loggers cannot be used here , as the Logger methods is using the properties library classes

        System.out.print("\u001B[32m"); //Green
        System.out.println("Manual Logger info : Streaming property file from path : " + Path);
        System.out.print("\u001B[0m"); //default


        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(Path));
            return properties;

        } catch (Exception  E) {
            E.printStackTrace();
            System.out.print("\u001B[31m"); //Red
            System.out.println("Manual Logger Error : Provided Property Path is invalid : " + Path);
            System.out.print("\u001B[0m"); //default

            }
        return null;
    }

    public static void main(String[] args) {
        ReadProperty("src/main/resources/AutomationResources/PropertyFiles/Environment.properties1");
    }

}
