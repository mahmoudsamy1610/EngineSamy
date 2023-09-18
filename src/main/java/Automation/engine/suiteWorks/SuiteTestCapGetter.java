package Automation.engine.suiteWorks;

import Automation.engine.jsonWorks.GetJsonValueByKey;
import Automation.engine.loggers.CoreJavaLogger;
import Automation.engine.propertyWorks.PropertyGetter;

import java.util.ArrayList;
import java.util.List;

public class SuiteTestCapGetter {


    public static List<String> CatchPlatforms(String Catcher) {

        List<String> NodePlatformTypes = new ArrayList<>();
        String ParaModule = null;

        try {
            ParaModule = PropertyGetter.GetPropertyValue("RunOptions", "ParaModule");
            NodePlatformTypes = (GetJsonValueByKey.GetValueByContainerKey("Platform", ParaModule, Catcher));

        } catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Cannot find any platform results from module : " + ParaModule+ " , using this catcher : " +Catcher , E);
        }
        return NodePlatformTypes;

    }

    public static List<String> CatchBrowsers(String Catcher) {

        List<String> NodeBrowserTypes = new ArrayList<>();
        String ParaModule = null;

        try {
            ParaModule = PropertyGetter.GetPropertyValue("RunOptions", "ParaModule");
            NodeBrowserTypes = GetJsonValueByKey.GetValueByContainerKey("Browser", ParaModule, Catcher);

        } catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Cannot find any browser results from module : " + ParaModule + " , using this catcher : " + Catcher, E);
        }

        return NodeBrowserTypes;

    }






    public static void main(String[] args) {


    }

}


