package automation.engine.webDriverWorks;

import automation.engine.config.ConfigBrowserType;
import automation.engine.config.ConfigExecutionType;
import automation.engine.gridWorks.StaGridLauncher;
import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WebExecutionType {


    public static WebDriver SetExecutionType() {

        String ExecutionType = ConfigExecutionType.GetExecutionType();

        EngineLogger.EngineInfo("Deciding running space : " + ExecutionType);


        try {

            if (ExecutionType.equalsIgnoreCase("Local")) {
                String BrowserType = ConfigBrowserType.GetBrowserType();
                return WebBrowserFactory.SetBrowserType(BrowserType);

            } else if (ExecutionType.equalsIgnoreCase("ParaLocal")) {
                return ParaLocalRunLevel.SetParaLocalRunLevel();

            } else if (ExecutionType.equalsIgnoreCase("GridSta")) {
                String BrowserType = ConfigBrowserType.GetBrowserType();
                StaGridLauncher.StaGridStart();
                WebDriver driver = StaBrowserFactory.SetStaBrowserType(BrowserType);
                return driver;

            } else if (ExecutionType.equalsIgnoreCase("GridHub")) {
                return ParaGridRunLevel.SetParaGridRunLevel();

            } else {
                EngineLogger.EngineError("Invalid Execution type provided : " + ExecutionType);
                throw new IOException();
            }

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Found an error while deciding running space : " + ExecutionType , E);
        }

    return null;
    }


    public static void main(String[] args) {
        SetExecutionType();
    }
}
