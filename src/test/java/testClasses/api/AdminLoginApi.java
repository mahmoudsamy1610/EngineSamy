package testClasses.api;

import Autofox.objects.objectApi.LoginApiRequest;
import Autofox.objects.objectSystem.users.AdminUsers;
import Autofox.objects.objectSystem.users.SuperAdmin;
import Autofox.sharedSteps.system.user.MakeStaticRetoucher;
import Autofox.sharedSteps.system.user.MakeStaticSuperAdmin;
import Automation.engine.Assertions.CompareText;
import Automation.engine.browserWorks.BrowserActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminLoginApi {


    //Initialization
        LoginApiRequest AdminLoginApiRequest;

    @DataProvider(name = "ValidAdmin")
    public static Object[][] ValidAdminData() {
        AdminUsers[][] dataArr = new AdminUsers[][]{
                {MakeStaticSuperAdmin.GenerateValidStaticSuperAdmin()},
                {MakeStaticRetoucher.GenerateValidStaticRetoucher()}
        };
        return dataArr ;
    }

    @DataProvider(name = "InvalidAdmin")
    public static Object[][] InvalidAdminData() {
        AdminUsers[][] dataArr = new AdminUsers[][]{
                {MakeStaticSuperAdmin.GenerateInvalidStaticSuperAdmin()},
                {MakeStaticRetoucher.GenerateInvalidStaticRetoucher()}
        };
        return dataArr ;
    }




    @Test(priority = 1 , dataProvider = "ValidAdmin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that Admin can login with Valid credentials through Apis")
    public void TestAdminLogin(AdminUsers AdminUser)   {

        //Steps
        AdminLoginApiRequest.LoginApis(AdminUser);

       // CompareText.CheckText(DashboardPageTitleName,"Dashboard" , "Landing page title");

        //Expected Results : Valid Admin can log in and home page title is logout

    }




}
