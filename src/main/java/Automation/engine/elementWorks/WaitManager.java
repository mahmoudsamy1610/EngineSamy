package Automation.engine.elementWorks;

import Automation.engine.loggers.Loggers;
import Automation.engine.propertyWorks.PropertyGetter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaitManager {



    public static WebDriverWait useExplicitWait(WebDriver driver) {

        int WaitTime =Integer.parseInt(PropertyGetter.GetPropertyValue("Time","ExplicitWait"));

        try {
            Loggers.Info("Performing explicit wait for : " + WaitTime);

            WebDriverWait wait;
            wait =  new WebDriverWait(driver, Duration.ofSeconds(WaitTime));
               return wait;
        }

        catch (Exception E) {
            Loggers.ExceptionError("Failed to wait for an element for : " + WaitTime , E );
            Assert.fail("Failed to wait for an element for : " + WaitTime , E );
        }
        return null;
    }


}
