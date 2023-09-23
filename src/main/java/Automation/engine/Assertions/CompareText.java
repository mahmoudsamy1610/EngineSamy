package Automation.engine.Assertions;

import Automation.engine.reportingWorks.AllureStepLogger;
import org.testng.Assert;

public class CompareText {

    public static void CheckText(String ActualText, String ExpectedText, String ExpectedTextName) {

        AllureStepLogger.logStep("Check that  [" + ExpectedTextName + "] is [" + ActualText + "]");
        Assert.assertEquals(ActualText, ExpectedText);

    }


}