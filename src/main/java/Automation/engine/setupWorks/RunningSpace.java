package Automation.engine.setupWorks;

import Automation.engine.gridWorks.GridSetup;
import Automation.engine.gridWorks.NodeBuilder;
import Automation.engine.gridWorks.NodeWrapper;
import Automation.engine.gridWorks.StaGridLauncher;
import Automation.engine.browserWorks.BrowserFactory;
import Automation.engine.browserWorks.NodePlatformFactory;
import Automation.engine.browserWorks.StaBrowserFactory;
import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuitePathGetter;
import org.openqa.selenium.WebDriver;

public class RunningSpace {


    public static WebDriver SetRunningType(String BrowserType , String ExecutionType , String NodePlatformType , String NodeBrowserType  , String ParaModule) {


        if (ExecutionType.equalsIgnoreCase("Local") ) {
            return BrowserFactory.SetBrowserType(BrowserType);
        }


        else if (ExecutionType.equalsIgnoreCase("GridSta")) {

            StaGridLauncher.StaGridStart();
            WebDriver driver = StaBrowserFactory.SetStaBrowserType(BrowserType);

            return driver ;
        }



        else if (ExecutionType.equalsIgnoreCase("GridHub")) {

/*
            Runnable cmdTask = () -> { GridSetup.SetupGrid(NodePlatformType , NodeBrowserType ,  ParaModule);
            } ;
            Thread cmdThread = new Thread(cmdTask);
            cmdThread.start();


 */
            GridSetup.SetupGrid(NodePlatformType , NodeBrowserType ,  ParaModule);
            WebDriver driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType , NodeBrowserType);
            return  driver ;

        }

        else {
            System.out.println("invalid Execution type");
        }

        return null;

    }





}
