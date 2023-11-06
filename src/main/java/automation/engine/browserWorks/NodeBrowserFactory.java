package automation.engine.browserWorks;

import automation.utils.loggers.EngineLogger;
import automation.utils.propertyWorks.PropertyGetter;
import automation.engine.listeners.EventListener;
import automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;

public class NodeBrowserFactory {












    public static WebDriver SetNodeBrowserType_2(String NodePlatformType , String NodeBrowserType ){
        EngineLogger.EngineInfo("Initializing Chrome driver {Grid node} : "+ NodeBrowserType + " on : " + NodePlatformType);
        AllureStepLogger.logStep("Initializing Chrome driver {Grid node} : "+ NodeBrowserType + " on : " + NodePlatformType);

        if (NodeBrowserType.equalsIgnoreCase("Chrome")) {
            try{
                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
                URL url = new URL(HubUrl);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, chromeOptions);
                listener = new EventListener();
               decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
                return decoratedDriver;

            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing Chrome browser {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType , E);
                AllureStepLogger.logStep("Initializing Chrome driver {Grid node} : "+ NodeBrowserType + " on : " + NodePlatformType);
                Assert.fail("Unknown error while Initializing Chrome browser {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType, E);
            }

        } else if (NodeBrowserType.equalsIgnoreCase("Firefox") ) {

            try{
                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
                URL url = new URL(HubUrl);

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, firefoxOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
                return decoratedDriver;

            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing FireFox browser {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType , E);
                AllureStepLogger.logStep("Initializing FireFox driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                Assert.fail("Unknown error while Initializing FireFox browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType, E);
            }

        } else if (NodeBrowserType.equalsIgnoreCase("MicrosoftEdge") ) {

            try {
                WebDriver driver;
                WebDriverListener listener;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
                URL url = new URL(HubUrl);

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, edgeOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
                return decoratedDriver;

            }
            catch (Exception E) {
                EngineLogger.EngineExceptionError("Unknown error while Initializing Edge browser {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType , E);
                AllureStepLogger.logStep("Initializing Edge driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                Assert.fail("Unknown error while Initializing Edge browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType, E);
            }
        }
             else if (NodeBrowserType.equalsIgnoreCase("Safari")) {

                try{
                    WebDriver driver;
                    WebDriverListener listener ;
                    WebDriver decoratedDriver;

                    String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
                    URL url = new URL(HubUrl);

                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setPlatformName(NodePlatformType) ;
                    driver = new RemoteWebDriver(url, safariOptions);
                    listener = new EventListener();
                    decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
                    return decoratedDriver;

                }
                catch (Exception E) {
                    EngineLogger.EngineExceptionError("Unknown error while Initializing Safari browser {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType , E);
                    AllureStepLogger.logStep("Initializing Safari driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                    Assert.fail("Unknown error while Initializing Safari browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType, E);
                }

            } else {
            EngineLogger.EngineError("Invalid Driver or Driver not found {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType);
            AllureStepLogger.logStep("Initializing driver {Grid node} : " + NodeBrowserType);
            Assert.fail("Invalid Driver or Driver not found {Grid node} : " + NodeBrowserType);
        }


        return null;

    }





    public static WebDriver SetNodeBrowserType(String NodePlatformType , String NodeBrowserType ){

        try {

            EngineLogger.EngineInfo("Selecting Node Browser {HUB grid} : " + NodeBrowserType);
            AllureStepLogger.logStep("Start Browser {HUB grid} : " + NodeBrowserType);


            if (NodeBrowserType.equalsIgnoreCase("Chrome")){
                return SetupNodeChromeDriver(NodePlatformType);
            }else if (NodeBrowserType.equalsIgnoreCase("firefox")){
                return SetupNodeFirefoxDriver(NodePlatformType);
            }else if (NodeBrowserType.equalsIgnoreCase("MicrosoftEdge")){
                return SetupNodeEdgeDriver(NodePlatformType);
            }else if (NodeBrowserType.equalsIgnoreCase("Safari")){
                return SetupNodeSafari(NodePlatformType);
            } else {
                EngineLogger.EngineError("Invalid browser type provided {HUB grid}  : " + NodeBrowserType);
                throw new IOException();
            }

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Error while Selecting webdriver {HUB grid} " + NodeBrowserType , E);
            AllureStepLogger.logStep("Start browser {{HUB grid}} " + NodeBrowserType);
            Assert.fail("Failed starting browser {{HUB grid}} " + NodeBrowserType , E);
        }

        return null;
    }





    public static WebDriver SetupNodeChromeDriver(String NodePlatformType) {

        WebDriver decoratedDriver ;

        try {
            WebDriver driver;
            WebDriverListener listener ;

            String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
            URL url = new URL(HubUrl);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPlatformName(NodePlatformType) ;
            driver = new RemoteWebDriver(url, chromeOptions);
            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up remote web driver {Grid hub}", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }



    public static WebDriver SetupNodeFirefoxDriver(String NodePlatformType) {

        WebDriver decoratedDriver ;

        try {
            WebDriver driver;
            WebDriverListener listener ;

            String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
            URL url = new URL(HubUrl);

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPlatformName(NodePlatformType) ;
            driver = new RemoteWebDriver(url, firefoxOptions);
            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up remote web driver {Grid hub}", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }



    public static WebDriver SetupNodeEdgeDriver(String NodePlatformType) {

        WebDriver decoratedDriver;
        try {
            WebDriver driver;
            WebDriverListener listener;

            String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
            URL url = new URL(HubUrl);

            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPlatformName(NodePlatformType) ;
            driver = new RemoteWebDriver(url, edgeOptions);
            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up remote web driver {Grid hub}", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }


    public static WebDriver SetupNodeSafari(String NodePlatformType) {

        WebDriver decoratedDriver;
        try {
            WebDriver driver;
            WebDriverListener listener ;

            String HubUrl = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost");
            URL url = new URL(HubUrl);

            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setPlatformName(NodePlatformType) ;
            driver = new RemoteWebDriver(url, safariOptions);
            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up remote web driver {Grid hub}", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }


}
