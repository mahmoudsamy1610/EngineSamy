package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticSuperAdmin {

    public static String Email ="SuperUser+3@aut.com" ;
    public static String UserName = "SuperUser+3" ;
    public static  String FirstName = "Super" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="SuperUserCompany" ;
    public static  String CompanyAddress = "SuperUserAdress" ;
    public static  String LoginToken = "333" ;
    public static  String LoginCredsError = "Invalid login credentials." ;





    public static AdminUsers GenerateValidStaticSuperAdmin(){

        AdminUsers superAdmin = new AdminUsers(LoginToken , Email) ;
        return superAdmin;
    }


    public static AdminUsers GenerateInvalidStaticSuperAdmin(){

        AdminUsers superAdmin = new AdminUsers(Wreck(LoginToken)  ,Wreck(Email)) ;
        return superAdmin;
    }

}

