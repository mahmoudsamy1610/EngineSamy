package autofox.data.user.staticUser;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticRetoucherPerformance {

    public static String Email ="RetoucherPerformanceUser+11@aut.com" ;
    public static String UserName = "RetoucherPerformanceUser+11" ;
    public static  String FirstName = "RetoucherPerformance" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="RetoucherPerformanceUserCompany" ;
    public static  String CompanyAddress = "RetoucherPerformanceUserAdress" ;
    public static  String LoginToken = "111111" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticRetoucherPerformance(){

        AdminUsers retoucherPerformance = new AdminUsers(LoginToken , Email) ;
        return retoucherPerformance;
    }

    public static AdminUsers GenerateInvalidStaticRetoucherPerformance(){

        AdminUsers retoucherPerformance = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return retoucherPerformance;
    }


}
