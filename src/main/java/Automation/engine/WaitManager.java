package Automation.engine;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

  public static int WaitTime;


    public static int getTimeout(){

         WaitTime =Integer.parseInt(GetProperty.GetPropertyValue("Time","ExplicitWait"));

        return WaitTime;
    }

    public static WebDriverWait useExplicitWait(WebDriver driver) {
                
        try {
            WebDriverWait wait;
            wait =  new WebDriverWait(driver, Duration.ofSeconds(getTimeout()));
               return wait;
        }
        catch (TimeoutException toe) {;
            System.out.println("(TimeOut Error) while waiting for the element to be displayed ");}
        catch (Exception e) {e.getMessage();
            System.out.println("unknown error while waiting for the element to be displayed");

        }
        return null;
    }


}
