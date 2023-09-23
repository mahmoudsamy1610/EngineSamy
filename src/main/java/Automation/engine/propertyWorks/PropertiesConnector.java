package Automation.engine.propertyWorks;
import Automation.engine.loggers.EngineLogger;

import java.util.InputMismatchException;

import static Automation.engine.propertyWorks.PropertiesReader.ReadProperty;

public class PropertiesConnector {

    public static String ConnectToProperty(String PropertyFileName) {
        //Loggers cannot be used here , as the Logger methods is using the properties library classes
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String ClassName = new Throwable().getStackTrace()[1].getClassName();

        System.out.print("\u001B[34m"); //Blue
        System.out.println("Manual Logger - Info "+ ClassName+" - "+Line+ " : Conneting property file : " + PropertyFileName);
        System.out.print("\u001B[0m"); //default

        try {
            String Property;
            Property = ReadProperty("src/main/resources/AutomationResources/PropertyFiles/PropertyPath.properties").getProperty(PropertyFileName);
            if (Property != null) {
                return Property;
            } else {
                System.out.print("\u001B[35m"); //Purple
                System.out.println("Manual Logger - Error : " + ClassName+" - "+Line+  " : Cannot connect on provided property file name is invalid : " + PropertyFileName);
                System.out.print("\u001B[0m"); //default
                throw new NullPointerException();
            }

        } catch (Exception E) {
            E.printStackTrace();
            System.out.print("\u001B[35m"); //Purple
            System.out.println("Manual Logger - Error : "+ ClassName+" - "+Line+ " : Failed connecting on provided property connector path is invalid : " + PropertyFileName);
            System.out.print("\u001B[0m"); //default
            return null;
        }
    }

    public static void main(String[] args) {
       System.out.println(ConnectToProperty("Environment1"));
    }

}
