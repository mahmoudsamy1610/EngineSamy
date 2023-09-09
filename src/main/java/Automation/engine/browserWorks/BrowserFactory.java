package Automation.engine.browserWorks;

import Automation.engine.listeners.EventListener;
import Automation.engine.reportingWorks.Loggers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;


public class BrowserFactory {



    public static WebDriver SetBrowserType(String BrowserType){


        if (BrowserType.equalsIgnoreCase("Chrome")) {
            try{

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Loggers.logStep("Initializing Chrome driver");
                return decoratedDriver;
            }
            catch (Exception e) {
                Loggers.logStep("Initializing Chrome driver");
                Assert.fail("Unknown error while Initializing Chrome browser");
                System.out.println("Unknown Error while Initializing Chrome browser");
            }

        } else if (BrowserType.equalsIgnoreCase("Firefox") ) {
            try{
                WebDriver driver;
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                Loggers.logStep("Initializing FireFox driver");
                return driver;
            }
            catch (Exception e) {
                Loggers.logStep("Initializing FireFox driver");
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
