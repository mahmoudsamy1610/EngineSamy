package automation.engine.appDriverWorks;

import automation.engine.config.ConfigAppCapabilities;
import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.fileWorks.PathConverter;
import automation.utils.loggers.EngineLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;

public class AppDriverFactory {

    public static AppiumDriver SetPlatform(String AppType) {

            try {


                EngineLogger.EngineInfo("Selecting AppDriver {local} : " + AppType);
                AllureStepLogger.logStep("Open App {local} : " + AppType);

                if (AppType.equalsIgnoreCase("AndroidApp")) {
                    return SetupUiAutomator2Driver();
                } else if (AppType.equalsIgnoreCase("IOSApp")) {
                    return SetupXCUITest();
                } else if (AppType.equalsIgnoreCase("AndroidFireFox")) {
                    return SetupGeckoDriver();
                } else if (AppType.equalsIgnoreCase("IosSafari")) {
                    return SetupSafariDriver();
                } else {
                    EngineLogger.EngineError("Invalid App type provided {Local} : " + AppType);
                    throw new IOException();
                }

            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Error while Selecting App {Local} " + AppType, E);
                AllureStepLogger.logStep("Start App  {local} " + AppType);
                Assert.fail("Failed starting App  {Local} " + AppType, E);
            }

        return null;

    }

    private static AppiumDriver SetupUiAutomator2Driver() {

        EngineLogger.EngineInfo("set up AppDriver");

        try {

            String LocalAbsAppPath = PathConverter.ConvertPathToAbs(ConfigAppCapabilities.ConfigureAppPath());

            AppiumServices.UninstallAppiumDriver();
            AppiumServices.InstallAppiumDriver();
            AppInstaller.InstallApp(LocalAbsAppPath);

           DesiredCapabilities AppDriverCaps = AppCapabilities.DecideAppCapabilities();

        return  new AndroidDriver(new URL("http://192.168.1.11:4723/") ,AppDriverCaps);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up App driver", E);
            throw new NullPointerException();
        }
    }

    private static AppiumDriver SetupXCUITest() {
        return null;
    }

    private static AppiumDriver SetupGeckoDriver() {
        return null;
    }

    private static AppiumDriver SetupSafariDriver() {
        return null;
    }





}

