package automation.engine.elementWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class KeyboardActions {


    public static void PressEscapeKey(WebDriver Driver){
        /*Keys hint
        ESCAPE
         */

        EngineLogger.EngineInfo("Pressing Escape key");

        Actions actions = new Actions(Driver);

        try {
            actions.sendKeys(Keys.ESCAPE).perform();
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed Pressing Escape key" , E);
            Assert.fail(" Failed Pressing Escape key " , E);
        }
    }


    public static void PressTabKey(WebDriver Driver){
        /*Keys hint
        ESCAPE
         */

        EngineLogger.EngineInfo("Pressing Tab key");

        Actions actions = new Actions(Driver);

        try {
            actions.sendKeys(Keys.TAB).perform();
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed Pressing Tab key" , E);
            Assert.fail(" Failed Pressing Tab key " , E);
        }
    }


}
