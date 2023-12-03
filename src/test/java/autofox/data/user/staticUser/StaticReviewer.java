package autofox.data.user.staticUser;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticReviewer {

    public static String Email ="ReviewUser+5@aut.com" ;
    public static String UserName = "ReviewUser+5" ;
    public static  String FirstName = "Review" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="ReviewUserCompany" ;
    public static  String CompanyAddress = "ReviewUserAdress" ;
    public static  String LoginToken = "555" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticReviewer(){

        AdminUsers reviewer = new AdminUsers(LoginToken , Email) ;
        return reviewer;
    }

    public static AdminUsers GenerateInvalidStaticReviewer(){

        AdminUsers reviewer = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return reviewer;
    }


}
