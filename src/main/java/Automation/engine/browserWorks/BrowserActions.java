package Automation.engine.browserWorks;

import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.reportingWorks.AllureStepLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrowserActions {

    // these variables are set in the properties file and in configuration -check
    public static boolean MaxWindow = Boolean.parseBoolean(PropertyGetter.GetPropertyValue("RunOptions","Maximize"));
    public static int WindowWidth = Integer.parseInt(PropertyGetter.GetPropertyValue("RunOptions","width"));
    public static int WindowHeight = Integer.parseInt(PropertyGetter.GetPropertyValue("RunOptions","height"));



    //Method to navigate to specific URL
    public static void goToUrl(WebDriver Driver, String Url , String PageName){
        EngineLogger.EngineInfo("redirecting to : " + PageName + " Page " + " at : " +  Url  );
        AllureStepLogger.logStep("Go to " + PageName + " page" );

        try {
            Driver.get(Url);
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to go to " + PageName + " Page " + " at : " +  Url , E);
            AllureStepLogger.logStep("Go to " + PageName + " page" );
            Assert.fail("Failed to go to " + PageName + " Page " + " at : " +  Url , E);

        }

    }

    //Method to size the browser window
    public static void SetWindowSize(WebDriver driver) {


        if (MaxWindow == true ){
            try{
                driver.manage().window().maximize();

                EngineLogger.EngineInfo("Maximizing Browser Window");
                AllureStepLogger.logStep("Maximize browser window");
            }
            catch (Exception E){
                EngineLogger.EngineExceptionError("Failed to Maximize window" , E);
                AllureStepLogger.logStep("Maximize browser window");
                Assert.fail("Failed to Maximize window" , E);
            }
        }else {
           try {
               Dimension dimension = new Dimension(WindowWidth, WindowHeight );
                driver.manage().window().setSize(dimension);

               EngineLogger.EngineInfo("Setting window size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight );
                AllureStepLogger.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight );

           }
           catch (Exception E){
               EngineLogger.EngineExceptionError("unknown Error while controlling browser window dimensions Width = " + WindowWidth + " and,  Height = " +  WindowHeight  , E);
               AllureStepLogger.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight);
               Assert.fail("unknown Error while controlling browser window dimensions Width = " + WindowWidth + " and,  Height = " +  WindowHeight , E);
           }

        }

        }



    public static void Shutdown(WebDriver driver) {
        EngineLogger.EngineInfo("Closing Browser");
        AllureStepLogger.logStep("Close Browser");

        try {
            driver.quit();
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Unknown Error while closing  browser", E);
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


