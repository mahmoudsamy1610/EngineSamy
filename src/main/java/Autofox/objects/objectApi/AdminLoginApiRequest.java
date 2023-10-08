package Autofox.objects.objectApi;

import Autofox.data.routes.RoutesUser;
import Autofox.objects.objectSystem.users.AdminUsersPojo;
import Autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import Automation.engine.apiWorks.Post;
import Automation.utils.loggers.BusinessLogger;
import com.github.javafaker.Business;
import io.restassured.response.Response;

public class AdminLoginApiRequest {



    public static Response LoginApis(Object UserObject){

        String LoginRoute = RoutesUser.LoginApis;
        Response LoginResponse = Post.PostAnonymousRequest(LoginRoute,UserObject , "Login-Mobile Request");
        return LoginResponse ;
    }


    public static void main(String[] args) {

       //SuperAdminPojo superAdmin = MakeStaticSuperAdmin.GenerateValidStaticSuperAdmin();
      //  LoginApis(superAdmin);
    }

}
