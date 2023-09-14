package Automation.engine.elementWorks;

import Automation.engine.loggers.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ElementHelper {



    public static WebElement locateElement (WebDriver Driver, By Locator , String ElementName){


        try{
            Loggers.Info("Locating web element [" + ElementName+ "]" + "By Locator :" + Locator );

            WebElement Element;
            //Wait for element to be displayed
            WaitManager.useExplicitWait(Driver).until(ExpectedConditions.visibilityOfElementLocated(Locator));
            //Make sure that element exists
            Element =  Driver.findElement(Locator);

            return Element;

        }

        catch (Exception E){
            Loggers.ExceptionError("Failed to locate element : " + ElementName + "By Locator :" + Locator , E );
            Assert.fail("Failed to locate element : " + ElementName , E );
        }
        return null;
    }



}
