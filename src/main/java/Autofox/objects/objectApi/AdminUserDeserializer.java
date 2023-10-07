package Autofox.objects.objectApi;

import Autofox.objects.objectSystem.users.AdminUsersPojo;
import Autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import Autofox.sharedSteps.system.user.StaticSuperAdmin;
import io.restassured.response.Response;

import java.io.IOException;

public class AdminUserDeserializer{


    public static AdminUsers DeserializeAdminUser(Response AdminResponse)  {


        AdminUsersPojo adminUserPojo = AdminResponse.body().as(AdminUsersPojo.class);
        AdminUsers adminUser = adminUserPojo.getData().getAdminUsers();

        return adminUser ;
    }





    public static void main(String[] args) throws IOException {
        AdminUsers admin = StaticSuperAdmin.GenerateValidStaticSuperAdmin();
        Response response = LoginApiRequest.LoginApis(admin);
        AdminUsers admin1 =  DeserializeAdminUser(response);
      System.out.println(admin1.getEmail());
    }

}
