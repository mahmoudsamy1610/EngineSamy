package automation.engine.appDriverWorks;

import automation.engine.config.ConfigBrowserType;
import automation.engine.config.ConfigExecutionType;
import automation.utils.loggers.EngineLogger;
import io.appium.java_client.AppiumDriver;
import java.io.IOException;


public class AppExecutionType {

    public static AppiumDriver SetExecutionType() {

        String ExecutionType = ConfigExecutionType.GetExecutionType();

        EngineLogger.EngineInfo("Deciding App running space : " + ExecutionType);


        try {

            if (ExecutionType.equalsIgnoreCase("AppLocal")) {
                String BrowserType = ConfigBrowserType.GetBrowserType();
                return AppPlatformFactory.SetPlatform(BrowserType);

            } else if (ExecutionType.equalsIgnoreCase("AppParaLocal")) {
                EngineLogger.EngineError("Parallel execution for Appium driver is not yet implemented : " + ExecutionType);
                throw new IOException();
                //when implementing parrallel execution you need new classes as web
                //return AppPlatformFactory.SetPlatform(BrowserType);

            } else {
                EngineLogger.EngineError("Invalid App Execution type provided : " + ExecutionType);
                throw new IOException();
            }

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Found an error while deciding App running space : " + ExecutionType , E);
        }

        return null;
    }






}
