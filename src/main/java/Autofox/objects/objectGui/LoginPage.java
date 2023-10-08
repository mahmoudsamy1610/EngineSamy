package Autofox.objects.objectGui;

import Autofox.autofoxPropertyWorks.GetAutofoxProperty;
import Automation.engine.browserWorks.BrowserActions;
import Automation.engine.elementWorks.ElementActions;
import Automation.engine.setupWorks.EnvironmentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    public WebDriver driver;
    //Locators
    private By TokenField = By.id("login_token");
    private By LoginButton = By.cssSelector("button.login-btn.btn-block.btn-danger");
    private By InvalidLoginCredsToaster = By.cssSelector("div[role='alertdialog']") ;


    //driver constructor
    public LoginPage(WebDriver driver){this.driver = driver;}



    public  void openLoginPage( ) {

        String Domain = EnvironmentManager.SelectEnvironment();
        String LoginPageUrl = GetAutofoxProperty.GetAutofoxPropertyValue("AutofoxUrlsStore", "LoginPath");
        String FullLoginPageUrl = Domain + LoginPageUrl;

            BrowserActions.goToUrl(driver, FullLoginPageUrl, "Login");
    }


    public void insertLoginToken(String Token)   {
        ElementActions.writeText(driver,TokenField,Token, "Login Token Field" );
    }


    public void clickLogin(){
        ElementActions.clickElement(driver,LoginButton, "Login Button");
    }

    public String GetInvalidCredsErrorToaster(){
      String  InvalidCredsError =  ElementActions.GetElementText(driver, InvalidLoginCredsToaster , "Invalid Creds Error Toaster Messages");
         return InvalidCredsError;
    }

}

