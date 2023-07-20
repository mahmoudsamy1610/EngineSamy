package Autofox.pages;

import Autofox.tools.GetAutofoxProperty;
import Automation.engine.*;
import Automation.engine.browserWorks.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    public WebDriver driver;
    //Locators
    private By TokenField = By.id("login_token");
    private By LoginButton = By.cssSelector("button.login-btn.btn-block.btn-danger");
    private By InvalidLoginCredsToaster = By.cssSelector("div[role='alertdialog']") ;

    //Variables
    //WebDriver driver ;
    private String Domain = EnvironmentManager.SelectEnvironment();
    private String LoginPageUrl =  GetAutofoxProperty.GetAutofoxPropertyValue("AutofoxUrlsStore","LoginPath");
    private String FullLoginPageUrl = Domain + LoginPageUrl;




    //driver constructor
    public LoginPage(WebDriver driver){this.driver = driver;}



    public  void openLoginPage( ){
        BrowserActions.goToUrl(driver, FullLoginPageUrl , "Login");
    }


    public void insertLoginToken(String Token)   {
        //ElementHelper.locateElement(driver, TokenField);
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

