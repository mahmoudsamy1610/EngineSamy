package Automation.engine.config;

import Automation.utils.loggers.EngineLogger;
import Automation.utils.xmlWorks.XmlAttValueGetter;
import Automation.utils.xmlWorks.XmlTagValueGetter;
import net.bytebuddy.build.Plugin;
import org.slf4j.Logger;

public class ConfigFileDecider {

    public static String DecideConfigFile() {

        String ProfileId = null;
        String PomXmlRelativePath  ;
        String RunConfigFilePath = null;

        try {
            PomXmlRelativePath = "Pom.xml";
            ProfileId = XmlTagValueGetter.FindXmlTagValue(PomXmlRelativePath, "RunId");
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
