package autofox.objects.objectApi;

import autofox.data.routes.RoutesUser;
import automation.engine.apiWorks.Post;
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
