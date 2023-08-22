package Automation.engine.browserWorks;

import Automation.engine.reportingworks.EventListener;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.reportingworks.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

import java.net.URL;

public class StaBrowserFactory {



    public static WebDriver SetStaBrowserType(String StaBrowserType){

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

                Logger.logStep("Initializing Chrome driver  {Stand alone grid} ");
                return decoratedDriver;
            }
            catch (Exception e) {
                Logger.logStep("Initializing Chrome driver {Stand alone grid} ");
                Assert.fail("Unknown error while Initializing Chrome browser {Stand alone grid} ");
                System.out.println("Unknown Error while Initializing Chrome browser {Stand alone grid} ");
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

                Logger.logStep("Initializing firefox driver {Stand alone grid} ");
                return decoratedDriver;
            }
            catch (Exception e) {
                Logger.logStep("Initializing FireFox driver {Stand alone grid} ");
                Assert.fail("Unknown error while Initializing FireFox browser {Stand alone grid} ");
                System.out.println("Unknown Error while Initializing FireFox browser {Stand alone grid} ");
            }

        } else {
            Assert.fail("Invalid Driver or Driver not found");
            System.out.println("Invalid Driver or Driver not found");

        }

        return null;

    }


}
