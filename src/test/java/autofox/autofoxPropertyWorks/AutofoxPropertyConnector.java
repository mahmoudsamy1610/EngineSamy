package autofox.autofoxPropertyWorks;

import automation.utils.loggers.EngineLogger;
import org.testng.Assert;

import static automation.utils.propertyWorks.PropertiesReader.ReadProperty;

public class AutofoxPropertyConnector {


    public static String ConnectToAutofoxProperty(String PropertyFileName) {

        String ConnectorProperty = null;
        try {

            ConnectorProperty = ReadProperty("src/test/resources/propertyFiles/AutofoxPropertyPath.properties").getProperty(PropertyFileName);
            EngineLogger.EngineInfo("Connecting to Autofox property path collection and fetching property path of : " + PropertyFileName);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to find : " + PropertyFileName + " in Autofox property path collection", E);
            Assert.fail("Failed to find : " + PropertyFileName + " in Autofox property path collection", E);

        }
        return ConnectorProperty;
    }



    public static void main(String[] args) {
        ConnectToAutofoxProperty("asda") ;
    }

}
