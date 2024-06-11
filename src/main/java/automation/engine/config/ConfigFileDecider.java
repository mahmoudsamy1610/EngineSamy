package automation.engine.config;

import automation.utils.loggers.EngineLogger;
import automation.utils.xmlWorks.XmlTagValueGetter;

public class ConfigFileDecider {

    public static String DecideConfigFile() {

        String ProfileId = null;
        String PomXmlRelativePath  ;
        String RunConfigFilePath = null;

        try {
            PomXmlRelativePath = "Pom.xml";
           // ProfileId = XmlTagValueGetter.FindXmlTagValue(PomXmlRelativePath, "profileId");
             ProfileId = System.getProperty("env");
            RunConfigFilePath = XmlTagValueGetter.GetAdjacentXmlTagValue(PomXmlRelativePath, "profile", "id", ProfileId, "file");

            EngineLogger.EngineInfo("Reading Pom file to get decided running configuration file path : " + RunConfigFilePath);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to find the profile run id in the pom xml : " + ProfileId , E);
        }
        return RunConfigFilePath;
    }

    public static void main(String[] args) {
        System.out.println(DecideConfigFile());
    }

}
