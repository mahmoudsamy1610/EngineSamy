package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAdminPage {
    //driver constructor
    public AddAdminPage(WebDriver driver){this.driver = driver;}

    //initialization
    public WebDriver driver;
    AutofoxSideMenu autofoxSideMenu ;

    //Locators
    public static By EmailTextField = By.id("email");
    public static By UserNameTextField = By.id("username");
    public static By FirstNameTextField = By.id("first_name");
    public static By LastNameTextField = By.id("last_name");
    public static By CompanyNameTextField = By.id("company_name");
    public static By CompanyAddressTextField = By.id("company_address");




    public  void OpenAddAdminPage(){
        autofoxSideMenu = new AutofoxSideMenu(driver);
        autofoxSideMenu.ClickOnAddAdmin();
    }


    public void InsertEmail(String EmailText){
        ElementActions.ClearText(driver , EmailTextField , "Email text field" );
        ElementActions.WriteText(driver , EmailTextField , EmailText , "Email text field" );
    }

    public void InsertUserName(String UserNameText){
        ElementActions.ClearText(driver , UserNameTextField , "Email text field" );
        ElementActions.WriteText(driver , UserNameTextField , UserNameText , "Email text field" );
    }

    public void InsertFirstName(String FirstNameText){
        ElementActions.ClearText(driver , FirstNameTextField , "Email text field" );
        ElementActions.WriteText(driver , FirstNameTextField , FirstNameText , "Email text field" );
    }

    public void InsertLastName(String LastNameText){
        ElementActions.ClearText(driver , LastNameTextField , "Email text field" );
        ElementActions.WriteText(driver , LastNameTextField , LastNameText , "Email text field" );
    }

    public void InsertCompanyName(String CompanyNameText){
        ElementActions.ClearText(driver , CompanyNameTextField , "Email text field" );
        ElementActions.WriteText(driver , CompanyNameTextField , CompanyNameText , "Email text field" );
    }

    public void InsertCompanyAddress(String CompanyAddressText){
        ElementActions.ClearText(driver , CompanyAddressTextField , "Email text field" );
        ElementActions.WriteText(driver , CompanyAddressTextField , CompanyAddressText , "Email text field" );
    }

    public void ClickLanguageDropDown(){

    }

}
