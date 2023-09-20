package Automation.engine.elementWorks;

import Automation.utils.loggers.EngineLogger;
import Automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class ElementActions {


    public static void clearText(WebDriver Driver, By Locator , String ElementName){


        try {
            EngineLogger.EngineInfo("Clearing Text inside field : " + ElementName + "By Locator :" + Locator);

            ElementHelper.locateElement(Driver, Locator , ElementName).clear();
            AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);
        }

        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to clear text in field : " + ElementName + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);
            Assert.fail("Failed to clear text in field : " + ElementName , E);
        }
    }


    public static void writeText(WebDriver Driver, By Locator, String text , String ElementName){

        try {
            EngineLogger.EngineInfo("Writing : ["+ text +  "] in : [" +ElementName+ "]" + "By Locator :" + Locator );

            ElementHelper.locateElement(Driver, Locator, ElementName).sendKeys(text);
           AllureStepLogger.logStep("Write : ["+ text +  "] in : [" +ElementName+ "]"  );

        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to write : ["+ text +  "] in : [" +ElementName+ "]" + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Clearing Text inside field : " + ElementName);
            Assert.fail("Failed to clear text in field : " + ElementName , E);
        }

    }

    public static void clickElement(WebDriver Driver , By Locator , String ElementName){

        try {
            EngineLogger.EngineInfo("Clicking on [" + ElementName+ "]" + "By Locator :" + Locator);

            ElementHelper.locateElement(Driver, Locator, ElementName).click();
            AllureStepLogger.logStep("Click on [" + ElementName+ "]" );
            }

        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed to click on :[" + ElementName+ "]" + "By Locator :" + Locator , E);
            AllureStepLogger.logStep("Click on [" + ElementName+ "]" );
            Assert.fail(" Failed to click on :[" + ElementName+ "]"  , E);
        }
    }

    public static String GetElementText(WebDriver Driver , By Locator , String ElementName){

        try {
            String ElementText;
            ElementText =  ElementHelper.locateElement(Driver, Locator, ElementName).getText();
            AllureStepLogger.logStep("Check the text in [" + ElementName+ "]" );
            EngineLogger.EngineInfo("Checking the text in [" + ElementName+ "]" + "By Locator :" + Locator);

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
