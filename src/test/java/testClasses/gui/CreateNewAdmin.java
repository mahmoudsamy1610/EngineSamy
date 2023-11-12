package testClasses.gui;

import autofox.objects.objectGui.AutofoxHeader;
import autofox.data.user.StaticSuperAdmin;
import autofox.objects.objectGui.AutofoxSideMenu;
import autofox.objects.objectGui.LoginPage;
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
    LoginPage loginPage ;
    AutofoxHeader autofoxElements;
    LoginGuiSteps loginGuiSteps;
    AutofoxSideMenu autofoxSideMenu ;

    //Static Data


    //Data Providers
    @DataProvider(name = "Valid admin data")
    public static Object[][] ValidAdminData() {
        String[][] dataArr = new String[][]{

        };
        return dataArr ;
    }

    @DataProvider(name = "Invalid admin data")
    public static Object[][] InvalidAdminData() {
        String[][] dataArr = new String[][]{
        };
        return dataArr ;
    }


    @BeforeClass
    public void setup(){

        // Start driver
        driver = BrowserRunner.StartBrowser();
        BrowserActions.MaxWindow(driver);

        //pages
        loginPage = new LoginPage(driver);
        autofoxElements = new AutofoxHeader(driver) ;
        loginGuiSteps = new LoginGuiSteps(driver);
        autofoxSideMenu = new AutofoxSideMenu(driver);

    }


    @Test(priority = 1 , dataProvider = "Valid admin data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that super admin can create new admins with valid data")
    public void TestValidAdminCreation()   {

        String SuperAdminToken = StaticSuperAdmin.LoginToken ;


        //Steps
       loginGuiSteps.UserLogin(SuperAdminToken);
       autofoxSideMenu.ClickOnAdmins();



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
