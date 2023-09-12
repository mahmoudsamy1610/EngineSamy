package TestAutomation.Assertions;

import Automation.engine.reportingWorks.Loggers;
import org.testng.Assert;

public class CompareText {

    public static void CheckText(String ActualText, String ExpectedText, String ExpectedTextName) {


        Loggers.logStep("Check that  [" + ExpectedTextName + "] is [" + ActualText + "]");
        Assert.assertEquals(ActualText, ExpectedText);


    }


}