package Automation.engine.browserWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.reportingWorks.Loggers;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserActions {

    // these variables are set in the properties file and in configuration
    public static boolean MaxWindow = Boolean.parseBoolean(PropertyGetter.GetPropertyValue("RunOptions","Maximize"));
    public static int WindowWidth = Integer.parseInt(PropertyGetter.GetPropertyValue("RunOptions","width"));
    public static int WindowHeight = Integer.parseInt(PropertyGetter.GetPropertyValue("RunOptions","height"));



    //Method to navigate to specific URL
    public static void goToUrl(WebDriver driver, String url , String PageName){
        try {
            driver.get(url);
            Loggers.logStep("Go to " + PageName + " page" );
        }
        catch (TimeoutException toe) {
                 Loggers.logStep("Go to " + PageName + " page" );
                 Assert.fail("(TimeOut) Error while navigating to " + PageName + " page");
                System.out.println("(TimeOut) Error while navigating to " + PageName + " page");

        }
        catch (Exception e){
            Loggers.logStep("Go to " + PageName + " page" );
            Assert.fail("(unknown) Error while navigating to " + PageName + " page");
            System.out.println("(unknown) Error while navigating to " + PageName + " page");

        }
    }

    //Method to size the browser window
    public static void SetWindowSize(WebDriver driver) {

        if (MaxWindow == true ){
            try{
                driver.manage().window().maximize();
                Loggers.logStep("Maximize browser window");
            }
            catch (Exception e){
                Loggers.logStep("Maximize browser window");
                Assert.fail("unknown Error while maximizing browser window");
                System.out.println("unknown Error while maximizing browser window");
            }

        }else {
           try {
               Dimension dimension = new Dimension(WindowWidth, WindowHeight );
                driver.manage().window().setSize(dimension);
                Loggers.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight );
           }
           catch (Exception e){
               Loggers.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight);
               Assert.fail("unknown Error while controlling browser window dimensions");
               System.out.println("unknown Error while controlling browser window dimensions");
           }

        }

        }



    public static void Shutdown(WebDriver driver){
        try {
            Loggers.logStep("Close Browser");
            driver.quit();
        }
        catch (Exception e) {
          Loggers.logStep("Close Browser");
          Assert.fail("Unknown Error while closing  browser");
          System.out.println("Unknown Error while closing browser");}
         }


}


