package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticSales {

    public static String Email ="SalesUser+8@aut.com" ;
    public static String UserName = "SalesUser+8" ;
    public static  String FirstName = "Sales" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="SalesUserCompany" ;
    public static  String CompanyAddress = "SalesUserAdress" ;
    public static  String LoginToken = "888" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticSales(){

        AdminUsers sales = new AdminUsers(LoginToken , Email) ;
        return sales;
    }

    public static AdminUsers GenerateInvalidStaticSales(){

        AdminUsers sales = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return sales;
    }


}
