package automation.engine.Assertions;

import automation.engine.reportingWorks.AllureStepLogger;
import org.testng.Assert;

public class CompareText {

    public static void CheckText(String ActualText, String ExpectedText, String ExpectedTextName) {

        AllureStepLogger.logStep("Check that  [" + ExpectedTextName + "] is [" + ActualText + "]");
        Assert.assertEquals(ActualText, ExpectedText);

    }


}