package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutofoxHeader {

    //Variables
    WebDriver driver ;

    //Locators
    public static By LoggedInEmailElement = By.cssSelector("a[role=button]");
    public static By LogoutButton = By.cssSelector("a.dropdown-item.clickable");

    //constructor
    public AutofoxHeader(WebDriver driver) {
        this.driver = driver;
    }


    public  String GetLoggedInEmail(){
       String  LoggedInEmail =  ElementActions.GetElementText(driver, LoggedInEmailElement , "Logged in email") ;
        return LoggedInEmail ;
    }

    public void ClickLogOut() {

        ElementActions.ClickElement(driver , LoggedInEmailElement , "Logged in email button" );
        ElementActions.ClickElement(driver , LogoutButton , "Log Out Button" );

    }



}
