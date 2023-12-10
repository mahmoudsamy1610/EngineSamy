package testClasses.gui;

import autofox.data.user.staticUser.*;
import automation.engine.browserWorks.BrowserActions;
import automation.engine.browserWorks.BrowserRunner;
import automation.engine.Assertions.CompareText;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import autofox.objects.objectGui.AutofoxHeader;
import autofox.objects.objectGui.LoginPage;
import static automation.engine.dataWorks.DataWrecker.Wreck;



public class AdminLogin {

    //Initialization
    WebDriver driver;
    LoginPage loginPage ;
    AutofoxHeader autofoxHeader;

    //Data Providers
    @DataProvider(name = "ValidAdmin")
    public static Object[][] ValidAdminData() {
        return new String[][]{
                {StaticMasterAdmin.LoginToken , StaticMasterAdmin.Email}


        };
    }

    @DataProvider(name = "InvalidAdmin")
    public static Object[][] InvalidAdminData() {
        return new String[][]{
                {Wreck(StaticMasterAdmin.LoginToken) , Wreck(StaticMasterAdmin.Email)}
        };
    }



    @BeforeMethod
        public void setup(){

        // Start driver
        driver = BrowserRunner.StartBrowser();
        BrowserActions.MaxWindow(driver);

        //pages
        loginPage = new LoginPage(driver);
        autofoxHeader = new AutofoxHeader(driver) ;
    }



    @Test(priority = 1 , dataProvider = "ValidAdmin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that Admin can login with Valid credentials")
        public void TestAdminLogin(String AdminToken , String AdminEmail)   {

        //Steps
        loginPage.openLoginPage();
        loginPage.insertLoginToken(AdminToken);
        loginPage.clickLogin();
        String ActualAdminEmail =  autofoxHeader.GetLoggedInEmail();
        //---------------------------------------Assertions------------------------------------
        //Expected Results : Valid Admin can log in and home page title is logout
        CompareText.CheckText(ActualAdminEmail, AdminEmail , "Logged in Admin Email");
        autofoxHeader.ClickLogOut();

    }




    @Test(priority = 2 , dataProvider = "InvalidAdmin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that Admin cannot login with invalid credentials")
    public void InvalidAdminCannotLogin(String AdminToken , String AdminEmail)   {

        //Steps
        loginPage.openLoginPage();
        loginPage.insertLoginToken(AdminToken);
        loginPage.clickLogin();
        String InvalidCredsError =   loginPage.GetInvalidCredsErrorToaster();
        //---------------------------------------Assertions------------------------------------
        //Expected Results : invalid Admin cannot login and Error message "invalid login credentials appears
        CompareText.CheckText(InvalidCredsError,"Invalid login credentials." , "Error message");


    }



        @AfterMethod
            public void TearDown(){
                BrowserActions.Shutdown(driver);
    }


}
