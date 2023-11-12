package automation.engine.elementWorks;

import automation.utils.loggers.EngineLogger;
import automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;


public class ElementActions {


    public static void ClearText(WebDriver Driver, By Locator , String ElementName){
        EngineLogger.EngineInfo("Clearing Text inside field : " + ElementName + "By Locator :" + Locator);
        AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);

        try {
                Objects.requireNonNull(LocatorActions.locateElement(Driver, Locator, ElementName)).clear();
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to clear text in field : " + ElementName + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);
            Assert.fail("Failed to clear text in field : " + ElementName , E);
        }
    }


    public static void WriteText(WebDriver Driver, By Locator, String text , String ElementName){
        EngineLogger.EngineInfo("Writing : ["+ text +  "] in : [" +ElementName+ "]" + "By Locator :" + Locator );
        AllureStepLogger.logStep("Write : ["+ text +  "] in : [" +ElementName+ "]"  );

        try {
            Objects.requireNonNull(LocatorActions.locateElement(Driver, Locator, ElementName)).sendKeys(text);
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to write : ["+ text +  "] in : [" +ElementName+ "]" + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);
            Assert.fail("Failed to clear text in field : " + ElementName , E);
        }

    }

    public static void ClickElement(WebDriver Driver , By Locator , String ElementName){
        EngineLogger.EngineInfo("Clicking on [" + ElementName+ "]" + "By Locator :" + Locator);
        AllureStepLogger.logStep("Click on [" + ElementName+ "]" );

        try {
                Objects.requireNonNull(LocatorActions.locateElement(Driver, Locator, ElementName)).click();
            }
        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed to click on :[" + ElementName+ "]" + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Click on [" + ElementName+ "]" );
            Assert.fail(" Failed to click on :[" + ElementName+ "]"  , E);
        }
    }

    public static String GetElementText(WebDriver Driver , By Locator , String ElementName){
        EngineLogger.EngineInfo("Checking the text in [" + ElementName+ "]" + "By Locator :" + Locator);
        AllureStepLogger.logStep("Check the text in [" + ElementName+ "]" );

        try {
            String ElementText;
            ElementText =  Objects.requireNonNull(LocatorActions.locateElement(Driver, Locator, ElementName)).getText();
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
