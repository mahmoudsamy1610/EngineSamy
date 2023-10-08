package Autofox.data.user;

import Autofox.objects.objectSystem.users.AdminUsersPojo.AdminUsers;
import static Automation.engine.dataWorks.DataWrecker.Wreck;

public class StaticRetoucher {

    public static String Email ="mahmoudsamy.softxpert+3@gmail.com" ;
    public static String UserName = "mahmoudsmsm3" ;
    public static  String FirstName = "mahmoud3" ;
    public static  String LastName = "samy3" ;
    public static  String CompanyName ="hiroll3" ;
    public static  String CompanyAddress = "borg3" ;
    public static  String LoginToken = "2577+3" ;


    public static AdminUsers GenerateValidStaticRetoucher(){

        AdminUsers retoucher = new AdminUsers(LoginToken , Email) ;
        return retoucher;
    }

    public static AdminUsers GenerateInvalidStaticRetoucher(){

        AdminUsers retoucher = new AdminUsers(Wreck(LoginToken) , Wreck(Email)) ;
        return retoucher;
    }


}
