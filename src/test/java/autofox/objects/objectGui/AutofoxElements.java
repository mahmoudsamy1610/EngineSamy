package autofox.objects.objectGui;

import automation.engine.browserWorks.BrowserFactory;
import automation.engine.elementWorks.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

public class AutofoxElements {

    //Variables
    WebDriver driver ;

    //Locators
    public static By HeaderLogo = By.cssSelector("a.nav-link") ;
    public static By LoggedInEmailElement = By.cssSelector("a[role=button]");
    public static By LogoutButton = By.cssSelector("a.dropdown-item.clickable");

    //constructor
    public AutofoxElements(WebDriver driver) {
        this.driver = driver;
    }


    public  String GetLoggedInEmail(){
       String  LoggedInEmail =  ElementActions.GetElementText(driver, LoggedInEmailElement , "Logged in email") ;
        return LoggedInEmail ;
    }

    public void LogOut() {

        ElementActions.clickElement(driver , LoggedInEmailElement , "Logged in email button");
        ElementActions.clickElement(driver , LogoutButton , "Log Out Button");

    }



}
