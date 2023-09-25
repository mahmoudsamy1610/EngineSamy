package Automation.engine.gridWorks;

import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuiteDataGetterByXml;
import Automation.engine.suiteWorks.SuiteTestCapGetter;
import Automation.utils.helpers.StringConcatenator;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;

import java.util.ArrayList;
import java.util.List;

public class SuiteNodeWrapper_2 {



    public static  List <String> WrapNodeSuitePlatforms() {

        List<String> NodePlatformTypes = new ArrayList<>();
        String SuiteName = SuiteDataGetterByRun.CurrentSuiteName();

        try {

        EngineLogger.EngineInfo("Wrapping all platforms found from provided suite name : " + SuiteName + " --->" + NodePlatformTypes);


                NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(SuiteName);
                EngineLogger.EngineInfo("Catch platform from test name : " + SuiteName + " --->" + NodePlatformTypes);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Wrapping all platforms found from provided test name : " + SuiteName + " --->" + NodePlatformTypes, E);
        }


        return NodePlatformTypes;
    }



    public static  List <String> WrapNodeSuiteBrowsers() {


        List<String> NodeBrowserTypes = new ArrayList<>();
        String SuiteName = SuiteDataGetterByRun.CurrentSuiteName();

        try {

            EngineLogger.EngineInfo("Wrapping all platforms found from provided suite name : " + SuiteName + " --->" + NodeBrowserTypes);


            NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(SuiteName);
            EngineLogger.EngineInfo("Catch platform from test name : " + SuiteName + " --->" + NodeBrowserTypes);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Wrapping all platforms found from provided test name : " + SuiteName + " --->" + NodeBrowserTypes, E);
        }


        return NodeBrowserTypes;
    }

    public static void main(String[] args) {

        WrapNodeSuitePlatforms();
        WrapNodeSuiteBrowsers();
    }

}
