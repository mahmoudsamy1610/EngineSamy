package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import automation.utils.loggers.BusinessLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static By SuccessToaster = By.cssSelector("div[role='alertdialog']");
    public static List<String> LanguageIndex = new ArrayList<>();
    public static String[] CountryIndex = new String[300] ;
    public static List<String> WorkingDaysIndex = new ArrayList<>();



    public By GetTextFieldLocator(String TextFieldId){

        By TextFieldLabel = By.id(TextFieldId);
        return TextFieldLabel;
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

    public By GetTextFieldAngularErrorLocator(String TextFieldId){
        By TextFieldLocator = GetTextFieldLocator(TextFieldId);
        return RelativeLocator.with(By.cssSelector("div.ng-star-inserted > small")).near(TextFieldLocator);
    }


    public By GetDropDownLocator(String DropDownName){

        By DropDownLabel = By.cssSelector("label[for='"+DropDownName+"']");
        return RelativeLocator.with(By.cssSelector("div.ng-select-container")).toRightOf(DropDownLabel);
          /* available labels
            language
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

        CountryIndex[216] = "CH";
        CountryIndex[84] = "DE";
        CountryIndex[77] = "FR";

        return Arrays.asList(CountryIndex).indexOf(Country);
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

    public String GetAdminDataAngularError(String TextFieldId){

        By TextFieldAngularErrorLocator = GetTextFieldAngularErrorLocator(TextFieldId);
        return ElementActions.GetElementText(driver ,TextFieldAngularErrorLocator , "Angular error validation from : "+TextFieldId) ;
    }

    public void ClickDropDown(String DropDownName){

        By DropDownLocator = GetDropDownLocator(DropDownName);
        ElementActions.ClickElement(driver , DropDownLocator , ""+DropDownName+" : dropdown item ");
    }



    public void SelectAdminLanguage(String Language){

        int LangIndex = GetLanguageIndex(Language);
        By LangItemLocator = GetLanguageItemLocator(LangIndex);
        ElementActions.ClickElement(driver , LangItemLocator , "Language dropdown item : " + Language);

    }


    public void SelectAdminCountry(String Country){

        int CountryIndex = GetCountryIndex(Country);
        By CountryItemLocator = GetCountryItemLocator(CountryIndex);
        ElementActions.ClickElement(driver , CountryItemLocator , "Country dropdown item : " + Country);

    }


    public void SelectAdminPermission(String ApiPermissionKey , boolean State){

        By PermissionToggleLocator = GetPermissionToggleLocator(ApiPermissionKey);
        if (State) {
            ElementActions.ClickElement(driver, PermissionToggleLocator, "" + ApiPermissionKey + " : permission toggle");
        }else {
            BusinessLogger.BusinessInfo("No permission will be selected for this Admin");
        }
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

    public void ClickToaster(){
        ElementActions.ClickElement(driver , SuccessToaster ,  "Success toaster message" );
    }

    public void WaitForToaster(){
        ElementActions.WaitToDisappear(driver , SuccessToaster , "Success toaster message");
    }


}
