package automation.engine.appDriverWorks;

import automation.engine.config.ConfigAppCapabilities;
import automation.utils.fileWorks.PathConverter;
import automation.utils.loggers.EngineLogger;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppCapabilities {

    public static DesiredCapabilities DecideAppCapabilities() {

        EngineLogger.EngineInfo("Select App Capabilities");

        try {

           String AppPlatformName = ConfigAppCapabilities.ConfigureAppPlatformName();
           String AppAutomationName =  ConfigAppCapabilities.ConfigureAppAutomationName();
           String AppDeviceName = ConfigAppCapabilities.ConfigureAppDeviceName();
           String AppAbsPath = ConfigAppCapabilities.ConfigureAppPath();

            DesiredCapabilities AppDriverCaps = new DesiredCapabilities();

            AppDriverCaps.setCapability("platformName" , AppPlatformName);
            AppDriverCaps.setCapability("automationName" , AppAutomationName);
            AppDriverCaps.setCapability("deviceName" , AppDeviceName);
            AppDriverCaps.setCapability("app" , AppAbsPath);

            return  AppDriverCaps;

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up App driver", E);
            throw new NullPointerException();
        }
    }


}
