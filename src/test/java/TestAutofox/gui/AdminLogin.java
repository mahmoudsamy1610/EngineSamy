package TestAutofox.gui;

import Autofox.pages.DashboardPage;
import Autofox.tools.GetAutofoxProperty;
import Automation.engine.BrowserActions;
import Automation.engine.GenerateAllureReport;
import TestAutomation.Assertions.CompareText;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import Autofox.pages.AutofoxGenericElements;
import Autofox.pages.LoginPage;


public class AdminLogin {

    //Initialization
    WebDriver driver;
    LoginPage loginPage ;
    AutofoxGenericElements autofoxGenericElements;
    DashboardPage dashboardPage ;


    @BeforeMethod
        public void setup(){

        // Start driver
        driver = BrowserActions.StartBrowser();
        BrowserActions.SetWindowSize(driver);


        //pages
        loginPage = new LoginPage(driver);
        autofoxGenericElements = new AutofoxGenericElements(driver) ;
        dashboardPage = new DashboardPage(driver);


        //Objects


    }


    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valid Admin can login")
        public void ValidAdminCanLogin()   {

        //TestCase Variables
        String AdminToken=  GetAutofoxProperty.GetAutofoxPropertyValue("AutofoxSuperAdminData","Valid_SuperAdmin_LoginToken");



        //Steps
        loginPage.openLoginPage();
        loginPage.insertLoginToken(AdminToken);
        loginPage.clickLogin();
        String DashboardPageTitleName =  dashboardPage.GetDashboardPageTitleName();
        CompareText.CheckText(DashboardPageTitleName,"Dashboard" , "Landing page title");
        autofoxGenericElements.LogOut();


        //Expected Results : Valid Admin can login and home page title is logout

    }



    @Test(priority = 2 )
    @Severity(SeverityLevel.CRITICAL)
    @Description("invalid Admin cannot login")
    public void InvalidAdminCannotLogin()   {

        //TestCase Variables
        String AdminToken=  GetAutofoxProperty.GetAutofoxPropertyValue("AutofoxSuperAdminData","Invalid_SuperAdmin_LoginToken");


        //Steps
        loginPage.openLoginPage();
        loginPage.insertLoginToken(AdminToken);
        loginPage.clickLogin();
        String InvalidCredsError =   loginPage.GetInvalidCredsErrorToaster();
        CompareText.CheckText(InvalidCredsError,"Invalid login credentials." , "Error message");

        //Expected Results : invalid Admin cannot login and Error message "invalid login credentials appears

    }



        @AfterMethod
            public void TearDown(){
                BrowserActions.Shutdown(driver);
    }


         @AfterTest
            public void CreateReport(){
                GenerateAllureReport.GenerateAllureReport();
            }
}