package Automation.engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SetupFactory {


    public static WebDriver Run(String BrowserType , String ExecutionType){
      return RunningSpace.SetRunningType(BrowserType ,  ExecutionType);
    }












//-------------------------Deprecated------------------------------------

    /*
    //Method of deciding the browser type
    public static  WebDriver SetRunStrategy(String BrowserType , String ExecutionType)  {


        if (ExecutionType.equalsIgnoreCase("Local") ) {
            if (BrowserType.equalsIgnoreCase("Chrome")) {
                try{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                Logger.logStep("Initializing Chrome driver");
                }
                catch (Exception e) {
                  Logger.logStep("Initializing Chrome driver");
                    Assert.fail("Unknown error while Initializing Chrome browser");
                    System.out.println("Unknown Error while Initializing Chrome browser");
                }

            } else if (BrowserType.equalsIgnoreCase("Firefox") ) {
              try{
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
               Logger.logStep("Initializing FireFox driver");
              }
              catch (Exception e) {
                  Logger.logStep("Initializing FireFox driver");
                  Assert.fail("Unknown error while Initializing FireFox browser");
                  System.out.println("Unknown Error while Initializing FireFox browser");
                }

            } else {
                Assert.fail("Invalid Driver or Driver not found");
                System.out.println("Invalid Driver or Driver not found");

            }

        }else if (ExecutionType.equalsIgnoreCase("Remote")) {
            System.out.println("Remote Implementation is not ready");

        }else {
            System.out.println("invalid Execution type");
        }

        return driver;

    }
*/



}
