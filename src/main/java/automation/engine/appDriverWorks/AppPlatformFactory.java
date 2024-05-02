package automation.engine.appDriverWorks;

import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.loggers.EngineLogger;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.io.IOException;

public class AppPlatformFactory {

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
        return null;
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

