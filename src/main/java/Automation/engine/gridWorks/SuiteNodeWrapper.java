package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.suiteWorks.SuiteDataGetterByXml;
import Automation.engine.suiteWorks.SuiteTestCapGetter;

import java.util.ArrayList;
import java.util.List;

public class SuiteNodeWrapper {



    public static  List <String> WrapNodeSuitePlatforms() {


        String RunFileRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlRelativePath");
        List<String> SuiteNames = SuiteDataGetterByXml.GetSuiteNamesByXmlPath(RunFileRelativePath);
        List<String> NodePlatformTypes = new ArrayList<>();


        for (String SuiteName : SuiteNames) {
           List<String> Platforms =  SuiteTestCapGetter.CatchPlatforms(SuiteName);
            NodePlatformTypes.addAll(Platforms);
        }

        return NodePlatformTypes;
    }



    public static  List <String> WrapNodeSuiteBrowsers() {


        String RunFileRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlRelativePath");
        List<String> TestNames = SuiteDataGetterByXml.GetSuiteNamesByXmlPath(RunFileRelativePath);

        List<String> NodeBrowserTypes = new ArrayList<>() ;;

        for (String TestName : TestNames) {
            List<String> Browsers = SuiteTestCapGetter.CatchBrowsers(TestName);
            NodeBrowserTypes.addAll(Browsers);
        }
        return NodeBrowserTypes;
    }


    public static void main(String[] args) {

        WrapNodeSuitePlatforms();
        WrapNodeSuiteBrowsers();
    }

}
