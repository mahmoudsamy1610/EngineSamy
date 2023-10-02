package Automation.engine.config;

import Automation.utils.loggers.JavaLogger;
import Automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigTestEnvironment {

    public static String GetTestEnvironment() {

        String TestEnvironment = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            TestEnvironment = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "Environment", "value");
            JavaLogger.JavaInfo("Fetching TestEnvironment configuration parameter : " + TestEnvironment + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching TestEnvironment configuration parameter : " + TestEnvironment + " , from configuration file : " + ConfigFilePath, E);
        }
        return TestEnvironment;
    }


    public static void main(String[] args) {
        System.out.println(GetTestEnvironment());
    }

}
