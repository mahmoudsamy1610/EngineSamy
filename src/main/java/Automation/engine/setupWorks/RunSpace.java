package Automation.engine.setupWorks;

import Automation.engine.gridWorks.NodeCapCoupler;
import Automation.engine.gridWorks.TestNodeWrapper;
import Automation.engine.gridWorks.StaGridLauncher;
import Automation.engine.browserWorks.BrowserFactory;
import Automation.engine.browserWorks.NodePlatformFactory;
import Automation.engine.browserWorks.StaBrowserFactory;
import Automation.engine.propertyWorks.PropertyGetter;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RunSpace {


    public static WebDriver SetRunningType() {

        String ExecutionType = PropertyGetter.GetPropertyValue("RunOptions", "ExecutionType");


        if (ExecutionType.equalsIgnoreCase("Local")) {
            String BrowserType = PropertyGetter.GetPropertyValue("RunOptions", "BrowserType");
            return BrowserFactory.SetBrowserType(BrowserType);

        } else if (ExecutionType.equalsIgnoreCase("GridSta")) {

            String BrowserType = PropertyGetter.GetPropertyValue("RunOptions", "BrowserType");

            StaGridLauncher.StaGridStart();
            WebDriver driver = StaBrowserFactory.SetStaBrowserType(BrowserType);
            return driver;

        } else if (ExecutionType.equalsIgnoreCase("GridHub")) {

          return ParaRunSpace.SetParaRunType();

        } else {
            System.out.println("invalid Execution type");

        }

        return null;
    }

}
