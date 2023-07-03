package Automation.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ElementHelper {



    public static WebElement locateElement (WebDriver driver, By locator , String ElementName){


        try{
            WebElement Element;
            //Wait for element to be displayed
            WaitManager.useExplicitWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
            //Make sure that element exists
            Element =   driver.findElement(locator);
            return Element;

        }
        catch (TimeoutException toe) {
            Assert.fail("(TimeOut) Error While detecting element " + ElementName );
            System.out.println("(TimeOut) Error While detecting element " + ElementName);
        }
        catch (Exception e ){
            Assert.fail("(unknown) Error While detecting element " + ElementName );
            System.out.println("(Unknown) Error While detecting element " + ElementName);
        }
        return null;
    }



 /* now Deprecated

    public static String GetElementName(WebDriver driver , By locator) {

        String ElementName = null;

        try {
            ElementName = locateElement(driver, locator, ElementName).getAccessibleName();

            if (ElementName.isEmpty()) {
                ElementName = locateElement(driver, locator, ElementName).getAttribute("id");
            }else if (ElementName.isEmpty()){
                ElementName = locateElement(driver, locator , ElementName).getText();
            } else {
                ElementName = "the correct field" ;
            }
        } catch (TimeoutException toe) {
            System.out.println("Cannot find element to get element name");

        } catch (Exception e) {
            System.out.println("Unknown error while getting element name");
        }
        return ElementName;



    }
*/



}
