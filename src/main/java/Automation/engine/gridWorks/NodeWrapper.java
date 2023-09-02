package Automation.engine.gridWorks;

import Automation.engine.helpers.ArrayElementFinder;
import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuiteTestCapGetter;

import java.util.List;

public class NodeWrapper {



    public static  String WrapNodePlatformList(String ParaModule) {

        List<String> TestNames = SuiteDataGetterByRun.GetTestNamesByRun();
        List<String> NodePlatformTypes = null;
        String Platform = null;

        for (String TestName : TestNames) {
            NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(ParaModule, TestName);
            for (String NodePlatformType : NodePlatformTypes){
                Platform = NodePlatformType;
            }
        }
        return Platform;
    }

/*

    public  static String WrapNodePlaftormByRun(String ParaModule){

        List<String> TestNames = SuiteDataGetterByRun.GetTestNamesByRun();
        List<String> NodePlatformTypes = null;
        String NodePlatformType = null;

        for (String TestName : TestNames) {
            NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(ParaModule, TestName);
            String RunningTestName = SuiteDataGetterByRun.GetCurrentTestNameByRun();
             NodePlatformType = ArrayElementFinder.FindArrayElement(NodePlatformTypes , RunningTestName);
            }
        return NodePlatformType;
    }

*/





    public static  String WrapNodeBrowserList(String ParaModule) {

        List<String> TestNames = SuiteDataGetterByRun.GetTestNamesByRun();
        List<String> NodeBrowserTypes = null;
        String Browser = null;

        for (String TestName : TestNames) {
            NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(ParaModule, TestName);
            for (String NodeBrowserType : NodeBrowserTypes){
                Browser = NodeBrowserType;
            }
        }
        return Browser;
    }

    /*
    public  static String WrapNodeBrowserByRun(String ParaModule){

        List<String> TestNames = SuiteDataGetterByRun.GetTestNamesByRun();
        List<String> NodeBrowserTypes = null;
        String NodeBrowserType = null;

        for (String TestName : TestNames) {
            NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(ParaModule, TestName);
            String RunningTestName = SuiteDataGetterByRun.GetCurrentTestNameByRun();
            NodeBrowserType = ArrayElementFinder.FindArrayElement(NodeBrowserTypes , RunningTestName);
        }
        return NodeBrowserType;
    }

 */


}
