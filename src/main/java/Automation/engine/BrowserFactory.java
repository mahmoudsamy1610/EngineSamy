package Automation.engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class BrowserFactory {



    public static WebDriver SetBrowserType(String BrowserType){


        if (BrowserType.equalsIgnoreCase("Chrome")) {
            try{
                WebDriver driver;
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                Logger.logStep("Initializing Chrome driver");
                return driver;
            }
            catch (Exception e) {
                Logger.logStep("Initializing Chrome driver");
                Assert.fail("Unknown error while Initializing Chrome browser");
                System.out.println("Unknown Error while Initializing Chrome browser");
            }

        } else if (BrowserType.equalsIgnoreCase("Firefox") ) {
            try{
                WebDriver driver;
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                Logger.logStep("Initializing FireFox driver");
                return driver;
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

        return null;
    }



}
