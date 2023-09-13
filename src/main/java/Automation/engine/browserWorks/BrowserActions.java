package Automation.engine.browserWorks;

import Automation.engine.loggers.Loggers;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.reportingWorks.AllureStepLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrowserActions {

    // these variables are set in the properties file and in configuration
    public static boolean MaxWindow = Boolean.parseBoolean(PropertyGetter.GetPropertyValue("RunOptions","Maximize"));
    public static int WindowWidth = Integer.parseInt(PropertyGetter.GetPropertyValue("RunOptions","width"));
    public static int WindowHeight = Integer.parseInt(PropertyGetter.GetPropertyValue("RunOptions","height"));



    //Method to navigate to specific URL
    public static void goToUrl(WebDriver Driver, String Url , String PageName){
        try {
            Driver.get(Url);
            AllureStepLogger.logStep("Go to " + PageName + " page" );
            Loggers.Info("Go to " + PageName + " Page " + " at : " +  Url  );
        }
        catch (Exception E) {
            Loggers.ExceptionError("Failed to go to " + PageName + " Page " + " at : " +  Url , E);
            AllureStepLogger.logStep("Go to " + PageName + " page" );
            Assert.fail("Failed to go to " + PageName + " Page " + " at : " +  Url , E);

        }

    }

    //Method to size the browser window
    public static void SetWindowSize(WebDriver driver) {

        if (MaxWindow == true ){
            try{
                driver.manage().window().maximize();
                AllureStepLogger.logStep("Maximize browser window");
                Loggers.Info("Maximizing Browser Window");
            }
            catch (Exception E){
                Loggers.ExceptionError("Failed to Maximize window" , E);
                AllureStepLogger.logStep("Maximize browser window");
                Assert.fail("Failed to Maximize window" , E);

            }

        }else {
           try {
               Dimension dimension = new Dimension(WindowWidth, WindowHeight );
                driver.manage().window().setSize(dimension);
               Loggers.Info("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight );
                AllureStepLogger.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight );

           }
           catch (Exception E){
               Loggers.ExceptionError("unknown Error while controlling browser window dimensions Width = " + WindowWidth + " and,  Height = " +  WindowHeight  , E);
               AllureStepLogger.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight);
               Assert.fail("unknown Error while controlling browser window dimensions Width = " + WindowWidth + " and,  Height = " +  WindowHeight , E);
           }

        }

        }



    public static void Shutdown(WebDriver driver) {
        try {

            AllureStepLogger.logStep("Close Browser");
            Loggers.Info("Close Browser");
            driver.quit();
        } catch (Exception E) {
            Loggers.ExceptionError("Unknown Error while closing  browser", E);
            AllureStepLogger.logStep("Close Browser");
            Assert.fail("Unknown Error while closing  browser", E);

        }
    }

    public static void main(String[] args) {

        WebDriver Driver;
        WebDriverManager.chromedriver().setup();
        Driver = new ChromeDriver();
        SetWindowSize(Driver);
    }
}


