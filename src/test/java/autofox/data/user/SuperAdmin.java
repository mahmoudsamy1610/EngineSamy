package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;
import autofox.objects.objectSystem.users.AdminUsersPojoChatGBT;
import automation.engine.dataWorks.DataFaker;

public class SuperAdmin {
//these classes are  only Generators for users ... if you want this class to get a created user ... you need to put this class in package [Apis/gui] accordingly


//Just an example constructor .. we will remove it and change it upon need

    public static AdminUsersPojoChatGBT.UserData GenerateSuperAdmin(){
        String Email = DataFaker.FakeEmail();
        String UserName = DataFaker.FakeUserName();
        String FirstName = DataFaker.FakeFirstName();
        String LastName = DataFaker.FakeLastName();
        String CompanyName = DataFaker.FakeCompanyName();
        String CompanyAddress = DataFaker.FakeCompanyAddress();
        String Language = "EN" ;
        String Country = "DE" ;
        boolean Permission = true;

        AdminUsersPojoChatGBT.UserData superAdmin = new AdminUsersPojoChatGBT.UserData(Email,  UserName , FirstName , LastName ,CompanyName , CompanyAddress , Language  , Country ,Permission) ;

        return superAdmin;
    }


}
