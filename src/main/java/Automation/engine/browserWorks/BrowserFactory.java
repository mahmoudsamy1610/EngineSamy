package Automation.engine.browserWorks;

import Automation.engine.listeners.EventListener;
import Automation.utils.loggers.EngineLogger;
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
        EngineLogger.EngineInfo("Initializing driver local} " + BrowserType);
        AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);


        if (BrowserType.equalsIgnoreCase("Chrome")) {

            try{
                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
                return decoratedDriver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Local} " + BrowserType , E);
                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                Assert.fail("Unknown error while Initializing browser {Local} " + BrowserType , E);
            }

        } else if (BrowserType.equalsIgnoreCase("Firefox") ) {

            try{
                WebDriver driver;
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Local} " + BrowserType , E);
                AllureStepLogger.logStep("Initializing driver {local} " + BrowserType);
                Assert.fail("Unknown error while Initializing browser {Local} " + BrowserType, E);
            }

        }else if (BrowserType.equalsIgnoreCase("MicrosoftEdge") ) {

            try{
                WebDriver driver;
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
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
