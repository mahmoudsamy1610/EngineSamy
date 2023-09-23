package Automation.engine.setupWorks;

import Automation.engine.gridWorks.StaGridLauncher;
import Automation.engine.browserWorks.BrowserFactory;
import Automation.engine.browserWorks.StaBrowserFactory;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import org.openqa.selenium.WebDriver;

public class RunSpace {


    public static WebDriver SetRunningType() {

        String ExecutionType = PropertyGetter.GetPropertyValue("RunOptions", "ExecutionType");

        EngineLogger.EngineInfo("Deciding running space : " + ExecutionType);

        try {

            if (ExecutionType.equalsIgnoreCase("Local")) {
                String BrowserType = PropertyGetter.GetPropertyValue("RunOptions", "BrowserType");
                return BrowserFactory.SetBrowserType(BrowserType);

            } else if (ExecutionType.equalsIgnoreCase("ParaLocal")) {

                return ParaLocalRunLevel.SetParaLocalRunLevel();
            } else if (ExecutionType.equalsIgnoreCase("GridSta")) {

                String BrowserType = PropertyGetter.GetPropertyValue("RunOptions", "BrowserType");
                StaGridLauncher.StaGridStart();
                WebDriver driver = StaBrowserFactory.SetStaBrowserType(BrowserType);
                return driver;

            } else if (ExecutionType.equalsIgnoreCase("GridHub")) {

                return ParaGridRunLevel.SetParaGridRunLevel();

            } else {
                System.out.println("invalid Execution type inserted : " + ExecutionType);

            }
        }catch (Exception E){
            EngineLogger.EngineExceptionError("Found an error while receiving inputs deciding running space : " + ExecutionType , E);
        }
        return null;
    }


    public static void main(String[] args) {
        SetRunningType();
    }
}
