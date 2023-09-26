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

import java.io.IOException;


public class BrowserFactory {


    public static WebDriver SetBrowserType(String BrowserType){

        try {

            EngineLogger.EngineInfo("Selecting webdriver {local} : " + BrowserType);
            AllureStepLogger.logStep("Start browser {local} : " + BrowserType);

            if (BrowserType.equalsIgnoreCase("Chrome")){
                return SetupChromeDriver();
            }else if (BrowserType.equalsIgnoreCase("firefox")){
                return SetupFirefoxDriver();
            }else if (BrowserType.equalsIgnoreCase("MicrosoftEdge")){
                return SetupEdgeDriver();
            } else {
                EngineLogger.EngineError("Invalid browser type provided {Local} : " + BrowserType);
                throw new IOException();
            }

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Error while Selecting webdriver {Local} " + BrowserType , E);
            AllureStepLogger.logStep("Start browser {local} " + BrowserType);
            Assert.fail("Failed starting browser {Local} " + BrowserType , E);
        }

        return null;
    }




    public static WebDriver SetupChromeDriver() {

        WebDriver decoratedDriver ;

        try {
            WebDriver driver;
            WebDriverListener listener;

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up web driver", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }



    public static WebDriver SetupFirefoxDriver() {

        WebDriver decoratedDriver ;

        try {
            WebDriver driver;
            WebDriverListener listener;

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up web driver", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }



    public static WebDriver SetupEdgeDriver() {

        WebDriver decoratedDriver;
        try {
            WebDriver driver;
            WebDriverListener listener;

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

            listener = new EventListener();
            decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Error while setting up web driver", E);
            throw new NullPointerException();
        }
        return decoratedDriver;
    }


}
