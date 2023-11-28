package automation.engine.Assertions;

import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.loggers.EngineLogger;
import org.testng.Assert;

public class CompareText {

    public static void CheckText(String ActualText, String ExpectedText, String ExpectedTextName) {

        AllureStepLogger.logStep("Check that  [" + ExpectedTextName + "] is [" + ActualText + "]");
        EngineLogger.EngineInfo("Check that  [" + ExpectedTextName + "] is [" + ActualText + "]");
        Assert.assertTrue(ActualText.contains(ExpectedText) ,  " The Actual  text: " +ActualText+ " -- does not equal or include the Expected text : " +ExpectedText );

    }


}
