package Automation.engine.gridWorks;

import Automation.engine.config.ConfigFilePath;
import Automation.utils.helpers.StringConcatenator;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.engine.suiteWorks.SuiteDataGetterByXml;
import Automation.engine.suiteWorks.SuiteTestCapGetter;


import java.util.ArrayList;
import java.util.List;

public class TestNodeWrapper {



    public static  List <String> WrapNodeTestPlatforms() {

      //  String RunFileDirPath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlDirPath");
     //   String RunXmlFileName = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlFile");
        String RunFileRelativePath = ConfigFilePath.GetConfigFilePath();
        List<String> TestNames = SuiteDataGetterByXml.GetTestNamesByXmlPath(RunFileRelativePath);
        List<String> NodePlatformTypes = new ArrayList<>();
        List<String> Platforms = new ArrayList<>();

        EngineLogger.EngineInfo("Wrapping all platforms found from provided test names : " + TestNames + " --->" + Platforms);

        try {
            for (String TestName : TestNames) {
                Platforms = SuiteTestCapGetter.CatchPlatforms(TestName);
                NodePlatformTypes.addAll(Platforms);
                EngineLogger.EngineInfo("Catch platform from test name : " + TestName + " --->" + Platforms);
            }
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Wrapping all platforms found from provided test names : " + TestNames + " --->" + Platforms, E);
        }

        return NodePlatformTypes;
    }



    public static  List <String> WrapNodeTestBrowsers() {

     //   String RunFileDirPath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlDirPath");
     //   String RunXmlFileName = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlFile");
        String RunFileRelativePath = ConfigFilePath.GetConfigFilePath();
        List<String> TestNames = SuiteDataGetterByXml.GetTestNamesByXmlPath(RunFileRelativePath);
        List<String> NodeBrowserTypes = new ArrayList<>();
        List<String> Browsers = new ArrayList<>();

        EngineLogger.EngineInfo("Wrapping all platforms found from provided test names : " + TestNames);

        try {
            for (String TestName : TestNames) {
                Browsers = SuiteTestCapGetter.CatchBrowsers(TestName);
                NodeBrowserTypes.addAll(Browsers);
                EngineLogger.EngineInfo("Catch browser from test name : " + TestName + " --->" + Browsers);

            }
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Wrapping all browsers found from provided test names : " + TestNames + " --->" + Browsers, E);
        }
        return NodeBrowserTypes;
    }


    public static void main(String[] args) {

        WrapNodeTestPlatforms();
        WrapNodeTestBrowsers();

    }

}
