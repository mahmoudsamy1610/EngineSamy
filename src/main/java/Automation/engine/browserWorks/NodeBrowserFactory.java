package Automation.engine.browserWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.listeners.EventListener;
import Automation.engine.reportingWorks.Loggers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

import java.net.URL;

public class NodeBrowserFactory {




    public static WebDriver SetNodeBrowserType(String NodePlatformType , String NodeBrowserType ){

        if (NodeBrowserType.equalsIgnoreCase("Chrome")) {
            try{

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridHost");
                URL url = new URL(HubUrl);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, chromeOptions);
                listener = new EventListener();
               decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Loggers.logStep("Initializing Chrome driver {Grid node} : "+ NodeBrowserType + " on : " + NodePlatformType);
                return decoratedDriver;
            }
            catch (Exception e) {
                Loggers.logStep("Initializing Chrome driver {Grid node} : "+ NodeBrowserType + " on : " + NodePlatformType);
                Assert.fail("Unknown error while Initializing Chrome browser {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType);
                System.out.println("Unknown Error while Initializing Chrome browser {Grid node} : " + NodeBrowserType + " on : " + NodePlatformType);
            }

        } else if (NodeBrowserType.equalsIgnoreCase("Firefox") ) {
            try{
                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridHost");
                URL url = new URL(HubUrl);

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, firefoxOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Loggers.logStep("Initializing firefox driver {Grid node} : "+ NodeBrowserType + " on : " + NodePlatformType);
                return decoratedDriver;
            }
            catch (Exception e) {
                Loggers.logStep("Initializing FireFox driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                Assert.fail("Unknown error while Initializing FireFox browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                System.out.println("Unknown Error while Initializing FireFox browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
            }

        } else if (NodeBrowserType.equalsIgnoreCase("MicrosoftEdge") ) {
            try {
                WebDriver driver;
                WebDriverListener listener;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridHost");
                URL url = new URL(HubUrl);

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, edgeOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Loggers.logStep("Initializing Edge driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                return decoratedDriver;
            } catch (Exception e) {
                Loggers.logStep("Initializing Edge driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                Assert.fail("Unknown error while Initializing Edge browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                System.out.println("Unknown Error while Initializing Edge browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
            }
        }



             else if (NodeBrowserType.equalsIgnoreCase("Safari")) {
                try{
                    WebDriver driver;
                    WebDriverListener listener ;
                    WebDriver decoratedDriver;

                    String HubUrl = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridHost");
                    URL url = new URL(HubUrl);

                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setPlatformName(NodePlatformType) ;
                    driver = new RemoteWebDriver(url, safariOptions);
                    listener = new EventListener();
                    decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                    Loggers.logStep("Initializing Safari driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                    return decoratedDriver;
                }
                catch (Exception e) {
                    Loggers.logStep("Initializing Safari driver {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                    Assert.fail("Unknown error while Initializing Safari browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                    System.out.println("Unknown Error while Initializing Safari browser {Grid node} "+ NodeBrowserType + " on : " + NodePlatformType);
                }




            } else {
            Assert.fail("Invalid Driver or Driver not found : " + NodeBrowserType);
            System.out.println("Invalid Driver or Driver not found : " + NodeBrowserType);

        }


        return null;

    }


    public static void main(String[] args) {

        SetNodeBrowserType("Linux" , "firefox").get("https://www.google.com"); ;

    }


}
