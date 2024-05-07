package web.business.data.routes;

import automation.engine.environmentWorks.EnvironmentManager;

public class Pages {

    public static String Domain = EnvironmentManager.SelectEnvironment() ;
    public static String RegisterPagePath = "/addUser" ;
    public static String LoginPagePath = EnvironmentManager.SelectEnvironment(); //will get home page ;


}
