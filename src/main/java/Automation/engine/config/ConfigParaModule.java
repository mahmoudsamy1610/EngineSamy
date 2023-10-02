package Automation.engine.config;

import Automation.utils.loggers.JavaLogger;
import Automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigParaModule {

    public static String GetParaModule() {

        String ParaModule = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            ParaModule = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "ParaModule", "value");
            JavaLogger.JavaInfo("Fetching ParaModule configuration parameter : " + ParaModule + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching ParaModule configuration parameter : " + ParaModule + " , from configuration file : " + ConfigFilePath, E);
        }
        return ParaModule;
    }


    public static void main(String[] args) {
        System.out.println(GetParaModule());
    }

}
