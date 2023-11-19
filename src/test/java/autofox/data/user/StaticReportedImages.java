package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticReportedImages {

    public static String Email ="ReportedImagesUser+9@aut.com" ;
    public static String UserName = "ReportedImagesUser+9" ;
    public static  String FirstName = "ReportedImages" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="ReportedImagesUserCompany" ;
    public static  String CompanyAddress = "ReportedImagesUserAdress" ;
    public static  String LoginToken = "999" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticReportedImages(){

        AdminUsers reportedImages = new AdminUsers(LoginToken , Email) ;
        return reportedImages;
    }

    public static AdminUsers GenerateInvalidStaticReportedImages(){

        AdminUsers reportedImages = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return reportedImages;
    }


}
