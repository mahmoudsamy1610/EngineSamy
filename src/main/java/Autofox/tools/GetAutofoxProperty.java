package Autofox.tools;

import Automation.engine.PropertiesConnector;

import java.io.IOException;
import java.util.InputMismatchException;

import static Automation.engine.PropertiesReader.LoadProperty;

public class GetAutofoxProperty {


        public static String GetAutofoxPropertyValue(String PropertyFileName , String PropertyKey ) {

            String AutofoxPropertyValue = null;
            try {
            String PropertyFilePath = AutofoxPropertyConnector.ConnectToAutofoxProperty(PropertyFileName);
            AutofoxPropertyValue =  LoadProperty(PropertyFilePath).getProperty(PropertyKey); }

            catch (InputMismatchException IME) {IME.getMessage();
                System.out.println("Invalid input Autofox property file path");}
            catch(Exception e){e.getMessage();
                System.out.println("Unknown Error while Sending Autofox properties Path");}

            return AutofoxPropertyValue;

        }

}
