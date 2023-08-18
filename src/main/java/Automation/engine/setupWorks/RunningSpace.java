package Automation.engine.setupWorks;

import Automation.engine.gridWorks.HubGridLauncher;
import Automation.engine.gridWorks.StaGridLauncher;
import Automation.engine.browserWorks.BrowserFactory;
import Automation.engine.browserWorks.NodePlatformFactory;
import Automation.engine.browserWorks.StaBrowserFactory;
import org.openqa.selenium.WebDriver;

public class RunningSpace {



    public static WebDriver SetRunningType(String BrowserType , String ExecutionType , String NodePlatformType , String NodeBrowserType) {


        if (ExecutionType.equalsIgnoreCase("Local") ) {
            return BrowserFactory.SetBrowserType(BrowserType);
        }


        else if (ExecutionType.equalsIgnoreCase("GridSta")) {

            StaGridLauncher.StaGridStart();
            WebDriver driver = StaBrowserFactory.SetStaBrowserType(BrowserType);

            return driver ;
        }



        else if (ExecutionType.equalsIgnoreCase("GridHub")) {

            HubGridLauncher.HubGridStart();
            //here we call the toml file creator
            //here we should call the method that automatically get the node path and node name
            //NodeRegister.RegisterNode();
           WebDriver driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType , NodeBrowserType);
           return  driver ;
        }

        else {
            System.out.println("invalid Execution type");
        }

        return null;

    }





}
