package automation.engine.config;

import automation.utils.loggers.JavaLogger;
import automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigAppCapabilities {


    public static String ConfigureAppPlatformName() {

        String PlatformName = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            PlatformName = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "PlatformName", "value");
            JavaLogger.JavaInfo("Fetching PlatformName configuration parameter : " + PlatformName + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching PlatformName configuration parameter : " + PlatformName + " , from configuration file : " + ConfigFilePath, E);
        }
        return PlatformName;
    }


    public static String ConfigureAppAutomationName() {

        String AutomationName = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            AutomationName = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "AutomationName", "value");
            JavaLogger.JavaInfo("Fetching AutomationName configuration parameter : " + AutomationName + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching AutomationName configuration parameter : " + AutomationName + " , from configuration file : " + ConfigFilePath, E);
        }
        return AutomationName;
    }


    public static String ConfigureAppDeviceName() {

        String DeviceName = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            DeviceName = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "DeviceName", "value");
            JavaLogger.JavaInfo("Fetching DeviceName configuration parameter : " + DeviceName + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching DeviceName configuration parameter : " + DeviceName + " , from configuration file : " + ConfigFilePath, E);
        }
        return DeviceName;
    }


    public static String ConfigureAppPath() {

        String AppPath = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            AppPath = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "AppPath", "value");
            JavaLogger.JavaInfo("Fetching appPath configuration parameter : " + AppPath + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching appPath configuration parameter : " + AppPath + " , from configuration file : " + ConfigFilePath, E);
        }
        return AppPath;
    }


}
