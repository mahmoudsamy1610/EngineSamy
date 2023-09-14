package Autofox.autofoxPropertyWorks;

import Automation.engine.loggers.Loggers;
import org.testng.Assert;

import static Automation.engine.propertyWorks.PropertiesReader.ReadProperty;

public class AutofoxPropertyConnector {


    public static String ConnectToAutofoxProperty(String PropertyFileName) {

        String ConnectorProperty = null;
        try {

            ConnectorProperty = ReadProperty("src/main/resources/AutofoxResources/AutofoxPropertyPath.properties").getProperty(PropertyFileName);
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
