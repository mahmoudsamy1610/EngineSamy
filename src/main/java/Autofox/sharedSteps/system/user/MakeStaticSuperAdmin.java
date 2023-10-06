package Autofox.sharedSteps.system.user;

import Autofox.objects.objectSystem.users.Retoucher;
import Autofox.objects.objectSystem.users.SuperAdmin;

import static Automation.engine.dataWorks.DataWrecker.Wreck;

public class MakeStaticSuperAdmin {

    public static String Email ="mahmoudsamy.softxpert+1@gmail.com" ;
    public static String UserName = "mahmoudsmsm1" ;
    public static  String FirstName = "mahmoud" ;
    public static  String LastName = "samy" ;
    public static  String CompanyName ="hiroll" ;
    public static  String CompanyAddress = "borg" ;
    public static  String LoginToken = "2575+1" ;

    public static SuperAdmin GenerateValidStaticSuperAdmin(){

        SuperAdmin superAdmin = new SuperAdmin(LoginToken) ;
        return superAdmin;
    }

    public static Retoucher GenerateInvalidStaticSuperAdmin(){

        Retoucher retoucher = new Retoucher(Wreck(LoginToken)) ;
        return retoucher;
    }

}

