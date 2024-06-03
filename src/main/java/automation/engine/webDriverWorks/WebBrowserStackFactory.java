package automation.engine.webDriverWorks;

import automation.engine.config.ConfigExecutionType;
import automation.engine.listeners.EventListener;
import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.loggers.EngineLogger;
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

public class WebBrowserStackFactory {


        public static WebDriver SetBrowserStackBrowserType(String BrowserType) {


            try {

                EngineLogger.EngineInfo("Selecting webdriver {browser stack} : " + BrowserType);
                AllureStepLogger.logStep("Start browser {browser stack} : " + BrowserType);

                if (BrowserType.equalsIgnoreCase("Chrome")){
                    return SetupChromeDriver();
                }else if (BrowserType.equalsIgnoreCase("firefox")){
                    return SetupFirefoxDriver();
                }else if (BrowserType.equalsIgnoreCase("MicrosoftEdge")){
                    return SetupEdgeDriver();
                } else {
                    EngineLogger.EngineError("Invalid browser type provided {browser stack} : " + BrowserType);
                    throw new IOException();
                }

            }catch (Exception E){
                EngineLogger.EngineExceptionError("Error while Selecting webdriver {browser stack} " + BrowserType , E);
                AllureStepLogger.logStep("Start browser {browser stack} " + BrowserType);
                Assert.fail("Failed starting browser {browser stack} " + BrowserType , E);
            }

            return null;
        }




        public static WebDriver SetupChromeDriver() {

            WebDriver decoratedDriver ;
            boolean IsHeadless = Boolean.parseBoolean(ConfigExecutionType.GetHeadless());

            try {
                WebDriver driver;
                WebDriverListener listener ;
                ChromeOptions chromeOptions = new ChromeOptions();

                if (IsHeadless){
                    EngineLogger.EngineInfo("Headless mode decided as isHeadless = "+ true);
                    chromeOptions.addArguments("--headless=new") ;
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), chromeOptions);;
                }else {
                    EngineLogger.EngineInfo("Headless mode decided as isHeadless = "+ false);

                    WebDriverManager.chromedriver().setup();
                    driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), chromeOptions);

                }

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
            boolean IsHeadless = Boolean.parseBoolean(ConfigExecutionType.GetHeadless());

            try {
                WebDriver driver;
                WebDriverListener listener;
                FirefoxOptions firefoxOptions = new FirefoxOptions();


                if (IsHeadless){
                    EngineLogger.EngineInfo("Headless mode decided as isHeadless = "+ true);
                    firefoxOptions.addArguments("--headless") ;
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                }else {
                    EngineLogger.EngineInfo("Headless mode decided as isHeadless = "+ false);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }


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
            boolean IsHeadless = Boolean.parseBoolean(ConfigExecutionType.GetHeadless());

            try {
                WebDriver driver;
                WebDriverListener listener;
                EdgeOptions edgeOptions = new EdgeOptions();


                if (IsHeadless){
                    EngineLogger.EngineInfo("Headless mode decided as isHeadless = "+ true);
                    edgeOptions.addArguments("--headless") ;
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(edgeOptions);
                }else {
                    EngineLogger.EngineInfo("Headless mode decided as isHeadless = "+ false);
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }

                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);


            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Error while setting up web driver", E);
                throw new NullPointerException();
            }
            return decoratedDriver;
        }


        }



