package automation.engine.config;

import automation.utils.loggers.JavaLogger;
import automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigAppDriver {

    public static String ConfigureAppDriver() {

        String AppDriver = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            AppDriver = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "AppDriver", "value");
            JavaLogger.JavaInfo("Fetching AppDriver configuration parameter : " + AppDriver + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching AppType configuration parameter : " + AppDriver + " , from configuration file : " + ConfigFilePath, E);
        }
        return AppDriver;
    }
}


