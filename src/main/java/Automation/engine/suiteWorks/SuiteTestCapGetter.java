package Automation.engine.suiteWorks;

import Automation.engine.jsonWorks.GetJsonValueByKey;

import java.util.List;

public class SuiteTestCapGetter {


    public static List<String> CatchPlatforms(String ParaModule , String Catcher) {

        List<String> NodePlatformTypes = (GetJsonValueByKey.GetValueByContainerKey("Platform" , ParaModule , Catcher));

      return NodePlatformTypes ;

    }

    public static List<String> CatchBrowsers(String ParaModule , String Catcher) {

        List<String> NodeBrowserTypes = GetJsonValueByKey.GetValueByContainerKey("Browser" , ParaModule , Catcher);

        return NodeBrowserTypes ;

    }






    public static void main(String[] args) {

        System.out.println(CatchPlatforms("TimeSavingModule" , "AdminLogin023"));
        CatchBrowsers("TimeSavingModule" , "AdminLogin023") ;
    }

}


