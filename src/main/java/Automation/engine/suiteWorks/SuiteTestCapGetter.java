package Automation.engine.suiteWorks;

import Automation.engine.jsonWorks.GetJsonValueByKey;
import Automation.engine.propertyWorks.PropertyGetter;

import java.util.List;

public class SuiteTestCapGetter {


    public static List<String> CatchPlatforms(String Catcher) {

        String ParaModule = PropertyGetter.GetPropertyValue("RunOptions","ParaModule");
        List<String> NodePlatformTypes = (GetJsonValueByKey.GetValueByContainerKey("Platform" , ParaModule , Catcher));

      return NodePlatformTypes ;

    }

    public static List<String> CatchBrowsers(String Catcher) {

        String ParaModule = PropertyGetter.GetPropertyValue("RunOptions","ParaModule");
        List<String> NodeBrowserTypes = GetJsonValueByKey.GetValueByContainerKey("Browser" , ParaModule , Catcher);

        return NodeBrowserTypes ;

    }






    public static void main(String[] args) {


    }

}


