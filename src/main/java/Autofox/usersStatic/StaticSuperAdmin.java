package Autofox.usersStatic;

import Autofox.users.AdminUsers;

public class StaticSuperAdmin extends AdminUsers {


    public static int Id = 2575 ;
    public static String LoginToken = "2575+1" ;
    public static String Email = "mahmoudsamy.softxpert+1@gmail.com" ;
    public static String UserName = "mahmoudsmsm1" ;
    public static String FirstName = " mahmoud" ;
    public static String LastName = " samy" ;
    public static String CompanyName = "hiroll" ;
    public static String CompanyAddress = "borg" ;



    public static int GetId() {return Id;}
    public  static String GetLoginToken() {return LoginToken;}
    public  static String GetEmail() {return Email;}
    public  static String GetUserName() {return UserName;}
    public  static String GetFirstName() {return FirstName;}
    public  static String LastName() {return LastName;}
    public  static String GetCompanyName() {return CompanyName;}
    public  static String GetCompanyAddress() {return CompanyAddress;}

}
