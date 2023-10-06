package Autofox.sharedSteps.system.user;

import Autofox.objects.objectSystem.users.Retoucher;
import Automation.engine.dataWorks.DataWrecker;
import static Automation.engine.dataWorks.DataWrecker.Wreck;

public class MakeStaticRetoucher {

    public static String Email ="mahmoudsamy.softxpert+3@gmail.com" ;
    public static String UserName = "mahmoudsmsm3" ;
    public static  String FirstName = "mahmoud3" ;
    public static  String LastName = "samy3" ;
    public static  String CompanyName ="hiroll3" ;
    public static  String CompanyAddress = "borg3" ;
    public static  String LoginToken = "2577+31" ;


    public static Retoucher GenerateValidStaticRetoucher(){

        Retoucher retoucher = new Retoucher(LoginToken) ;
        return retoucher;
    }

    public static Retoucher GenerateInvalidStaticRetoucher(){

        Retoucher retoucher = new Retoucher(Wreck(LoginToken)) ;
        return retoucher;
    }


}
