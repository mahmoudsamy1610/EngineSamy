package automation.engine.webDriverWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.WebDriver;

public class WebSetupFactory {


    public static WebDriver Run() {

        WebDriver Driver = null;
        EngineLogger.EngineInfo("Establishing test running bases ");

        try {
            Driver = WebExecutionType.SetExecutionType();
        }catch (Exception E){
            EngineLogger.EngineExceptionError("Found an error while Establishing test running bases " , E);
        }

        return Driver;
    }


    public static void main(String[] args) {
        Run();
    }

}
