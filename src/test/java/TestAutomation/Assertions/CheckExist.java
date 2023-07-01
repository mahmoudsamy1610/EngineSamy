package TestAutomation.Assertions;

import Automation.engine.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckExist {


    public static void CheckElementIsExist(WebElement Element , String ElementName ){

        Logger.logStep("Check that [" + ElementName + "] is existing and active" );
        Assert.assertTrue(Element.isDisplayed());

    }

}
