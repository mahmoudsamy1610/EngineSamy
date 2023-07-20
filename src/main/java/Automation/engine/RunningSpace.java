package Automation.engine;

import Automation.engine.browserWorks.BrowserFactory;
import Automation.engine.browserWorks.RemoteBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

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
