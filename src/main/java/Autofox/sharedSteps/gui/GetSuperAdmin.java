package Autofox.sharedSteps.gui;

import Autofox.objects.objectSystem.users.SuperAdmin;
import Automation.engine.dataWorks.DataFaker;

public class GetSuperAdmin {

//Just an example constructor .. we will remove it and change it upon need
    public static SuperAdmin GenerateSuperAdmin(){

        String Email = DataFaker.FakeEmail();
        String UserName = DataFaker.FakeUserName();
        SuperAdmin superAdmin = new SuperAdmin( Email,  UserName) ;

        return superAdmin;
    }


}
