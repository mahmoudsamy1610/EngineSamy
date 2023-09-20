package Autofox.usersStatic;

import Autofox.autofoxPropertyWorks.GetAutofoxProperty;
import Autofox.users.AdminUsers;
import Automation.utils.propertyWorks.PropertyGetter;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.DataProvider;

public class StaticSuperAdmin extends AdminUsers {


    public static int Id = Integer.parseInt(GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_Id")) ;
    public static String LoginToken = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_LoginToken");
    public static String Email = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_Email");
    public static String UserName = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_UserName");
    public static String FirstName = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_FirstName");
    public static String LastName = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_LastName");
    public static String CompanyName =GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_CompanyName");
    public static String CompanyAddress = GetAutofoxProperty.GetAutofoxPropertyValue("StaticAdminData" , "SuperAdmin_CompanyAddress");


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
