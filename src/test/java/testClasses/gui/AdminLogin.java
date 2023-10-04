package testClasses.gui;

import Autofox.objects.objectPage.DashboardPage;
import Autofox.objects.objectSystem.users.SuperAdmin;
import Autofox.sharedSteps.gui.GetStaticRetoucher;
import Autofox.sharedSteps.gui.GetStaticSuperAdmin;
import Automation.engine.browserWorks.BrowserActions;
import Automation.engine.browserWorks.BrowserRunner;
import Automation.engine.Assertions.CompareText;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import Autofox.objects.objectPage.AutofoxGenericElements;
import Autofox.objects.objectPage.LoginPage;
import static Automation.engine.dataWorks.DataWrecker.Wreck;


//@Listeners(AllureTestNg.class)
public class AdminLogin {

    //Initialization
    WebDriver driver;
    LoginPage loginPage ;
    AutofoxGenericElements autofoxGenericElements;
    DashboardPage dashboardPage ;
    SuperAdmin superAdmin ;


    @DataProvider(name = "ValidAdmin")
    public static Object[][] ValidAdminData() {
        String[][] dataArr = new String[][]{
                {GetStaticSuperAdmin.LoginToken},
                {GetStaticRetoucher.LoginToken}
        };
        return dataArr ;
    }

    @DataProvider(name = "InvalidAdmin")
    public static Object[][] InvalidAdminData() {
        String[][] dataArr = new String[][]{

                {Wreck(GetStaticSuperAdmin.LoginToken)},
                {Wreck(GetStaticRetoucher.LoginToken)}
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
        autofoxGenericElements = new AutofoxGenericElements(driver) ;
        dashboardPage = new DashboardPage(driver);

    }

    @Test(priority = 1 , dataProvider = "ValidAdmin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that Admin can login with Valid credentials")
        public void TestAdminLogin(String AdminToken)   {

        //Steps
        loginPage.openLoginPage();
        loginPage.insertLoginToken(AdminToken);
        loginPage.clickLogin();
        String DashboardPageTitleName =  dashboardPage.GetDashboardPageTitleName();
        CompareText.CheckText(DashboardPageTitleName,"Dashboard" , "Landing page title");
        autofoxGenericElements.LogOut();


        //Expected Results : Valid Admin can log in and home page title is logout

    }


    @Test(priority = 2 , dataProvider = "InvalidAdmin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that Admin cannot login with Valid credentials")
    public void InvalidAdminCannotLogin(String AdminToken)   {

        //Steps
        loginPage.openLoginPage();
        loginPage.insertLoginToken(AdminToken);
        loginPage.clickLogin();

        String InvalidCredsError =   loginPage.GetInvalidCredsErrorToaster();
        CompareText.CheckText(InvalidCredsError,"Invalid login credentials." , "Error message");

        //Expected Results : invalid Admin cannot login and Error message "invalid login credentials appears

    }



        @AfterClass
            public void TearDown(){
                BrowserActions.Shutdown(driver);
    }


}
