package Automation.engine.gridWorks;

import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.suiteWorks.SuiteDataGetterByXml;
import Automation.utils.suiteWorks.SuiteTestCapGetter;

import java.util.ArrayList;
import java.util.List;

public class TestNodeWrapper {



    public static  List <String> WrapNodeTestPlatforms() {


        String RunFileRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlRelativePath");
        List<String> TestNames = SuiteDataGetterByXml.GetTestNamesByXmlPath(RunFileRelativePath);
        List<String> NodePlatformTypes = new ArrayList<>();


        for (String TestName : TestNames) {
           List<String> Platforms =  SuiteTestCapGetter.CatchPlatforms(TestName);
            NodePlatformTypes.addAll(Platforms);
        }

        return NodePlatformTypes;
    }



    public static  List <String> WrapNodeTestBrowsers() {


        String RunFileRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "RunXmlRelativePath");
        List<String> TestNames = SuiteDataGetterByXml.GetTestNamesByXmlPath(RunFileRelativePath);
        List<String> NodeBrowserTypes = new ArrayList<>() ;;

        for (String TestName : TestNames) {
            List<String> Browsers = SuiteTestCapGetter.CatchBrowsers(TestName);
            NodeBrowserTypes.addAll(Browsers);
        }
        return NodeBrowserTypes;
    }


    public static void main(String[] args) {

        List<String> list =  WrapNodeTestPlatforms();
        System.out.println(list.size());
        System.out.println(list);

    }

}
