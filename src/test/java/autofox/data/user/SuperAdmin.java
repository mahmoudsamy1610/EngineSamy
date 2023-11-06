package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import automation.engine.dataWorks.DataFaker;

public class SuperAdmin {
//these classes are  only Generators for users ... if you want this class to get a created user ... you need to put this class in package [Apis/gui] accordingly


//Just an example constructor .. we will remove it and change it upon need
    public static AdminUsers GenerateSuperAdmin(){
        String Email = DataFaker.FakeEmail();
        String UserName = DataFaker.FakeUserName();
        AdminUsers superAdmin = new AdminUsers( Email,  UserName) ;

        return superAdmin;
    }


}
