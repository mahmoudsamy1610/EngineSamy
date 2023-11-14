package automation.engine.elementWorks;

import automation.utils.loggers.EngineLogger;
import automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Objects;


public class ElementActions {


    public static void ClearText(WebDriver Driver, By Locator , String ElementName){
        EngineLogger.EngineInfo("Clearing Text inside field : " + ElementName + "By Locator :" + Locator);
        AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);

        try {
            LocatorActions.locateElement(Driver, Locator, ElementName);
            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.elementToBeClickable(Locator)).clear();
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to clear text in field : " + ElementName + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);
            Assert.fail("Failed to clear text in field : " + ElementName , E);
        }
    }


    public static void WriteText(WebDriver Driver, By Locator, String Text , String ElementName){
        EngineLogger.EngineInfo("Writing : ["+ Text +  "] in : [" +ElementName+ "] " + "By Locator :" + Locator );
        AllureStepLogger.logStep("Write : ["+ Text +  "] in : [" +ElementName+ "]"  );

        try {
            LocatorActions.locateElement(Driver, Locator, ElementName);
            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.elementToBeClickable(Locator)).sendKeys(Text);
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to write : ["+ Text +  "] in : [" +ElementName+ "] " + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);
            Assert.fail("Failed to clear text in field : " + ElementName , E);
        }

    }

    public static void ClickElement(WebDriver Driver , By Locator , String ElementName){
        EngineLogger.EngineInfo("Clicking on [" + ElementName+ "] " + "By Locator :" + Locator);
        AllureStepLogger.logStep("Click on [" + ElementName+ "]" );

        try {
            LocatorActions.locateElement(Driver, Locator, ElementName);
            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.elementToBeClickable(Locator)).click();
            }
        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed to click on :[" + ElementName+ "] " + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Click on [" + ElementName+ "]" );
            Assert.fail(" Failed to click on :[" + ElementName+ "]"  , E);
        }
    }


    public static void HoverElement(WebDriver Driver , By Locator , String ElementName){
        EngineLogger.EngineInfo("Hovering on [" + ElementName+ "] " + "By Locator :" + Locator);
        AllureStepLogger.logStep("Hovering on [" + ElementName+ "]" );

        Actions actions = new Actions(Driver);

        try {
            LocatorActions.locateElement(Driver, Locator, ElementName);
            WebElement element = Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.elementToBeClickable(Locator));
            actions.moveToElement(element).perform();
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed to Hover on :[" + ElementName+ "] " + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Hover on [" + ElementName+ "]" );
            Assert.fail(" Failed to Hover on :[" + ElementName+ "]"  , E);
        }
    }


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




    public static String GetElementText(WebDriver Driver , By Locator , String ElementName){
        EngineLogger.EngineInfo("Checking the text in [" + ElementName+ "]" + "By Locator :" + Locator);
        AllureStepLogger.logStep("Check the text in [" + ElementName+ "]" );

        try {
            String ElementText;
            LocatorActions.locateElement(Driver, Locator, ElementName);
            ElementText = Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.elementToBeClickable(Locator)).getText();
            return ElementText;
        }

        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed to detect text on :[" + ElementName+ "]" + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Check the text in [" + ElementName+ "]" );
            Assert.fail("Failed to detect text on :[" + ElementName+ "]"  , E);
        }

        return null;
    }


    }
