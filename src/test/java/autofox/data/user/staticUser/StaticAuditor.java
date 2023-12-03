package autofox.data.user.staticUser;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticAuditor {

    public static String Email ="AuditUser+6@aut.com" ;
    public static String UserName = "AuditUser+6" ;
    public static  String FirstName = "Audit" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="AuditUserCompany" ;
    public static  String CompanyAddress = "AuditUserAdress" ;
    public static  String LoginToken = "666" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticAuditor(){

        AdminUsers auditor = new AdminUsers(LoginToken , Email) ;
        return auditor;
    }

    public static AdminUsers GenerateInvalidStaticAuditor(){

        AdminUsers auditor = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return auditor;
    }


}
