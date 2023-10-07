package Autofox.objects.objectApi;

import Autofox.data.routes.RoutesUser;
import Automation.engine.apiWorks.Post;
import io.restassured.response.Response;

public class LoginApiRequest {

    Object UserObject ;


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
