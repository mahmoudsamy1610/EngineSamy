package Autofox.sharedSteps.system.user;

import Autofox.objects.objectSystem.users.SuperAdmin;
import Automation.engine.dataWorks.DataFaker;

public class MakeSuperAdmin {
//these classes are  only Generators for users ... if you want this class to get a created user ... you need to put this class in package [Apis/gui] accordingly


//Just an example constructor .. we will remove it and change it upon need
    public static SuperAdmin GenerateSuperAdmin(){
        String Email = DataFaker.FakeEmail();
        String UserName = DataFaker.FakeUserName();
        SuperAdmin superAdmin = new SuperAdmin( Email,  UserName) ;

        return superAdmin;
    }


}
