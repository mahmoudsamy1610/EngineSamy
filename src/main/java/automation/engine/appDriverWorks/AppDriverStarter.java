package automation.engine.appDriverWorks;
import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.loggers.EngineLogger;
import io.appium.java_client.AppiumDriver;


public class


AppDriverStarter {


        public static AppiumDriver StartApp(){

            try {
                EngineLogger.EngineInfo("---------- Preparing AppiumDriver requirements ------------");

                AppiumDriver driver;

                AndroidStudioLauncher.StartAndroidStudio();
                AndroidStudioLauncher.StartAndroidSession();

                driver = AppSetupFactory.Run();

                return driver;
            }
            catch (Exception E ){
                EngineLogger.EngineExceptionError("(unknown) Error while Preparing AppiumDriver requirements" , E);

            }
            return  null ;
        }


    }
