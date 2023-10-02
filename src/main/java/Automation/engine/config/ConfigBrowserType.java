package Automation.engine.config;

import Automation.utils.loggers.JavaLogger;
import Automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigBrowserType {

    public static String GetBrowserType() {

        String BrowserType = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            BrowserType = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "BrowserType", "value");
            JavaLogger.JavaInfo("Fetching BrowserType configuration parameter : " + BrowserType + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching BrowserType configuration parameter : " + BrowserType + " , from configuration file : " + ConfigFilePath, E);
        }
        return BrowserType;
    }

}
