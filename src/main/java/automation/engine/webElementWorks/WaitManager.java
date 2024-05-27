package automation.engine.webElementWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {



    public static WebDriverWait useExplicitWait(WebDriver driver) {

        try {

            EngineLogger.EngineInfo("Performing explicit wait for : " + 5);

            WebDriverWait wait;
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait;

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to wait for an element for : " + 5, E);
        }
        return null;
    }


}
