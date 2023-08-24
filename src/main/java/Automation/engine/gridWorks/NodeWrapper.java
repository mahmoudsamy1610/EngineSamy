package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuiteTestCapGetter;

import java.util.List;

public class NodeWrapper {



    public static List<String> WrapNodePlatform(String ParaModule) {

        List<String> TestNames = SuiteDataGetterByRun.GetTestNameByRun();
        List<String> NodePlatformTypes = null;

        for (String TestName : TestNames) {

             NodePlatformTypes = SuiteTestCapGetter.CatchPlatform(ParaModule,TestName );

        }
        return NodePlatformTypes;

    }



    public static List<String> WrapNodeBrowser(String ParaModule) {

        List<String> TestNames = SuiteDataGetterByRun.GetTestNameByRun();
        List<String> NodeBrowserTypes = null;

        for (String TestName : TestNames) {

            NodeBrowserTypes = SuiteTestCapGetter.CatchBrowser(ParaModule, TestName);

        }
        return NodeBrowserTypes;

    }
}
