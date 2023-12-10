package automation.engine.elementWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MouseActions {


    public static void ClickByCoordinates(WebDriver Driver , int x , int y){
        //Coordinates from origin on top,left corner
        EngineLogger.EngineInfo("moving cursor by x and y respectively : " + x + y);

        Actions actions = new Actions(Driver);

        try {
            actions.moveByOffset(x , y).click().perform();
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed moving cursor by x and y respectively : " + x + y, E);
            Assert.fail(" Failed moving cursor by x and y respectively : " + x + y  , E);
        }
    }


}
