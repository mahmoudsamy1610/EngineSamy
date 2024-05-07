package automation.engine.appDriverWorks;

import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.fileWorks.PathConverter;
import automation.utils.loggers.EngineLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
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

        try {

            String AppAbsPath = PathConverter.ConvertPathToAbs("src/main/resources/automationResources/apks/ApiDemos-debug.apk");

        DesiredCapabilities AppDriverCaps = new DesiredCapabilities();
        AppDriverCaps.setCapability("platformName" , "Android");
        AppDriverCaps.setCapability("automationName" , "UiAutomator2");
        AppDriverCaps.setCapability("deviceName" , "emulator-5554"); // design needed to confiugre phone name
        AppDriverCaps.setCapability("app" , AppAbsPath); // design needed to confiugre App path

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

