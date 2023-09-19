package Automation.engine.propertyWorks;


import Automation.engine.loggers.EngineLogger;

import java.util.InputMismatchException;

import static Automation.engine.propertyWorks.PropertiesReader.ReadProperty;

public class PropertyGetter {

        public static String GetPropertyValue(String PropertyFileName , String PropertyKey ) {
            //Loggers cannot be used here , as the Logger methods is using the properties library classes

            System.out.print("\u001B[34m"); //Blue
            System.out.println("Manual Logger Info : catching property key : " + PropertyKey+ " , from property file : " + PropertyFileName);
            System.out.print("\u001B[0m"); //default

            String PropertyValue = null;

            try {
                String  PropertyFilePath = PropertiesConnector.ConnectToProperty(PropertyFileName);
                PropertyValue =  ReadProperty(PropertyFilePath).getProperty(PropertyKey);
                
            } catch(Exception e){e.getMessage();
                System.out.println("Unknown Error while Sending Engine properties Path for " + PropertyFileName);}

            if (PropertyValue != null) {
                return PropertyValue;
            }else {
                System.out.print("\u001B[35m"); //Purple
                System.out.println("Manual Logger Error : Cannot find property key : " + PropertyKey+ " , from property file : " + PropertyFileName);
                System.out.print("\u001B[0m"); //default
                throw new NullPointerException();
            }
        }

    public static void main(String[] args) {
        try {
            System.out.println(GetPropertyValue("Environment", "HomeDev1"));
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

}
