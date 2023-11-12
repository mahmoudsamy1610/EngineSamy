package automation.engine.elementWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class LocatorActions {



    public static WebElement locateElement (WebDriver Driver, By Locator , String ElementName){


        try{
            EngineLogger.EngineInfo("Locating web element [" + ElementName+ "]" + " By Locator :" + Locator );

            WebElement Element;
            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.elementToBeClickable(Locator));
            Element =  Driver.findElement(Locator);
            return Element;
        }

        catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to locate element : " + ElementName + "By Locator :" + Locator , E );
        }
        return null;
    }



    public static WebElement locateElements(WebDriver Driver, By Locators , String ElementName , int ChidIndex){


        try{
            EngineLogger.EngineInfo("Locating web elements [" + ElementName+ "]" + "By Locator :" + Locators );

            WebElement Element;
            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.elementToBeClickable(Locators));
            Element =  Driver.findElements(Locators).get(ChidIndex);
            return Element;
        }

        catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to locate web elements : " + ElementName + "By Locator :" + Locators , E );
        }
        return null;
    }


    public static WebElement LocateElementRightByTagName (WebDriver Driver, By DefinerLocator , String TagName , String ElementName ){

        try{
            EngineLogger.EngineInfo("Locating web element [" + ElementName+ "]" + "on the right side of :" + DefinerLocator );

            WebElement Element;
            Objects.requireNonNull(WaitManager.useExplicitWait(Driver)).until(ExpectedConditions.visibilityOfElementLocated(DefinerLocator));
            Element =  Driver.findElement(RelativeLocator.with(By.tagName(TagName)).toRightOf(DefinerLocator));

            return Element;

        }

        catch (Exception E){
            EngineLogger.EngineExceptionError("Failed Locating web element [" + ElementName+ "]" + "on the right side of :" + DefinerLocator , E );
        }
        return null;
    }


    }


