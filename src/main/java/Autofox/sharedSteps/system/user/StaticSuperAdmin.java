package Autofox.sharedSteps.system.user;

import Autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import static Automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticSuperAdmin {

    public static String Email ="mahmoudsamy.softxpert+1@gmail.com" ;
    public static String UserName = "mahmoudsmsm1" ;
    public static  String FirstName = "mahmoud" ;
    public static  String LastName = "samy" ;
    public static  String CompanyName ="hiroll" ;
    public static  String CompanyAddress = "borg" ;
    public static  String LoginToken = "2575+1" ;

    public static AdminUsers GenerateValidStaticSuperAdmin(){

        AdminUsers superAdmin = new AdminUsers(LoginToken , Email) ;
        return superAdmin;
    }


    public static AdminUsers GenerateInvalidStaticSuperAdmin(){

        AdminUsers superAdmin = new AdminUsers(LoginToken , Email) ;
        return superAdmin;
    }

}

