package Autofox.usersStatic;

import Autofox.autofoxPropertyWorks.GetAutofoxProperty;
import Autofox.users.AdminUsers;
import Automation.utils.propertyWorks.PropertyGetter;

public class StaticRetoucher extends AdminUsers {



    public static int Id = Integer.parseInt(GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_Id")) ;
    public static String LoginToken = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_LoginToken");
    public static String Email = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_Email");
    public static String UserName = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_UserName");
    public static String FirstName = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_FirstName");
    public static String LastName = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_LastName");
    public static String CompanyName =GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_CompanyName");
    public static String CompanyAddress = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "Retoucher_CompanyAddress");



    public static int GetId() {return Id;}
    public  static String GetLoginToken() {return LoginToken;}
    public  static String GetEmail() {return Email;}
    public  static String GetUserName() {return UserName;}
    public  static String GetFirstName() {return FirstName;}
    public  static String LastName() {return LastName;}
    public  static String GetCompanyName() {return CompanyName;}
    public  static String GetCompanyAddress() {return CompanyAddress;}



    public static Object [] GetAllStaticUserData() {

        Object[] AllData = new Object[]
                {LoginToken , Email , UserName , FirstName , LastName , CompanyName, CompanyAddress};

        return  AllData;
    }



}
