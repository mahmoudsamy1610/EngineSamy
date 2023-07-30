package Automation.engine.setupWorks;

import Automation.engine.browserWorks.NodePlatformFactory;
import org.openqa.selenium.WebDriver;

public class ParaSetupFactory {


    public static WebDriver ParaRun(String BrowserType , String  ExecutionType , String  NodePlatformType , String  NodeBrowserType){
        return RunningSpace.SetRunningType(BrowserType ,  ExecutionType , NodePlatformType , NodeBrowserType);
    }

}
