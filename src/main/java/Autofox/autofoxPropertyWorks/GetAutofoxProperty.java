package Autofox.autofoxPropertyWorks;

import Automation.engine.loggers.EngineLogger;
import org.testng.Assert;

import static Automation.engine.propertyWorks.PropertiesReader.ReadProperty;

public class GetAutofoxProperty {


    public static String GetAutofoxPropertyValue(String PropertyFileName, String PropertyKey) {

        String AutofoxPropertyValue = null;
        try {
            String PropertyFilePath = AutofoxPropertyConnector.ConnectToAutofoxProperty(PropertyFileName);
            AutofoxPropertyValue = ReadProperty(PropertyFilePath).getProperty(PropertyKey);
            EngineLogger.EngineInfo("Getting property key : " + PropertyKey + "from property file : " + PropertyFileName);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to Get property key : " + PropertyKey + "from property file : " + PropertyFileName  , E);
            Assert.fail("Failed to Get property key : " + PropertyKey + "from property file : " + PropertyFileName  , E);
        }
            return AutofoxPropertyValue;
        }

        public static void main (String[]args){
            GetAutofoxPropertyValue("asd", "asd");
        }

    }

