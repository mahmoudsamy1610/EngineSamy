package Automation.engine.elementWorks;

import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaitManager {



    public static WebDriverWait useExplicitWait(WebDriver driver) {

        int WaitTime = 0;

        try {
            WaitTime = Integer.parseInt(PropertyGetter.GetPropertyValue("Time", "ExplicitWait"));

            EngineLogger.EngineInfo("Performing explicit wait for : " + WaitTime);

            WebDriverWait wait;
            wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTime));
            return wait;

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to wait for an element for : " + WaitTime, E);
        }
        return null;
    }


}
