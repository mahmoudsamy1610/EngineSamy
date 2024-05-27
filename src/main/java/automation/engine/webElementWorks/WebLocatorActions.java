package automation.engine.webElementWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class WebLocatorActions {



    public static void locateElement (WebDriver Driver, By Locator , String ElementName){

            String Script = "window.scrollTo(0 , document.body.scrollHeight)" ;

        try{
            EngineLogger.EngineInfo("Locating web element [" + ElementName+ "]" + " By Locator :" + Locator );

            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.visibilityOfElementLocated(Locator));

            if (!Driver.findElement(Locator).isDisplayed()) {
                EngineLogger.EngineInfo("Scrolling to web element [" + ElementName+ "]" + " By Locator :" + Locator );
                ((JavascriptExecutor) Driver).executeScript(Script, Driver.findElement(Locator));
            }
        }
        catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to locate element : " + ElementName + " By Locator : " + Locator , E );
        }
    }

    public static void locateElements(WebDriver Driver, By Locators , String ElementName , int ChidIndex){

        String Script = "window.scrollTo(0 , document.body.scrollHeight)" ;

        try{
            EngineLogger.EngineInfo("Locating web elements [" + ElementName+ "]" + "By Locator :" + Locators );

            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.visibilityOfElementLocated(Locators));
            ((JavascriptExecutor) Driver).executeScript(Script, Driver.findElements(Locators).get(ChidIndex));

            if (!Driver.findElement(Locators).isDisplayed()) {
                EngineLogger.EngineInfo("Scrolling to web element [" + ElementName+ "]" + " By Locator :" + Locators );
                ((JavascriptExecutor) Driver).executeScript(Script, Driver.findElement(Locators));
            }
        }
        catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to locate web elements : " + ElementName + "By Locator :" + Locators , E );
        }
    }


    }


