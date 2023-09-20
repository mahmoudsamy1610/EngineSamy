package Automation.engine.Assertions;

import Automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckExist {


    public static void CheckElementIsExist(WebElement Element , String ElementName ){

        AllureStepLogger.logStep("Check that [" + ElementName + "] is existing and active" );
        Assert.assertTrue(Element.isDisplayed());

    }

}
