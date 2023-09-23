package Automation.engine.browserWorks;

import Automation.engine.listeners.EventListener;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

import java.net.URL;

public class StaBrowserFactory {



    public static WebDriver SetStaBrowserType(String StaBrowserType){
        EngineLogger.EngineInfo("Initializing driver {Stand alone grid} " + StaBrowserType);
        AllureStepLogger.logStep("Initializing driver {Stand alone grid} " + StaBrowserType);


        if (StaBrowserType.equalsIgnoreCase("Chrome")) {
            try{

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String StaGridUrl = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost");
                URL url = new URL(StaGridUrl);

                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(url, chromeOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                return decoratedDriver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Stand alone grid}" + StaBrowserType , E);
                AllureStepLogger.logStep("Initializing driver {Stand alone grid} " + StaBrowserType);
                Assert.fail("Unknown error while Initializing browser {Stand alone grid}" + StaBrowserType, E);
            }

        } else if (StaBrowserType.equalsIgnoreCase("Firefox") ) {
            try{

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String StaGridUrl = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost");  ;
                URL url = new URL(StaGridUrl);

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(url, firefoxOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
                return decoratedDriver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Stand alone grid}" + StaBrowserType , E);
                AllureStepLogger.logStep("Initializing driver {Stand alone grid} " + StaBrowserType);
                Assert.fail("Unknown error while Initializing browser {Stand alone grid}" + StaBrowserType, E);
            }

        }else if (StaBrowserType.equalsIgnoreCase("MicrosoftEdge") ) {
            try{

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String StaGridUrl = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost");  ;
                URL url = new URL(StaGridUrl);

                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new RemoteWebDriver(url, edgeOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
                return decoratedDriver;
            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing browser {Stand alone grid}" + StaBrowserType , E);
                AllureStepLogger.logStep("Initializing driver {Stand alone grid} " + StaBrowserType);
                Assert.fail("Unknown error while Initializing browser {Stand alone grid}" + StaBrowserType, E);
            }

        }  else {
            EngineLogger.EngineError("Unknown error while Initializing browser {Stand alone grid}: " + StaBrowserType);
            AllureStepLogger.logStep("Initializing driver {Stand alone grid} : " + StaBrowserType);
            Assert.fail("Unknown error while Initializing browser {Stand alone grid} : " + StaBrowserType);

        }

        return null;

    }


}
