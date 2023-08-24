package Automation.engine.suiteWorks;

import Automation.engine.jsonWorks.GetJsonValueByKey;

import java.util.List;

public class SuiteTestCapGetter {


    public static List<String> CatchPlatform(String ParaModule , String Catcher) {

        List<String> NodePlatformTypes = (GetJsonValueByKey.GetValueByContainerKey("Platform" , ParaModule , Catcher));

      return NodePlatformTypes ;

    }

    public static List<String> CatchBrowser(String ParaModule , String Catcher) {

        List<String> NodeBrowserTypes = GetJsonValueByKey.GetValueByContainerKey("Browser" , ParaModule , Catcher);

        return NodeBrowserTypes ;

    }



    public static void main(String[] args) {

        System.out.println(CatchPlatform("TimeSavingModule" , "AdminLogin023"));
        CatchBrowser("TimeSavingModule" , "AdminLogin023") ;
    }

}


