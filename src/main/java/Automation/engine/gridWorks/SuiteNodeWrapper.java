package Automation.engine.gridWorks;

import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.suiteWorks.SuiteDataGetterByXml;
import Automation.engine.suiteWorks.SuiteTestCapGetter;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SuiteNodeWrapper {



    public static  List <String> WrapNodeSuitePlatforms() {


        String RunFileRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlRelativePath");
        List<String> SuiteNames = SuiteDataGetterByXml.GetSuiteNamesByXmlPath(RunFileRelativePath);
        List<String> NodePlatformTypes = new ArrayList<>();
        List<String> Platforms = new ArrayList<>();

        try {
            for (String SuiteName : SuiteNames) {
                EngineLogger.EngineInfo("Wrapping all Browsers from suite level " + Platforms);
                Platforms = SuiteTestCapGetter.CatchPlatforms(SuiteName);
                NodePlatformTypes.addAll(Platforms);

            }

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed wrapping all platforms from suite level " + Platforms, E);
            Assert.fail("Failed wrapping all platforms from suite level " + Platforms, E);
        }


        return NodePlatformTypes;
    }



    public static  List <String> WrapNodeSuiteBrowsers() {


        String RunFileRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlRelativePath");
        List<String> TestNames = SuiteDataGetterByXml.GetSuiteNamesByXmlPath(RunFileRelativePath);
        List<String> NodeBrowserTypes = new ArrayList<>();
        List<String> Browsers = new ArrayList<>();

        try {
            for (String TestName : TestNames) {
                Browsers = SuiteTestCapGetter.CatchBrowsers(TestName);
                NodeBrowserTypes.addAll(Browsers);
                EngineLogger.EngineInfo("Wrapping all Browsers from suite level " + Browsers);

            }
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed wrapping all Browsers from suite level " + Browsers, E);
            Assert.fail("Failed wrapping all Browsers from suite level " + Browsers, E);
        }
        return NodeBrowserTypes;
    }


    public static void main(String[] args) {

        WrapNodeSuitePlatforms();
        WrapNodeSuiteBrowsers();
    }

}
