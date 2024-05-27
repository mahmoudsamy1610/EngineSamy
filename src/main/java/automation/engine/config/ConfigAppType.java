package automation.engine.config;

import automation.utils.loggers.JavaLogger;
import automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigAppType {

    public static String GetAppType() {

        String AppType = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            AppType = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "AppType", "value");
            JavaLogger.JavaInfo("Fetching AppType configuration parameter : " + AppType + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching AppType configuration parameter : " + AppType + " , from configuration file : " + ConfigFilePath, E);
        }
        return AppType;
    }


}
