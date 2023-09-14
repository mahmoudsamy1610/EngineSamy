package Automation.engine.browserWorks;

import Automation.engine.loggers.Loggers;
import Automation.engine.reportingWorks.AllureStepLogger;
import Automation.engine.setupWorks.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserRunner {


    public static WebDriver StartBrowser(){


            try {
                Loggers.Info("Starting Browser ......");

                WebDriver driver;
                driver = SetupFactory.Run();
                AllureStepLogger.logStep("Start Browser");
                    return driver;
                }
                catch (Exception E ){
                    Loggers.ExceptionError("(unknown) Error while Start browser" , E);
                    AllureStepLogger.logStep("Start browser");
                    Assert.fail("(unknown) Error while Start browser", E);

                }
        return  null ;
    }


    public static void main(String[] args) {
        StartBrowser();

    }


}
