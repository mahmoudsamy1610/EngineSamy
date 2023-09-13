package Autofox.autofoxPropertyWorks;

import Automation.engine.loggers.Loggers;
import lombok.extern.java.Log;
import org.testng.Assert;

import java.util.InputMismatchException;

import static Automation.engine.propertyWorks.PropertiesReader.LoadProperty;

public class AutofoxPropertyConnector {


    public static String ConnectToAutofoxProperty(String PropertyFileName) {

        String ConnectorProperty = null;
        try {

            ConnectorProperty = LoadProperty("src/main/resources/AutofoxResources/AutofoxPropertyPath.properties").getProperty(PropertyFileName);
            Loggers.Info("Connecting to Autofox property path collection and fetching property path of : " + PropertyFileName);

        } catch (Exception E) {
            Loggers.ExceptionError("Failed to find : " + PropertyFileName + " in Autofox property path collection", E);
            Assert.fail("Failed to find : " + PropertyFileName + " in Autofox property path collection", E);

        }
        return ConnectorProperty;
    }



    public static void main(String[] args) {
        ConnectToAutofoxProperty("asda") ;
    }

}
