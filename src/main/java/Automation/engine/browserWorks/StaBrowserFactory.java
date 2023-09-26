package Automation.engine.browserWorks;

import Automation.engine.listeners.EventListener;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.engine.reportingWorks.AllureStepLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;

public class StaBrowserFactory {


    public static WebDriver SetStaBrowserType(String StaBrowserType){

        try {

            EngineLogger.EngineInfo("Selecting Browser {Stand alone grid} : " + StaBrowserType);
            AllureStepLogger.logStep("Start Browser {Stand alone grid} : " + StaBrowserType);

            if (StaBrowserType.equalsIgnoreCase("Chrome")){
                return SetupStaChromeDriver();
            }else if (StaBrowserType.equalsIgnoreCase("firefox")){
                return SetupStaFirefoxDriver();
            }else if (StaBrowserType.equalsIgnoreCase("MicrosoftEdge")){
                return SetupStaEdgeDriver();
            } else {
                EngineLogger.EngineError("Invalid browser type provided {Stand Alone} : " + StaBrowserType);
                throw new IOException();
            }

        }catch (Exception E){
            EngineLogger.EngineError("Unknown error while Selecting browser {Stand alone grid}: " + StaBrowserType);
            AllureStepLogger.logStep("Starting browser {Stand alone grid} : " + StaBrowserType);
            Assert.fail("error while Starting browser {Stand alone grid} : " + StaBrowserType);
        }

        return null;
    }




    public static WebDriver SetupStaChromeDriver() {

        WebDriver decoratedDriver ;

        try {
            WebDriver driver;
            WebDriverListener listener ;

            String StaGridUrl = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost");
            URL url = new URL(StaGridUrl);

            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(url, chromeOptions);
            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up STA remote web driver", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }



    public static WebDriver SetupStaFirefoxDriver() {

        WebDriver decoratedDriver ;

        try {
            WebDriver driver;
            WebDriverListener listener ;

            String StaGridUrl = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost");  ;
            URL url = new URL(StaGridUrl);

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(url, firefoxOptions);
            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up STA remote web driver", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }



    public static WebDriver SetupStaEdgeDriver() {

        WebDriver decoratedDriver;
        try {
            WebDriver driver;
            WebDriverListener listener ;

            String StaGridUrl = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost");  ;
            URL url = new URL(StaGridUrl);

            EdgeOptions edgeOptions = new EdgeOptions();
            driver = new RemoteWebDriver(url, edgeOptions);
            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up STA remote web driver", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }





}
