package autofox.data.user.dynamicUser;

import autofox.objects.objectSystem.users.AdminUsersPojo;
import automation.engine.dataWorks.DataFaker;
import automation.utils.varWorks.RandomDigitsGenerator;

import static automation.utils.varWorks.StringConcatenator.Concatenate;

public class Vehicles {
//these classes are  only Generators for users ... if you want this class to get a created user ... you need to put this class in package [Apis/gui] accordingly


     public static final String AutomationPrefix = "auto_" ;
     public static final String AdminRole = "is_view_vehicle_user" ;

    public static AdminUsersPojo.UserData GenerateValidVehicleAdmin(){

        String Email = Concatenate(AutomationPrefix , DataFaker.FakeEmail());
        String UserName = Concatenate(AutomationPrefix ,DataFaker.FakeUserName());
        String FirstName = Concatenate(AutomationPrefix , DataFaker.FakeFirstName());
        String LastName = Concatenate(AutomationPrefix , DataFaker.FakeLastName());
        String CompanyName = Concatenate(AutomationPrefix , DataFaker.FakeCompanyName());
        String CompanyAddress = Concatenate(AutomationPrefix , DataFaker.FakeCompanyAddress());
        String Language = "EN" ;
        String Country = "DE" ;


        return new AdminUsersPojo.UserData(Email,  UserName , FirstName , LastName ,CompanyName , CompanyAddress , Language  , Country);
    }


    public static AdminUsersPojo.UserData GenerateInvalidVehicleAdmin(){
        String Email = "Invalid email testing";
        String UserName = String.valueOf(RandomDigitsGenerator.GenerateRandomNumber(2)) ;
        String FirstName = DataFaker.FakeFirstName();
        String LastName = DataFaker.FakeLastName();
        String CompanyName = DataFaker.FakeCompanyName();
        String CompanyAddress = DataFaker.FakeCompanyAddress();
        String Language = "EN" ;
        String Country = "DE" ;

        return new AdminUsersPojo.UserData(Email,  UserName , FirstName , LastName ,CompanyName , CompanyAddress , Language  , Country);
    }




}
