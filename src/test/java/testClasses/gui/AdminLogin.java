package testClasses.gui;

import autofox.data.user.*;
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
                {StaticSuperAdmin.LoginToken , StaticSuperAdmin.Email},
                {StaticRetoucher.LoginToken , StaticRetoucher.Email} ,
                {StaticReviewer.LoginToken, StaticReviewer.Email},
                {StaticAuditor.LoginToken, StaticAuditor.Email},
                {StaticVehicles.LoginToken, StaticVehicles.Email},
                {StaticSales.LoginToken,StaticSales.Email },
                {StaticReportedImages.LoginToken,StaticReportedImages.Email },
                {StaticReportedIssues.LoginToken ,StaticReportedIssues.Email },
                {StaticRetoucherPerformance.LoginToken , StaticRetoucherPerformance.Email},

        };
    }

    @DataProvider(name = "InvalidAdmin")
    public static Object[][] InvalidAdminData() {
        return new String[][]{
                {Wreck(StaticSuperAdmin.LoginToken) , Wreck(StaticSuperAdmin.Email)},
                {Wreck(StaticRetoucher.LoginToken), Wreck(StaticRetoucher.Email)} ,
                {Wreck(StaticReviewer.LoginToken), Wreck(StaticReviewer.Email) },
                {Wreck(StaticAuditor.LoginToken) , Wreck(StaticAuditor.Email) },
                {Wreck(StaticVehicles.LoginToken) , Wreck(StaticVehicles.Email)},
                {Wreck(StaticSales.LoginToken) , Wreck(StaticSales.Email)},
                {Wreck(StaticReportedImages.LoginToken) , Wreck(StaticReportedImages.Email)},
                {Wreck(StaticReportedIssues.LoginToken) , Wreck(StaticReportedIssues.Email)},
                {Wreck(StaticRetoucherPerformance.LoginToken), Wreck(StaticRetoucherPerformance.Email)},
        };
    }



    @BeforeClass
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



        @AfterClass
            public void TearDown(){
                BrowserActions.Shutdown(driver);
    }


}
