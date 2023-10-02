package Automation.engine.config;

import Automation.utils.loggers.JavaLogger;
import Automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigFilePath {


    public static String GetConfigFilePath() {

        //String ConfigFilePath = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            //ParaModule = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "ParaModule", "value");
            JavaLogger.JavaInfo("Fetching ConfigFilePath configuration parameter : " + ConfigFilePath + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching ConfigFilePath configuration parameter : " + ConfigFilePath + " , from configuration file : " + ConfigFilePath, E);
        }
        return ConfigFilePath;
    }


    public static void main(String[] args) {
        System.out.println(GetConfigFilePath());
    }


}
