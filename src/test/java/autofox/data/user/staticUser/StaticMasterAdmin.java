package autofox.data.user.staticUser;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticMasterAdmin {

    public static String Email ="MasterUser+15@aut.com" ;
    public static String UserName = "MasterUser+15" ;
    public static  String FirstName = "Master" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="MasterUserCompany" ;
    public static  String CompanyAddress = "MasterUserAddress" ;
    public static  String LoginToken = "151515" ;
    public static  String LoginCredsError = "Invalid login credentials." ;





    public static AdminUsers GenerateValidStaticMasterAdmin(){

        AdminUsers superAdmin = new AdminUsers(LoginToken , Email) ;
        return superAdmin;
    }


    public static AdminUsers GenerateInvalidStaticMasterAdmin(){

        AdminUsers superAdmin = new AdminUsers(Wreck(LoginToken)  ,Wreck(Email)) ;
        return superAdmin;
    }

}

