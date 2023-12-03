package testClasses.gui;

import autofox.data.user.dynamicUser.Retoucher;
import autofox.data.user.dynamicUser.MasterAdmin;
import autofox.data.user.dynamicUser.SuperAdmin;
import autofox.data.user.staticUser.StaticMasterAdmin;
import autofox.objects.objectGui.AddAdminPage;
import autofox.objects.objectGui.AdminListPage;
import autofox.objects.objectGui.AutofoxHeader;
import autofox.data.user.staticUser.StaticSuperAdmin;
import autofox.objects.objectGui.AutofoxSideMenu;
import autofox.objects.objectSystem.users.AdminUsersPojo;
import autofox.sharedSteps.gui.user.LoginGuiSteps;
import automation.engine.Assertions.CompareText;
import automation.engine.browserWorks.BrowserActions;
import automation.engine.browserWorks.BrowserRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewAdmin {

    //Initialization
    WebDriver driver;
    LoginGuiSteps loginGuiSteps;
    AutofoxSideMenu autofoxSideMenu ;
    AutofoxHeader autofoxHeader;

    //Static Data


    //Data Providers
    @DataProvider(name = "Valid admin data")
    public static Object[][] ValidAdminData() {
        return new Object[][]{
                {MasterAdmin.GenerateValidMasterAdmin() , MasterAdmin.AdminRole },
                {SuperAdmin.GenerateValidSuperAdmin() , SuperAdmin.AdminRole}

        };
    }

    @DataProvider(name = "Invalid admin data")
    public static Object[][] InvalidAdminData() {
        return new Object[][]{
                {MasterAdmin.GenerateInvalidMasterAdmin() , MasterAdmin.AdminRole},
                {SuperAdmin.GenerateValidSuperAdmin() , SuperAdmin.AdminRole}
        };
    }



    @DataProvider(name = "Valid designer data")
    public static Object[][] ValidDesignerData() {
        return new Object[][]{
                {Retoucher.GenerateValidRetoucher() , Retoucher.AdminRole },

        };
    }

    @DataProvider(name = "Invalid designer data")
    public static Object[][] InvalidDesignerData() {
        return new Object[][]{
                {Retoucher.GenerateInvalidRetoucher() ,Retoucher.AdminRole  }
        };
    }






    @BeforeClass
    public void setup(){

        // Start driver
        driver = BrowserRunner.StartBrowser();
        BrowserActions.MaxWindow(driver);

        //pages
        loginGuiSteps = new LoginGuiSteps(driver);
        autofoxSideMenu = new AutofoxSideMenu(driver);
        autofoxHeader = new AutofoxHeader(driver);

    }


    @Test(priority = 1 , dataProvider = "Valid admin data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that master admin can create new admins with valid data")
    public void TestValidAdminCreation(AdminUsersPojo.UserData ValidAdmin , String Settings)   {

        //Steps
       loginGuiSteps.UserLogin(StaticMasterAdmin.LoginToken);
       autofoxSideMenu.ClickOnAdmins();
       AddAdminPage NewAddAdminPage = autofoxSideMenu.ClickOnAddAdmin();
       NewAddAdminPage.InsertAdminData("email" , ValidAdmin.getEmail());
       NewAddAdminPage.InsertAdminData("username" , ValidAdmin.getUsername());
       NewAddAdminPage.InsertAdminData("first_name" , ValidAdmin.getFirstName());
       NewAddAdminPage.InsertAdminData("last_name" , ValidAdmin.getLastName());
       NewAddAdminPage.InsertAdminData("company_name" , ValidAdmin.getCompanyName());
       NewAddAdminPage.InsertAdminData("company_address" , ValidAdmin.getCompanyAddress());
       NewAddAdminPage.ClickDropDown("language");
       NewAddAdminPage.SelectAdminLanguage(ValidAdmin.getLanguage());
       NewAddAdminPage.ClickDropDown("country_id");
       NewAddAdminPage.SelectAdminCountry(ValidAdmin.getCountryId());
       NewAddAdminPage.SelectAdminPermission(Settings);
       NewAddAdminPage.ClickSaveAdmin();
       String AddAdminSuccessMessage = NewAddAdminPage.GetSuccessToasterText();
       //--------------------------------------Assertions-----------------------------------
       //Expected Results : Success message appear "Admin added successfully"
       CompareText.CheckText(AddAdminSuccessMessage , "Admin added successfully"  , "Add admin success message");


       //Steps
       NewAddAdminPage.DismissToaster();
       autofoxSideMenu.ClickOnAdmins();
       AdminListPage NewAdminListPage = autofoxSideMenu.ClickOnAdminList();
       String CreatedAdminEmail = NewAdminListPage.GetCellText(1 , "Email");
       //--------------------------------------Assertions-----------------------------------
       //Expected Results : Created admin found in admin list
       CompareText.CheckText(CreatedAdminEmail , ValidAdmin.email, "Created admin Email");
       autofoxHeader.ClickLogOut();

    }



    @Test(priority = 3 , dataProvider = "Invalid admin data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that master admin can create new admins with valid data")
    public void TestInvalidAdminCreation(AdminUsersPojo.UserData InvalidAdmin , String Settings)   {

        //Angular Error messages are hard coded, we have a bug that back end error messages not appear
        //This is why I didn't get the error message correctly from the main POJO class of admins
        String ExpectedAngularInvalidEmailError = "Invalid email address.";
        String ExpectedAngularInvalidUsernameCharCount = "Username should not be less than 3 characters.";

        //Steps
        loginGuiSteps.UserLogin(StaticMasterAdmin.LoginToken);
        autofoxSideMenu.ClickOnAdmins();
        AddAdminPage NewAddAdminPage = autofoxSideMenu.ClickOnAddAdmin();
        NewAddAdminPage.InsertAdminData("email" , InvalidAdmin.getEmail());
        NewAddAdminPage.InsertAdminData("username" , InvalidAdmin.getUsername());
        NewAddAdminPage.InsertAdminData("first_name" , InvalidAdmin.getFirstName());
        NewAddAdminPage.InsertAdminData("last_name" , InvalidAdmin.getLastName());
        NewAddAdminPage.InsertAdminData("company_name" , InvalidAdmin.getCompanyName());
        NewAddAdminPage.InsertAdminData("company_address" , InvalidAdmin.getCompanyAddress());
        NewAddAdminPage.ClickDropDown("language");
        NewAddAdminPage.SelectAdminLanguage(InvalidAdmin.getLanguage());
        NewAddAdminPage.ClickDropDown("country_id");
        NewAddAdminPage.SelectAdminCountry(InvalidAdmin.getCountryId());
        NewAddAdminPage.SelectAdminPermission(Settings);
        NewAddAdminPage.ClickSaveAdmin();
        String AngularErrorOfEmail = NewAddAdminPage.GetAdminDataAngularError("email");
        String AngularErrorOfUsername = NewAddAdminPage.GetAdminDataAngularError("username");
        //--------------------------------------Assertions-----------------------------------
        //Expected Results : master admin can NOT create new admins with Invalid data
        CompareText.CheckText(AngularErrorOfEmail , ExpectedAngularInvalidEmailError, "Invalid Email angular error");
        CompareText.CheckText(AngularErrorOfUsername , ExpectedAngularInvalidUsernameCharCount, "username less than 3 char. angular error");
        autofoxHeader.ClickLogOut();

    }




    @Test(priority = 2 , dataProvider = "Valid designer data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that master admin can create new designers  with valid data")
    public void TestValidDesignerCreation(AdminUsersPojo.UserData ValidDesigner , String Settings)   {

        //Steps
        loginGuiSteps.UserLogin(StaticMasterAdmin.LoginToken);
        autofoxSideMenu.ClickOnAdmins();
        AddAdminPage NewAddAdminPage = autofoxSideMenu.ClickOnAddAdmin();
        NewAddAdminPage.InsertAdminData("email" , ValidDesigner.getEmail());
        NewAddAdminPage.InsertAdminData("username" , ValidDesigner.getUsername());
        NewAddAdminPage.InsertAdminData("first_name" , ValidDesigner.getFirstName());
        NewAddAdminPage.InsertAdminData("last_name" , ValidDesigner.getLastName());
        NewAddAdminPage.InsertAdminData("company_name" , ValidDesigner.getCompanyName());
        NewAddAdminPage.InsertAdminData("company_address" , ValidDesigner.getCompanyAddress());
        NewAddAdminPage.ClickDropDown("language");
        NewAddAdminPage.SelectAdminLanguage(ValidDesigner.getLanguage());
        NewAddAdminPage.ClickDropDown("country_id");
        NewAddAdminPage.SelectAdminCountry(ValidDesigner.getCountryId());
        NewAddAdminPage.SelectAdminPermission(Settings);
        NewAddAdminPage.ClickSaveAdmin();
        String AddAdminSuccessMessage = NewAddAdminPage.GetSuccessToasterText();
        //--------------------------------------Assertions-----------------------------------
        //Expected Results : Success message appear "Admin added successfully"
        CompareText.CheckText(AddAdminSuccessMessage , "Admin added successfully"  , "Add admin success message");


        //Steps
        NewAddAdminPage.DismissToaster();
        autofoxSideMenu.ClickOnAdmins();
        AdminListPage NewAdminListPage = autofoxSideMenu.ClickOnAdminList();
        String CreatedAdminEmail = NewAdminListPage.GetCellText(1 , "Email");
        //--------------------------------------Assertions-----------------------------------
        //Expected Results : Created admin found in admin list
        CompareText.CheckText(CreatedAdminEmail , ValidDesigner.email, "Created admin Email");
        autofoxHeader.ClickLogOut();

    }



    @Test(priority = 4 , dataProvider = "Invalid designer data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that master admin can create new designers with valid data")
    public void TestInvalidDesignerCreation(AdminUsersPojo.UserData InvalidDesigner , String Settings)   {

        //Angular Error messages are hard coded, we have a bug that back end error messages not appear
        //This is why I didn't get the error message correctly from the main POJO class of admins
        String ExpectedAngularInvalidEmailError = "Invalid email address.";
        String ExpectedAngularInvalidUsernameCharCount = "Username should not be less than 3 characters.";

        //Steps
        loginGuiSteps.UserLogin(StaticMasterAdmin.LoginToken);
        autofoxSideMenu.ClickOnAdmins();
        AddAdminPage NewAddAdminPage = autofoxSideMenu.ClickOnAddAdmin();
        NewAddAdminPage.InsertAdminData("email" , InvalidDesigner.getEmail());
        NewAddAdminPage.InsertAdminData("username" , InvalidDesigner.getUsername());
        NewAddAdminPage.InsertAdminData("first_name" , InvalidDesigner.getFirstName());
        NewAddAdminPage.InsertAdminData("last_name" , InvalidDesigner.getLastName());
        NewAddAdminPage.InsertAdminData("company_name" , InvalidDesigner.getCompanyName());
        NewAddAdminPage.InsertAdminData("company_address" , InvalidDesigner.getCompanyAddress());
        NewAddAdminPage.ClickDropDown("language");
        NewAddAdminPage.SelectAdminLanguage(InvalidDesigner.getLanguage());
        NewAddAdminPage.ClickDropDown("country_id");
        NewAddAdminPage.SelectAdminCountry(InvalidDesigner.getCountryId());
        NewAddAdminPage.SelectAdminPermission(Settings);
        NewAddAdminPage.ClickSaveAdmin();
        String AngularErrorOfEmail = NewAddAdminPage.GetAdminDataAngularError("email");
        String AngularErrorOfUsername = NewAddAdminPage.GetAdminDataAngularError("username");
        //--------------------------------------Assertions-----------------------------------
        //Expected Results : master admin can NOT create new admins with Invalid data
        CompareText.CheckText(AngularErrorOfEmail , ExpectedAngularInvalidEmailError, "Invalid Email angular error");
        CompareText.CheckText(AngularErrorOfUsername , ExpectedAngularInvalidUsernameCharCount, "username less than 3 char. angular error");
        autofoxHeader.ClickLogOut();

    }






    @AfterClass
    public void TearDown(){
        BrowserActions.Shutdown(driver);
    }


}
