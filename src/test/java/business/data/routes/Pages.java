package business.data.routes;

import automation.engine.setupWorks.EnvironmentManager;

public class Pages {

    public static String Domain = EnvironmentManager.SelectEnvironment() ;
    public static String RegisterPagePath = "/addUser" ;
    public static String LoginPagePath = EnvironmentManager.SelectEnvironment(); //will get home page ;


}
