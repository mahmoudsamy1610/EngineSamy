package automation.engine.elementWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class LocatorActions {



    public static void locateElement (WebDriver Driver, By Locator , String ElementName){


        try{
            EngineLogger.EngineInfo("Locating web element [" + ElementName+ "]" + " By Locator :" + Locator );

            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.visibilityOfElementLocated(Locator));
            ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(false);", Driver.findElement(Locator));

            if (!Driver.findElement(Locator).isDisplayed()) {
                EngineLogger.EngineError("Element located by : "+ Locator+ " is not displayed");
                throw new Exception();
            }
        }
        catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to locate element : " + ElementName + " By Locator : " + Locator , E );
        }
    }

    public static void locateElements(WebDriver Driver, By Locators , String ElementName , int ChidIndex){


        try{
            EngineLogger.EngineInfo("Locating web elements [" + ElementName+ "]" + "By Locator :" + Locators );

            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.visibilityOfElementLocated(Locators));
            ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(false);", Driver.findElements(Locators).get(ChidIndex));

            if (!Driver.findElement(Locators).isDisplayed()) {
                EngineLogger.EngineError("Elements located by : "+ Locators+ " are all not displayed");
                throw new Exception();
            }
        }
        catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to locate web elements : " + ElementName + "By Locator :" + Locators , E );
        }
    }


    }


