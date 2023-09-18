package Automation.engine.propertyWorks;


import java.util.InputMismatchException;

import static Automation.engine.propertyWorks.PropertiesReader.ReadProperty;

public class PropertyGetter {

        public static String GetPropertyValue(String PropertyFileName , String PropertyKey ) {

            String PropertyValue = null ;
            try {
           String PropertyFilePath = PropertiesConnector.ConnectToProperty(PropertyFileName);
                PropertyValue =  ReadProperty(PropertyFilePath).getProperty(PropertyKey); }

            catch(Exception e){e.getMessage();
                System.out.println("Unknown Error while Sending Engine properties Path for " + PropertyFileName);}

            return PropertyValue;
        }


}
