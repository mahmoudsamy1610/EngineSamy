package Automation.engine;


import java.util.InputMismatchException;

import static Automation.engine.PropertiesReader.LoadProperty;

public class GetProperty {

        public static String GetPropertyValue(String PropertyFileName , String PropertyKey ) {

            String PropertyValue = null ;
            try {
           String PropertyFilePath = PropertiesConnector.ConnectToProperty(PropertyFileName);
                PropertyValue =  LoadProperty(PropertyFilePath).getProperty(PropertyKey); }

            catch (InputMismatchException IME) {IME.getMessage();
                System.out.println("Invalid input Engine property file path");}
            catch(Exception e){e.getMessage();
                System.out.println("Unknown Error while Sending Engine properties Path");}

            return PropertyValue;
        }


}
