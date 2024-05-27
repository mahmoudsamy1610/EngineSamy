package automation.engine.appDriverWorks;

import automation.utils.loggers.EngineLogger;
import io.appium.java_client.AppiumDriver;

public class AppSetupFactory {

    public static AppiumDriver Run() {

        AppiumDriver driver = null;
        EngineLogger.EngineInfo("Establishing mobile test running bases ");

        try {
            driver = AppExecutionType.SetExecutionType();
        }catch (Exception E){
            EngineLogger.EngineExceptionError("Found an error while Establishing mobile test running bases " , E);
        }

        return driver;
    }


}
