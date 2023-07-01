package TestAutomation.Assertions;

import Automation.engine.Logger;
import org.testng.Assert;

public class CompareText {

    public static void CheckText(String ActualText, String ExpectedText, String ExpectedTextName) {


        Logger.logStep("Check that  [" + ExpectedTextName + "] is [" + ActualText + "]");
        Assert.assertEquals(ActualText, ExpectedText);


    }


}