package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersPojoChatGBT;
import automation.engine.dataWorks.DataFaker;
import static automation.utils.helpers.StringConcatenator.* ;
import static automation.utils.helpers.StringConcatenator.Concatenate;

public class SuperAdmin {
//these classes are  only Generators for users ... if you want this class to get a created user ... you need to put this class in package [Apis/gui] accordingly


     public static final String AutomationPrefix = "auto_" ;

    public static AdminUsersPojoChatGBT.UserData GenerateValidSuperAdmin(){

        String Email = Concatenate(AutomationPrefix , DataFaker.FakeEmail());
        String UserName = Concatenate(AutomationPrefix ,DataFaker.FakeUserName());
        String FirstName = Concatenate(AutomationPrefix , DataFaker.FakeFirstName());
        String LastName = Concatenate(AutomationPrefix , DataFaker.FakeLastName());
        String CompanyName = Concatenate(AutomationPrefix , DataFaker.FakeCompanyName());
        String CompanyAddress = Concatenate(AutomationPrefix , DataFaker.FakeCompanyAddress());
        String Language = "EN" ;
        String Country = "DE" ;
        boolean IsSuperUser = true ;
        //boolean IsStaff = true;

        AdminUsersPojoChatGBT.UserData superAdmin = new AdminUsersPojoChatGBT.UserData(Email,  UserName , FirstName , LastName ,CompanyName , CompanyAddress , Language  , Country ,IsSuperUser ) ;

        return superAdmin;
    }


    public static AdminUsersPojoChatGBT.UserData GenerateInvalidSuperAdmin(){
        String Email = "Invalid email testing";
        String UserName = "  ";
        String FirstName = DataFaker.FakeFirstName();
        String LastName = DataFaker.FakeLastName();
        String CompanyName = DataFaker.FakeCompanyName();
        String CompanyAddress = DataFaker.FakeCompanyAddress();
        String Language = "EN" ;
        String Country = "DE" ;
        boolean IsSuperUser = true ;
        boolean IsStaff = true;

        AdminUsersPojoChatGBT.UserData superAdmin = new AdminUsersPojoChatGBT.UserData(Email,  UserName , FirstName , LastName ,CompanyName , CompanyAddress , Language  , Country ,IsSuperUser ) ;

        return superAdmin;
    }


}
