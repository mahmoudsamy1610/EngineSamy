package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticReportedIssues {

    public static String Email ="ReportedIssuesUser+10@aut.com" ;
    public static String UserName = "ReportedIssuesUser+10" ;
    public static  String FirstName = "ReportedIssues" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="ReportedIssuesUserCompany" ;
    public static  String CompanyAddress = "ReportedIssuesUserAdress" ;
    public static  String LoginToken = "101010" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticReportedIIssues(){

        AdminUsers reportedIssues = new AdminUsers(LoginToken , Email) ;
        return reportedIssues;
    }

    public static AdminUsers GenerateInvalidStaticReportedIssues(){

        AdminUsers reportedIssues = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return reportedIssues;
    }


}
