package Automation.engine.browserWorks;

import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.engine.reportingWorks.AllureStepLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrowserActions {


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


    public static void MaxWindow(WebDriver driver){
        EngineLogger.EngineInfo("Maximizing Browser Window");
        AllureStepLogger.logStep("Maximize browser window");

            try{
                driver.manage().window().maximize();
            }catch (Exception E){
                EngineLogger.EngineExceptionError("Failed to Maximize window" , E);
                AllureStepLogger.logStep("Maximize browser window");
                Assert.fail("Failed to Maximize window" , E);
            }
        }


    //Method to size the browser window
    public static void SetWindowSize(WebDriver driver , int Width , int Height) {


           try {
               Dimension dimension = new Dimension(Width, Height );
                driver.manage().window().setSize(dimension);

               EngineLogger.EngineInfo("Setting window size to Width = " + Width + " and,  Height = " +  Height );
                AllureStepLogger.logStep("Set windows size to Width = " + Width + " and,  Height = " +  Height );

           }
           catch (Exception E){
               EngineLogger.EngineExceptionError("unknown Error while controlling browser window dimensions Width = " + Width + " and,  Height = " +  Height  , E);
               AllureStepLogger.logStep("Set windows size to Width = " + Width + " and,  Height = " +  Height);
               Assert.fail("unknown Error while controlling browser window dimensions Width = " + Width + " and,  Height = " +  Height , E);
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
        MaxWindow(Driver);
        SetWindowSize(Driver , 700 , 800);
    }
}


