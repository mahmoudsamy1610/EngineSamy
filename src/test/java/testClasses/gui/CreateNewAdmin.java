package testClasses.gui;

import autofox.data.user.SuperAdmin;
import autofox.objects.objectGui.AddAdminPage;
import autofox.objects.objectGui.AutofoxHeader;
import autofox.data.user.StaticSuperAdmin;
import autofox.objects.objectGui.AutofoxSideMenu;
import autofox.objects.objectSystem.users.AdminUsersPojoChatGBT;
import autofox.sharedSteps.gui.user.LoginGuiSteps;
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
    AddAdminPage addAdminPage;
    AutofoxHeader autofoxHeader;

    //Static Data


    //Data Providers
    @DataProvider(name = "Valid admin data")
    public static Object[][] ValidAdminData() {
        AdminUsersPojoChatGBT.UserData[][] ValidAdmins = new AdminUsersPojoChatGBT.UserData[][]{
                {SuperAdmin.GenerateValidSuperAdmin()},
                {SuperAdmin.GenerateValidSuperAdmin()}
        };
        return ValidAdmins ;
    }

    @DataProvider(name = "Invalid admin data")
    public static Object[][] InvalidAdminData() {
        AdminUsersPojoChatGBT.UserData[][] InvalidAdmins = new AdminUsersPojoChatGBT.UserData[][]{
                {SuperAdmin.GenerateInvalidSuperAdmin()},
                {SuperAdmin.GenerateInvalidSuperAdmin()}
        };
        return InvalidAdmins ;
    }


    @BeforeClass
    public void setup(){

        // Start driver
        driver = BrowserRunner.StartBrowser();
        BrowserActions.MaxWindow(driver);

        //pages
        loginGuiSteps = new LoginGuiSteps(driver);
        autofoxSideMenu = new AutofoxSideMenu(driver);
        addAdminPage = new AddAdminPage(driver);
        autofoxHeader = new AutofoxHeader(driver);

    }


    @Test(priority = 1 , dataProvider = "Valid admin data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that super admin can create new admins with valid data")
    public void TestValidAdminCreation(AdminUsersPojoChatGBT.UserData ValidAdmin)   {

        //Steps
       loginGuiSteps.UserLogin(StaticSuperAdmin.LoginToken);
       autofoxSideMenu.ClickOnAdmins();
       autofoxSideMenu.ClickOnAddAdmin();
       addAdminPage.InsertAdminData("email" , ValidAdmin.email);
       addAdminPage.InsertAdminData("username" , ValidAdmin.username);
       addAdminPage.InsertAdminData("first_name" , ValidAdmin.firstName);
       addAdminPage.InsertAdminData("last_name" , ValidAdmin.lastName);
       addAdminPage.InsertAdminData("company_name" , ValidAdmin.companyName);
       addAdminPage.InsertAdminData("company_address" , ValidAdmin.companyAddress);
       addAdminPage.ClickDropDown("language");
       addAdminPage.SelectAdminLanguage(ValidAdmin.language);
       addAdminPage.ClickDropDown("country_id");
       addAdminPage.SelectAdminCountry(ValidAdmin.countryId);
       addAdminPage.SelectAdminPermission( "is_superuser" , ValidAdmin.isSuperuser);
       addAdminPage.ClickSaveAdmin();
       addAdminPage.ClickToaster();
       addAdminPage.WaitForToaster();
       autofoxHeader.ClickLogOut();





        //Expected Results : super admin can create new admins with valid data

    }



    @Test(priority = 1 , dataProvider = "Invalid admin data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that super admin can create new admins with valid data")
    public void TestInvalidAdminCreation()   {

        String SuperAdminToken = StaticSuperAdmin.LoginToken ;


        //Steps
        loginGuiSteps.UserLogin(SuperAdminToken);
        autofoxSideMenu.ClickOnAdmins();


        //Expected Results : super admin can create new admins with valid data

    }


    @AfterClass
    public void TearDown(){
        BrowserActions.Shutdown(driver);
    }


}
