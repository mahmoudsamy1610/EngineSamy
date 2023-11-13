package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import automation.engine.elementWorks.LocatorActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

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
    public static By LanguageDropDown = By.cssSelector("app-input-dropdown:nth-child(7) > div > div");
    public static By DE = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(1)");
    public static By EN = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(2)");
    public static By IT = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(3)");
    public static By FR = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(4)");
    public static By TR = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(5)");
    public static By PT = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(6)");
    public static By CountryDropDown = By.cssSelector("app-input-dropdown:nth-child(8) > div > div");
    public static By Switzerland = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(1)");
    public static By Germany = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(2)");
    public static By France = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(3)");
    public static By Luxembourg = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(4)");
    public static By Turkey = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(5)");
    public static By Other = By.cssSelector("div.ng-option.ng-star-inserted:nth-child(6)");







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
        ElementActions.ClickElement(driver , LanguageDropDown , "Language drop down" );
    }

    public void SelectAdminLanguage(String Language){

        if (Language.equalsIgnoreCase("DE")) {ElementActions.ClickElement(driver, DE, "DE Language");}
        else if (Language.equalsIgnoreCase("EN")) {ElementActions.ClickElement(driver, EN, "EN Language");}
        else if (Language.equalsIgnoreCase("IT")) {ElementActions.ClickElement(driver, IT, "IT Language");}
        else if (Language.equalsIgnoreCase("FR")) {ElementActions.ClickElement(driver, FR, "FR Language");}
        else if (Language.equalsIgnoreCase("TR")) {ElementActions.ClickElement(driver, TR, "TR Language");}
        else if (Language.equalsIgnoreCase("PT")) {ElementActions.ClickElement(driver, PT, "PT Language");}
    }

    public void ClickCountryDropDown(){
        ElementActions.ClickElement(driver , CountryDropDown , "Language drop down" );
    }

    public void SelectAdminCountry(String Country){

        if (Country.equalsIgnoreCase("CH")) {ElementActions.ClickElement(driver, Switzerland, "Switzerland Country");}
        else if (Country.equalsIgnoreCase("DE")) {ElementActions.ClickElement(driver, Germany, "Germany Country");}
        else if (Country.equalsIgnoreCase("FR")) {ElementActions.ClickElement(driver, France, "France Country");}
        else if (Country.equalsIgnoreCase("LU")) {ElementActions.ClickElement(driver, Luxembourg, "Luxembourg Country");}
        else if (Country.equalsIgnoreCase("TR")) {ElementActions.ClickElement(driver, Turkey, "Turkey Country");}
        else if (Country.equalsIgnoreCase("Other")) {ElementActions.ClickElement(driver, Other, "Other Country");}
    }


}
