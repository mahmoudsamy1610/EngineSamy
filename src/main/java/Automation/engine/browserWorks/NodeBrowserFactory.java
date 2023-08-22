package Automation.engine.browserWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.reportingworks.EventListener;
import Automation.engine.reportingworks.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.net.URL;

public class NodeBrowserFactory {



    @Parameters(value = {"NodePlatformType", "NodeBrowserType"})
    public static WebDriver SetNodeBrowserType(String NodePlatformType , String NodeBrowserType){

        if (NodeBrowserType.equalsIgnoreCase("Chrome")) {
            try{

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubGridHost");
                URL url = new URL(HubUrl);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, chromeOptions);
                listener = new EventListener();
               decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Logger.logStep("Initializing Chrome driver {Grid node} ");
                return decoratedDriver;
            }
            catch (Exception e) {
                Logger.logStep("Initializing Chrome driver {Grid node} ");
                Assert.fail("Unknown error while Initializing Chrome browser {Grid node} ");
                System.out.println("Unknown Error while Initializing Chrome browser {Grid node} ");
            }

        } else if (NodeBrowserType.equalsIgnoreCase("Firefox") ) {
            try{
                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubGridHost");
                URL url = new URL(HubUrl);

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, firefoxOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Logger.logStep("Initializing firefox driver {Grid node} ");
                return decoratedDriver;
            }
            catch (Exception e) {
                Logger.logStep("Initializing FireFox driver {Grid node} ");
                Assert.fail("Unknown error while Initializing FireFox browser {Grid node} ");
                System.out.println("Unknown Error while Initializing FireFox browser {Grid node} ");
            }

        } else if (NodeBrowserType.equalsIgnoreCase("Edge") ) {
            try {
                WebDriver driver;
                WebDriverListener listener;
                WebDriver decoratedDriver;

                String HubUrl = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubGridHost");
                URL url = new URL(HubUrl);

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(NodePlatformType) ;
                driver = new RemoteWebDriver(url, edgeOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Logger.logStep("Initializing Edge driver {Grid node} ");
                return decoratedDriver;
            } catch (Exception e) {
                Logger.logStep("Initializing Edge driver {Grid node} ");
                Assert.fail("Unknown error while Initializing Edge browser {Grid node} ");
                System.out.println("Unknown Error while Initializing Edge browser {Grid node} ");
            }
        }



             else if (NodeBrowserType.equalsIgnoreCase("Safari")) {
                try{
                    WebDriver driver;
                    WebDriverListener listener ;
                    WebDriver decoratedDriver;

                    String HubUrl = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubGridHost");
                    URL url = new URL(HubUrl);

                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setPlatformName(NodePlatformType) ;
                    driver = new RemoteWebDriver(url, safariOptions);
                    listener = new EventListener();
                    decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                    Logger.logStep("Initializing Safari driver {Grid node} ");
                    return decoratedDriver;
                }
                catch (Exception e) {
                    Logger.logStep("Initializing Safari driver {Grid node} ");
                    Assert.fail("Unknown error while Initializing Safari browser {Grid node} ");
                    System.out.println("Unknown Error while Initializing Safari browser {Grid node} ");
                }




            } else {
            Assert.fail("Invalid Driver or Driver not found");
            System.out.println("Invalid Driver or Driver not found");

        }


        return null;

    }

}
