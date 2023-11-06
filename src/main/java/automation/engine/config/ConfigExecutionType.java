package automation.engine.config;

import automation.utils.loggers.JavaLogger;
import automation.utils.xmlWorks.XmlAttValueGetter;

public class ConfigExecutionType {

    public static String GetExecutionType() {

        String ExecutionType = null;
        String ConfigFilePath = null;
        try {
            ConfigFilePath = ConfigFileDecider.DecideConfigFile();
            ExecutionType = XmlAttValueGetter.GetAttributeValueByAttName(ConfigFilePath, "parameter", "name", "ExecutionType", "value");
            JavaLogger.JavaInfo("Fetching ExecutionType configuration parameter : " + ExecutionType + " , from configuration file : " + ConfigFilePath);
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Fetching ExecutionType configuration parameter : " + ExecutionType + " , from configuration file : " + ConfigFilePath, E);
        }
        return ExecutionType;
    }






    public static void main(String[] args) {
        //System.out.println(ConfigBrowserType());
    }

}
