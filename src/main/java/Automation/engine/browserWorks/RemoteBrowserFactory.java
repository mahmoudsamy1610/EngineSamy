package Automation.engine.browserWorks;

import Automation.engine.reportingworks.EventListener;
import Automation.engine.propertyWorks.GetProperty;
import Automation.engine.reportingworks.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

import java.net.URL;

public class RemoteBrowserFactory {



    public static WebDriver SetRemoteBrowserType(String RemoteBrowserType){

        if (RemoteBrowserType.equalsIgnoreCase("Chrome")) {
            try{

                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String GridUrl = GetProperty.GetPropertyValue("RunOptions","RemoteHost");
                URL url = new URL(GridUrl);


                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(url, chromeOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Logger.logStep("Initializing Chrome driver {Remotely} ");
                return decoratedDriver;
            }
            catch (Exception e) {
                Logger.logStep("Initializing Chrome driver {Remotely} ");
                Assert.fail("Unknown error while Initializing Chrome browser {Remotely} ");
                System.out.println("Unknown Error while Initializing Chrome browser {Remotely} ");
            }

        } else if (RemoteBrowserType.equalsIgnoreCase("Firefox") ) {
            try{
                WebDriver driver;
                WebDriverListener listener ;
                WebDriver decoratedDriver;

                String GridUrl = GetProperty.GetPropertyValue("RunOptions","RemoteHost");  ;
                URL url = new URL(GridUrl);


                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(url, firefoxOptions);
                listener = new EventListener();
                decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);

                Logger.logStep("Initializing firefox driver {Remotely} ");
                return decoratedDriver;
            }
            catch (Exception e) {
                Logger.logStep("Initializing FireFox driver");
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
