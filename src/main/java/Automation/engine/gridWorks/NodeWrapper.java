package Automation.engine.gridWorks;

import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuiteTestCapGetter;

import java.util.List;

public class NodeWrapper {



    public static  String WrapNodePlatformList(String ParaModule) {

        List<String> TestNames = SuiteDataGetterByRun.GetTestNameByRun();
        List<String> NodePlatformTypes = null;
        String Platform = null;

        for (String TestName : TestNames) {
            NodePlatformTypes = SuiteTestCapGetter.CatchPlatform(ParaModule, TestName);
            for (String NodePlatformType : NodePlatformTypes){
                Platform = NodePlatformType;
            }
        }
        return Platform;
    }

/*
    public static String WrapNodePlatform(String ParaModule) {

        List<String> NodePlatformTypes = null;
        String Platform = null;

        for (String NodePlatformType : NodePlatformTypes) {
            WrapNodePlatformList(ParaModule);
            Platform = NodePlatformType;
        }

        return Platform ;
    }


 */




    public static  String WrapNodeBrowserList(String ParaModule) {

        List<String> TestNames = SuiteDataGetterByRun.GetTestNameByRun();
        List<String> NodeBrowserTypes = null;
        String Browser = null;

        for (String TestName : TestNames) {
            NodeBrowserTypes = SuiteTestCapGetter.CatchBrowser(ParaModule, TestName);
            for (String NodeBrowserType : NodeBrowserTypes){
                Browser = NodeBrowserType;
            }
        }
        return Browser;
    }
/*

    public static String WrapNodeBrowser(String ParaModule) {

        List<String> NodeBrowserTypes = WrapNodeBrowserList(ParaModule);
        String Browser = null;

        for (String NodeBrowserType : NodeBrowserTypes) {
            Browser = NodeBrowserType;
        }

        return Browser ;
    }



 */
}
