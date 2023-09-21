package Automation.engine.browserWorks;

import Automation.engine.loggers.EngineLogger;
import Automation.engine.reportingWorks.AllureStepLogger;
import Automation.engine.setupWorks.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserRunner {


    public static WebDriver StartBrowser(){
        EngineLogger.EngineInfo("Starting Browser ......");
        AllureStepLogger.logStep("Start Browser");

        try {
                WebDriver driver;
                driver = SetupFactory.Run();
                    return driver;
                }
                catch (Exception E ){
                    EngineLogger.EngineExceptionError("(unknown) Error while Start browser" , E);
                    AllureStepLogger.logStep("Start browser");
                    Assert.fail("(unknown) Error while Start browser", E);

                }
        return  null ;
    }


    public static void main(String[] args) {
        StartBrowser();

    }


}
