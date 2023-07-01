package Autofox.pages;

import Automation.engine.ElementActions;
import Automation.engine.ElementHelper;
import Automation.engine.Logger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutofoxGenericElements {

    //Variables
    WebDriver driver ;

    //Locators
    private By HeaderLogo = By.cssSelector("a.nav-link") ;
    private By LoggedInEmailElement = By.cssSelector("a.nav-link");
    private By LogoutButton = By.cssSelector("a.dropdown-item.clickable");
    private String LoggedInEmail ;
    private String LogoAttributeValue = "[alt=\"Autofox Logo\"]" ;


    //constructor
    public AutofoxGenericElements(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckHeaderLogo(){
         ElementActions.GetElementText(driver,HeaderLogo , "Header Logo");
    }

    public String GetLoggedInEmail(){
        LoggedInEmail =  ElementActions.GetElementText(driver,LoggedInEmailElement , "Logged in email") ;
        return LoggedInEmail ;
    }

    public void LogOut() {

        ElementActions.clickElement(driver , LoggedInEmailElement , "Logged in email button");
        ElementActions.clickElement(driver , LogoutButton , "Log Out Button");

    }

}
