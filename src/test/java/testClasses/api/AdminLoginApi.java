package testClasses.api;

import autofox.objects.objectApi.AdminUserDeserializer;
import autofox.objects.objectApi.AdminLoginApiRequest;
import autofox.data.user.StaticRetoucher;
import autofox.data.user.StaticSuperAdmin;
import automation.engine.Assertions.CompareText;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static autofox.objects.objectSystem.users.AdminUsersLoginPojo.*;

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
    public void TestAdminLogin(AdminUsers ValidAdminUser)   {

        //Steps
        Response LoginResponse = AdminLoginApiRequest.LoginApis(ValidAdminUser);
        AdminUsers AdminUserResponse = AdminUserDeserializer.DeserializeAdminUser(LoginResponse);

        CompareText.CheckText(AdminUserResponse.getEmail() , ValidAdminUser.Email , "Logged in user Email ");

        //Expected Results : Valid Admin can log in and home page title is logout

    }



    @Test(priority = 2 , dataProvider = "InvalidAdmin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that Admin cannot login with Valid credentials through Apis")
    public void InvalidAdminCannotLogin(AdminUsers InvalidAdminUser)   {

        //Steps
        Response LoginResponse = AdminLoginApiRequest.LoginApis(InvalidAdminUser);
        AdminErrors AdminUserErrorResponse = AdminUserDeserializer.DeserializeAdminErrorFetch(LoginResponse , "login");
        CompareText.CheckText(AdminUserErrorResponse.getErrorMessage() , StaticSuperAdmin.LoginCredsError , " Response error message ");

        //Expected Results : invalid Admin cannot login and Error message "invalid login credentials appears

    }






}
