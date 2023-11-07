package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticRetoucher {

    public static String Email ="RetouchUser+4@aut.com" ;
    public static String UserName = "RetouchUser+4" ;
    public static  String FirstName = "Retouch" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="RetouchUserCompany" ;
    public static  String CompanyAddress = "RetouchUserAdress" ;
    public static  String LoginToken = "444" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticRetoucher(){

        AdminUsers retoucher = new AdminUsers(LoginToken , Email) ;
        return retoucher;
    }

    public static AdminUsers GenerateInvalidStaticRetoucher(){

        AdminUsers retoucher = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return retoucher;
    }


}
