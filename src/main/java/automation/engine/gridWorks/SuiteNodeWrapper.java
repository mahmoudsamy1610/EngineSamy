package automation.engine.gridWorks;

import automation.engine.config.ConfigFilePath;
import automation.utils.loggers.EngineLogger;
import automation.engine.suiteWorks.SuiteDataGetterByXml;
import automation.engine.suiteWorks.SuiteTestCapGetter;


import java.util.ArrayList;
import java.util.List;

public class SuiteNodeWrapper {


    public static  List <String> WrapNodeSuitePlatforms() {


        //String RunFileDirPath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlDirPath");
        //String RunXmlFileName = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlFile");
        String RunFileRelativePath = ConfigFilePath.GetConfigFilePath();
        List<String> SuiteNames = SuiteDataGetterByXml.GetSuiteNamesByXmlPath(RunFileRelativePath);
        List<String> NodePlatformTypes = new ArrayList<>();
        List<String> Platforms = new ArrayList<>();

        EngineLogger.EngineInfo("Wrapping all platforms found from provided suite names : " + SuiteNames + " --->" + Platforms);

        try {
            for (String SuiteName : SuiteNames) {
                Platforms = SuiteTestCapGetter.CatchPlatforms(SuiteName);
                NodePlatformTypes.addAll(Platforms);
                EngineLogger.EngineInfo("Catch platform from test name : " + SuiteName + " --->" + Platforms);
            }

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Wrapping all platforms found from provided test names : " + SuiteNames + " --->" + Platforms, E);
        }


        return NodePlatformTypes;
    }



    public static  List <String> WrapNodeSuiteBrowsers() {


     //   String RunFileDirPath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlDirPath");
      //  String RunXmlFileName = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlFile");
        String RunFileRelativePath = ConfigFilePath.GetConfigFilePath();
        List<String> SuiteNames = SuiteDataGetterByXml.GetSuiteNamesByXmlPath(RunFileRelativePath);
        List<String> NodeBrowserTypes = new ArrayList<>();
        List<String> Browsers = new ArrayList<>();

        EngineLogger.EngineInfo("Wrapping all platforms found from provided test names : " + SuiteNames);

        try {
            for (String SuiteName : SuiteNames) {
                Browsers = SuiteTestCapGetter.CatchBrowsers(SuiteName);
                NodeBrowserTypes.addAll(Browsers);
                EngineLogger.EngineInfo("Catch browser from test name : " + SuiteName + " --->" + Browsers);

            }
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Wrapping all browsers found from provided test names : " + SuiteNames + " --->" + Browsers, E);
        }
        return NodeBrowserTypes;
    }


    public static void main(String[] args) {

      //  WrapNodeSuitePlatforms();
       // WrapNodeSuiteBrowsers();
    }

}
