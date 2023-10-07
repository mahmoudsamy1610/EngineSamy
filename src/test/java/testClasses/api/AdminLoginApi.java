package testClasses.api;

import Autofox.objects.objectApi.AdminUserDeserializer;
import Autofox.objects.objectApi.LoginApiRequest;
import Autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import Autofox.sharedSteps.system.user.StaticRetoucher;
import Autofox.sharedSteps.system.user.StaticSuperAdmin;
import Automation.engine.Assertions.CompareText;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminLoginApi {


    //Initialization


    @DataProvider(name = "ValidAdmin")
    public static Object[][] ValidAdminData() {
        AdminUsers[][] dataArr = new AdminUsers[][]{
                {StaticSuperAdmin.GenerateValidStaticSuperAdmin()},
                {StaticRetoucher.GenerateValidStaticRetoucher()}
        };
        return dataArr ;
    }

    @DataProvider(name = "InvalidAdmin")
    public static Object[][] InvalidAdminData() {
        AdminUsers[][] dataArr = new AdminUsers[][]{
                {StaticSuperAdmin.GenerateInvalidStaticSuperAdmin()},
                {StaticRetoucher.GenerateInvalidStaticRetoucher()}
        };
        return dataArr ;
    }




    @Test(priority = 1 , dataProvider = "ValidAdmin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that Admin can login with Valid credentials through Apis")
    public void TestAdminLogin(AdminUsers AdminUser)   {

        //Steps
        Response LoginResponse = LoginApiRequest.LoginApis(AdminUser);
        AdminUsers AdminLoginResponse = AdminUserDeserializer.DeserializeAdminUser(LoginResponse);

        CompareText.CheckText(AdminLoginResponse.getEmail() , AdminUser.Email , " Logged in user Email ");

        //Expected Results : Valid Admin can log in and home page title is logout

    }




}
