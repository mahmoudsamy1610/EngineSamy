package automation.engine.appDriverWorks;

import automation.engine.config.ConfigAppDriver;
import automation.utils.cmdWorks.CMDRunner;
import automation.utils.loggers.EngineLogger;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.IExecutionListener;

public class AppiumServices implements IExecutionListener {

    public static void StartAppiumService() {

        EngineLogger.EngineInfo("--------------Starting Appium Service on local machine-------------");

        try {
            AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to start Appium Service, un error occurred, check appium service commands" , E);
        }




    }



    public static void InstallAppiumDriver(){

        String DriverName = ConfigAppDriver.ConfigureAppDriver();
        EngineLogger.EngineInfo("--------------Installing Appium Driver : " +DriverName+ "-------------");

        try {
            CMDRunner.runCommand("appium driver install " + DriverName);
        }catch (Exception E){
            EngineLogger.EngineExceptionError("an error occurred while Installing Appium Driver : " +DriverName , E);
        }


    }


    public static void UninstallAppiumDriver(){

        String DriverName = ConfigAppDriver.ConfigureAppDriver();
        EngineLogger.EngineInfo("--------------UnInstalling Appium Driver : " +DriverName+ "-------------");

        try {

            CMDRunner.runCommand("appium driver uninstall " + DriverName);
        }catch (Exception E){
            EngineLogger.EngineExceptionError("an error occurred while  UnInstalling Appium Driver : " +DriverName , E);
        }


    }


    public static void StopAppiumService(){
        EngineLogger.EngineInfo("--------------Shutting down Appium Service on local machine-------------");

        try {
            AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to Shut down Appium Service, un error occurred, check appium service commands" , E);
        }



    }


    public void onExecutionStart(){
        StopAppiumService();
        StartAppiumService();

    }



    public void onExecutionFinish(){
        StopAppiumService();

    }


    public static void main(String[] args) {
        StopAppiumService();
        StartAppiumService();
        StopAppiumService();

    }

}
