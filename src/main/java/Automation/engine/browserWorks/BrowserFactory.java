package Automation.engine.browserWorks;

import Automation.engine.listeners.EventListener;
import Automation.engine.loggers.EngineLogger;
import Automation.engine.reportingWorks.AllureStepLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;


public class BrowserFactory {



    public static WebDriver SetBrowserType(String BrowserType){


        if (BrowserType.equalsIgnoreCase("Chrome")) {
            try{
                EngineLogger.EngineInfo("Initializing driver local} " + BrowserType);

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                return decoratedDriver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Local} " + BrowserType , E);
                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                Assert.fail("Unknown error while Initializing browser {Local} " + BrowserType , E);
            }

        } else if (BrowserType.equalsIgnoreCase("Firefox") ) {
            try{
                EngineLogger.EngineInfo("Initializing driver local} " + BrowserType);


                WebDriver driver;
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                return driver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Local} " + BrowserType , E);
                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                Assert.fail("Unknown error while Initializing browser {Local} " + BrowserType, E);
            }

        }else if (BrowserType.equalsIgnoreCase("MicrosoftEdge") ) {
            try{
                EngineLogger.EngineInfo("Initializing driver local} " + BrowserType);

                WebDriver driver;
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                return driver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Local} " + BrowserType , E);
                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                Assert.fail("Unknown error while Initializing browser {Local} " + BrowserType, E);
            }

        } else {
            EngineLogger.EngineError("Unknown error while Initializing browser {Local} : " + BrowserType);
            AllureStepLogger.logStep("Initializing driver {Local} : " + BrowserType);
            Assert.fail("Unknown error while Initializing browser {Local} : " + BrowserType);
        }

        return null;
    }


    public static void main(String[] args) {
        SetBrowserType("MicrosoftEdge");
        SetBrowserType("MicrosoftEdge");
        SetBrowserType("firefox");


    }



}
