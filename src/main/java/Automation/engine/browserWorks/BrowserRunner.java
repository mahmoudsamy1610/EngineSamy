package Automation.engine.browserWorks;

import Automation.engine.gridWorks.GridThreadsManager;
import Automation.engine.reportingWorks.Loggers;
import Automation.engine.setupWorks.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserRunner {


    public static WebDriver StartBrowser(){


            try {
                WebDriver driver;
             driver = SetupFactory.Run();
             Loggers.logStep("Start Browser");
             return driver;
                }
                catch (Exception e ){
                    Loggers.logStep("Start browser");
                    Assert.fail("(unknown) Error while Start browser");
                    System.out.println("(unknown) Error while Start browser");

                }
        return  null ;
    }


    public static void main(String[] args) {
        StartBrowser();

    }


}
