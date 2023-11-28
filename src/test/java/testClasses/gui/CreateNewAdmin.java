package testClasses.gui;

import autofox.data.user.Retoucher;
import autofox.data.user.SuperAdmin;
import autofox.objects.objectGui.AddAdminPage;
import autofox.objects.objectGui.AdminListPage;
import autofox.objects.objectGui.AutofoxHeader;
import autofox.data.user.StaticSuperAdmin;
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
        return new AdminUsersPojo.UserData[][]{
                {SuperAdmin.GenerateValidSuperAdmin()},
                {Retoucher.GenerateValidRetoucher()},

        };
    }

    @DataProvider(name = "Invalid admin data")
    public static Object[][] InvalidAdminData() {
        return new AdminUsersPojo.UserData[][]{
                {SuperAdmin.GenerateInvalidSuperAdmin()},
                {Retoucher.GenerateInvalidRetoucher()}
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
    @Description("Check that super admin can create new admins with valid data")
    public void TestValidAdminCreation(AdminUsersPojo.UserData ValidAdmin)   {

        //Steps
       loginGuiSteps.UserLogin(StaticSuperAdmin.LoginToken);
       autofoxSideMenu.ClickOnAdmins();
       AddAdminPage NewAddAdminPage = autofoxSideMenu.ClickOnAddAdmin();
       NewAddAdminPage.InsertAdminData("email" , ValidAdmin.email);
       NewAddAdminPage.InsertAdminData("username" , ValidAdmin.username);
       NewAddAdminPage.InsertAdminData("first_name" , ValidAdmin.firstName);
       NewAddAdminPage.InsertAdminData("last_name" , ValidAdmin.lastName);
       NewAddAdminPage.InsertAdminData("company_name" , ValidAdmin.companyName);
       NewAddAdminPage.InsertAdminData("company_address" , ValidAdmin.companyAddress);
       NewAddAdminPage.ClickDropDown("language");
       NewAddAdminPage.SelectAdminLanguage(ValidAdmin.language);
       NewAddAdminPage.ClickDropDown("country_id");
       NewAddAdminPage.SelectAdminCountry(ValidAdmin.countryId);
       NewAddAdminPage.SelectAdminPermission( ValidAdmin.adminSettings.GetStringOfAdminSettings(),  ValidAdmin.isSuperuser);
       NewAddAdminPage.ClickSaveAdmin();
       autofoxSideMenu.ClickOnAdmins();
       AdminListPage NewAdminListPage = autofoxSideMenu.ClickOnAdminList();
       String CreatedAdminEmail = NewAdminListPage.GetCellText(1 , "Email");
       //--------------------------------------Assertions-----------------------------------
       //Expected Results : super admin can create new admins with valid data
        CompareText.CheckText(CreatedAdminEmail , ValidAdmin.email, "Created admin Email");
       autofoxHeader.ClickLogOut();

    }



    @Test(priority = 1 , dataProvider = "Invalid admin data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that super admin can create new admins with valid data")
    public void TestInvalidAdminCreation(AdminUsersPojo.UserData InvalidAdmin)   {

        //Angular Error messages are hard coded, we have a bug that back end error messages not appear
        //This is why I didn't get the error message correctly from the main POJO class of admins
        String ExpectedAngularInvalidEmailError = "Invalid email address.";
        String ExpectedAngularInvalidUsernameCharCount = "Username should not be less than 3 characters.";

        //Steps
        loginGuiSteps.UserLogin(StaticSuperAdmin.LoginToken);
        autofoxSideMenu.ClickOnAdmins();
        AddAdminPage NewAddAdminPage = autofoxSideMenu.ClickOnAddAdmin();
        NewAddAdminPage.InsertAdminData("email" , InvalidAdmin.email);
        NewAddAdminPage.InsertAdminData("username" , InvalidAdmin.username);
        NewAddAdminPage.InsertAdminData("first_name" , InvalidAdmin.firstName);
        NewAddAdminPage.InsertAdminData("last_name" , InvalidAdmin.lastName);
        NewAddAdminPage.InsertAdminData("company_name" , InvalidAdmin.companyName);
        NewAddAdminPage.InsertAdminData("company_address" , InvalidAdmin.companyAddress);
        NewAddAdminPage.ClickDropDown("language");
        NewAddAdminPage.SelectAdminLanguage(InvalidAdmin.language);
        NewAddAdminPage.ClickDropDown("country_id");
        NewAddAdminPage.SelectAdminCountry(InvalidAdmin.countryId);
        NewAddAdminPage.SelectAdminPermission( "is_superuser" , InvalidAdmin.isSuperuser);
        NewAddAdminPage.ClickSaveAdmin();
        String AngularErrorOfEmail = NewAddAdminPage.GetAdminDataAngularError("email");
        String AngularErrorOfUsername = NewAddAdminPage.GetAdminDataAngularError("username");
        //--------------------------------------Assertions-----------------------------------
        //Expected Results : super admin can NOT create new admins with Invalid data
        CompareText.CheckText(AngularErrorOfEmail , ExpectedAngularInvalidEmailError, "Invalid Email angular error");
        CompareText.CheckText(AngularErrorOfUsername , ExpectedAngularInvalidUsernameCharCount, "username less than 3 char. angular error");
        autofoxHeader.ClickLogOut();

    }


    @AfterClass
    public void TearDown(){
        BrowserActions.Shutdown(driver);
    }


}
