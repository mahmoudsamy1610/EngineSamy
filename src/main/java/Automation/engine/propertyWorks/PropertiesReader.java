package Automation.engine.propertyWorks;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties ReadProperty(String Path ) {
        //Loggers cannot be used here , as the Logger methods is using the properties library classes
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String ClassName = new Throwable().getStackTrace()[1].getClassName();

        System.out.print("\u001B[32m"); //Green
        System.out.println("Manual Logger - info : "+ ClassName+" - "+Line+ " : Reading property file from path : " + Path);
        System.out.print("\u001B[0m"); //default

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(Path));
            return properties;

        } catch (Exception  E) {
            E.printStackTrace();
            System.out.print("\u001B[31m"); //Red
            System.out.println("Manual Logger - Error : "+ ClassName+" - "+Line+ " : Cannot read provided Property Path is invalid : " + Path);
            System.out.print("\u001B[0m"); //default

            }
        return null;
    }

    public static void main(String[] args) {
        ReadProperty("src/main/resources/AutomationResources/PropertyFiles/Environment.properties1");
    }

}
