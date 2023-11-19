package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.ArrayList;
import java.util.List;

public class AddAdminPage {
    //driver constructor
    public AddAdminPage(WebDriver driver){this.driver = driver;}

    //initialization
    public WebDriver driver;
    AutofoxSideMenu autofoxSideMenu ;


    //Locators
    public static By Save = By.cssSelector("button[type=submit]");
    public static By Cancel = By.cssSelector("button[type=button] > i");
    public static List<String> LanguageIndex = new ArrayList<>();
    public static List<String> CountryIndex = new ArrayList<>();
    public static List<String> WorkingDaysIndex = new ArrayList<>();



    public By GetTextFieldLocator(String TextFieldId){

        By PermissionLabel = By.id(TextFieldId);
        return PermissionLabel;
        /* available Ids
        email
        username
        first_name
        last_name
        company_name
        company_address
        retouch_images_target
        review_images_target
        audit_images_target
         */
    }


    public By GetDropDownLocator(String DropDownName){

        By DropDownLabel = By.cssSelector("label[for='"+DropDownName+"']");
        return RelativeLocator.with(By.cssSelector("div.ng-value-container")).toRightOf(DropDownLabel);
          /* available labels
            Language
            country_id
            working_days
         */

    }

    public By GetPermissionToggleLocator(String ApiPermissionKey){

        By PermissionLabel = By.cssSelector("label[for='"+ApiPermissionKey+"']");
        return RelativeLocator.with(By.cssSelector("span.switch-slider")).toRightOf(PermissionLabel);
          /* available labels
        is_superuser
        is_retouch_user
        is_training_retoucher
        is_review_user
        is_audit_user
        is_view_vehicle_user
        is_sales_user
        is_reported_images_user
        is_reported_issues_user
        is_retoucher_audited_user
         */

    }

    public By GetLanguageItemLocator(int LangIndex){

        return By.cssSelector("div.ng-option.ng-star-inserted:nth-child("+LangIndex+")");
    }
    public By GetCountryItemLocator(int CountryIndex){

        return By.cssSelector("div.ng-option.ng-star-inserted:nth-child("+CountryIndex+")");
    }

    public By GetWorkingDaysItemLocator(int WorkingDayIndex){

        return By.cssSelector("div.ng-option.ng-star-inserted:nth-child("+WorkingDayIndex+")");
    }


    public int GetLanguageIndex(String Language){

        LanguageIndex.add(0,null) ;
        LanguageIndex.add(1,"DE") ;
        LanguageIndex.add(2,"EN") ;
        LanguageIndex.add(3,"IT") ;
        LanguageIndex.add(4,"FR") ;
        LanguageIndex.add(5,"TR") ;
        LanguageIndex.add(6,"PT") ;

        return LanguageIndex.indexOf(Language);
    }

    public int GetCountryIndex(String Country){

        CountryIndex.add(0,null) ;
        CountryIndex.add(1,"CH") ;
        CountryIndex.add(2,"DE") ;
        CountryIndex.add(3,"FR") ;
        CountryIndex.add(4,"LU") ;
        CountryIndex.add(5,"TR") ;
        CountryIndex.add(6,"Other") ;

        return CountryIndex.indexOf(Country);
    }

    public int GetWorkingDaysIndex(String WorkingDay){

        WorkingDaysIndex.add(0,null) ;
        WorkingDaysIndex.add(1,"Monday") ;
        WorkingDaysIndex.add(2,"Tuesday") ;
        WorkingDaysIndex.add(3,"Wednesday") ;
        WorkingDaysIndex.add(4,"Thursday") ;
        WorkingDaysIndex.add(5,"Friday") ;
        WorkingDaysIndex.add(6,"Saturday") ;
        WorkingDaysIndex.add(7,"Sunday") ;

        return WorkingDaysIndex.indexOf(WorkingDay);

    }



    public  void OpenAddAdminPage(){
        autofoxSideMenu = new AutofoxSideMenu(driver);
        autofoxSideMenu.ClickOnAddAdmin();
    }

    public void InsertAdminData(String TextFieldId, String InputText){

        By TextField = GetTextFieldLocator(TextFieldId);
        ElementActions.ClearText(driver , TextField , ""+TextField+" : text field" );
        ElementActions.WriteText(driver , TextField , InputText , ""+TextField+" : text field" );
    }

    public void ClickDropDown(String DropDownName){

        By DropDownLocator = GetDropDownLocator(DropDownName);
        ElementActions.ClickElement(driver , DropDownLocator , ""+DropDownName+" : dropdown item ");
    }



    public void SelectAdminLanguage(String Language){

        int LangIndex = GetLanguageIndex(Language);
        By LangItemLocator = GetLanguageItemLocator(LangIndex);
        ElementActions.ClickElement(driver , LangItemLocator , "Language dropdown item ");

    }


    public void SelectAdminCountry(String Country){

        int CountryIndex = GetCountryIndex(Country);
        By CountryItemLocator = GetCountryItemLocator(CountryIndex);
        ElementActions.ClickElement(driver , CountryItemLocator , "Country dropdown item ");

    }


    public void SelectAdminPermission(String ApiPermissionKey){

        By PermissionToggleLocator = GetPermissionToggleLocator(ApiPermissionKey);
        ElementActions.ClickElement(driver , PermissionToggleLocator , ""+ApiPermissionKey+" : permission toggle");
    }

    public void SelectWorkingDay(String WorkingDay){

        int WorkingDayIndex = GetWorkingDaysIndex(WorkingDay);
        By WorkingDayItemLocator = GetWorkingDaysItemLocator(WorkingDayIndex);
        ElementActions.ClickElement(driver , WorkingDayItemLocator , ""+WorkingDay+"  : dropdown item ");

    }

    public void ClickSaveAdmin(){
        ElementActions.ClickElement(driver , Save , "Save admin button");

    }

    public void ClickCancelAddingAdmin(){
        ElementActions.ClickElement(driver , Cancel , "Cancel add admin button");

    }



}
