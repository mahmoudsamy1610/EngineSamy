package Automation.engine.setupWorks;

import Automation.engine.GridWorks.GridLauncher;
import Automation.engine.browserWorks.BrowserFactory;
import Automation.engine.browserWorks.RemoteBrowserFactory;
import org.openqa.selenium.WebDriver;

public class RunningSpace {



    public static WebDriver SetRunningType( String BrowserType , String ExecutionType ) {


        if (ExecutionType.equalsIgnoreCase("Local") ) {
            return BrowserFactory.SetBrowserType(BrowserType);
        }
        else if (ExecutionType.equalsIgnoreCase("GridSta")) {

            GridLauncher.GridStaLauncher();
            WebDriver driver = RemoteBrowserFactory.SetRemoteBrowserType(BrowserType);

            return driver ;


        }else {
            System.out.println("invalid Execution type");
        }

        return null;

    }





}
