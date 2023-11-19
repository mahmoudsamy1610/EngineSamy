package autofox.data.user;

import autofox.objects.objectSystem.users.AdminUsersLoginPojo.AdminUsers;

import static automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticVehicles {

    public static String Email ="VehiclesUser+7@aut.com" ;
    public static String UserName = "VehiclesUser+7" ;
    public static  String FirstName = "Vehicles" ;
    public static  String LastName = "User" ;
    public static  String CompanyName ="VehiclesUserCompany" ;
    public static  String CompanyAddress = "VehiclesUserAdress" ;
    public static  String LoginToken = "777" ;

    public static  String LoginCredsError = "Invalid login credentials." ;




    public static AdminUsers GenerateValidStaticVehicles(){

        AdminUsers vehicles = new AdminUsers(LoginToken , Email) ;
        return vehicles;
    }

    public static AdminUsers GenerateInvalidStaticVehicles(){

        AdminUsers vehicles = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return vehicles;
    }


}
