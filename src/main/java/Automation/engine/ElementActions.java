package Automation.engine;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



public class ElementActions {


    public static void clearText(WebDriver driver, By locator , String ElementName){


        try {
           ElementHelper.locateElement(driver, locator , ElementName).clear();
        }
        catch (TimeoutException toe) {
            System.out.println("(TimeOut) while clearing text" );
        }
        catch (Exception e) {Logger.logStep(e.getMessage());
            System.out.println("(TimeOut) Error while clearing text " );
        }
    }


    public static void writeText(WebDriver driver, By locator, String text , String ElementName){

      //  String ElementName =  ElementHelper.GetElementName(driver , locator);

        try {

          ElementHelper.locateElement(driver, locator, ElementName).sendKeys(text);
           Logger.logStep("in [" + ElementName +  "]" + " Insert [" + text + "]" );

        }
        catch (TimeoutException toe) {
           Logger.logStep("in [" + ElementName +  "]" + "Insert [" + text + "]" );
           Assert.fail("(TimeOut) Error while Typing --> [" + text + "]"  );
           System.out.println("(TimeOut) Error while Typing --> [" + text + "]" );
        }
        catch (Exception e) {
            Logger.logStep("Insert " + text + "]" );
            Assert.fail("(unknown) Error while Typing -->" + text+ "]" );
            System.out.println("(unknown) Error while Typing -->" + text+ "]" );
        }

    }

    public static void clickElement(WebDriver driver , By locator , String ElementName){

       // String ElementName =  ElementHelper.GetElementName(driver , locator);

        try {

            ElementHelper.locateElement(driver, locator, ElementName).click();
                Logger.logStep("click on [" + ElementName+ "]" );
            }
        catch (TimeoutException toe) {
            Logger.logStep("click on [" + ElementName+ "]" );
            Assert.fail("(TimeOut) Error while clicking on [" + ElementName+ "]" );
            System.out.println("(TimeOut) Error while clicking on [" + ElementName + "]" );
        }
        catch (Exception e) {
            Logger.logStep("click on [" + ElementName+ "]" );
            Assert.fail("(unknown) Error while clicking on [" + ElementName+ "]" );
            System.out.println("(unknown) Error while clicking on [" + ElementName+ "]" );
        }
    }

    public static String GetElementText(WebDriver driver , By locator , String ElementName){

       // String ElementName =  ElementHelper.GetElementName(driver , locator);

        try {
            String ElementText;
            ElementText =  ElementHelper.locateElement(driver, locator, ElementName).getText();
            Logger.logStep("Check the text in [" + ElementName+ "]" );
            return ElementText;

        }
        catch (TimeoutException toe) {
            Logger.logStep(("Check the text in [" + ElementName+ "]" ));
            Assert.fail("(TimeOut) Error while Checking the text from [" + ElementName+ "]" );
            System.out.println("(TimeOut) Error while Checking the text from [" + ElementName+ "]" );
        }
        catch (Exception e) {
           Logger.logStep("click on [" + ElementName);
            Assert.fail("(unknown) Error while Checking the text from [" + ElementName+ "]" );
            System.out.println("(unknown) Error while Checking the text from [" + ElementName+ "]" );
        }

        return null;
    }




    }
