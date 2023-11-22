package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class AutofoxSideMenu {
    //driver constructor
    public AutofoxSideMenu(WebDriver driver){this.driver = driver;}

    //initialization
    public WebDriver driver;
    AddAdminPage addAdminPage ;
    AdminListPage adminListPage ;

    //Locators
    public static By Dashboard = By.cssSelector("app-sidebar-nav-link.nav-item.ng-star-inserted");


    public static List<String> AutofoxParentMenuItems = new ArrayList<>();
    public static List<String> DealersItems = new ArrayList<>() ;
    public static List<String> VehiclesItems = new ArrayList<>() ;
    public static List<String> ThemesItems = new ArrayList<>() ;
    public static List<String> ManualRetouchItems = new ArrayList<>() ;
    public static List<String> ReportsItems = new ArrayList<>() ;
    public static List<String> AIiConversionItems = new ArrayList<>() ;
    public static List<String> AdminsItems = new ArrayList<>() ;
    public static List<String> CompaniesItems = new ArrayList<>() ;
    public static List<String> SettingsItems = new ArrayList<>() ;


    public int GetMenuParentIndex(String ParentItemName){

        AutofoxParentMenuItems.add(0,null) ;
        AutofoxParentMenuItems.add(1,null) ;
        AutofoxParentMenuItems.add(2,"Dealers") ;
        AutofoxParentMenuItems.add(3,"Vehicles") ;
        AutofoxParentMenuItems.add(4,"Themes") ;
        AutofoxParentMenuItems.add(5,"ManualRetouch") ;
        AutofoxParentMenuItems.add(6,"Reports") ;
        AutofoxParentMenuItems.add(7,"AiConversion") ;
        AutofoxParentMenuItems.add(8,"Admins") ;
        AutofoxParentMenuItems.add(9,"Companies") ;
        AutofoxParentMenuItems.add(10,"Settings") ;

       int ParentIndex = AutofoxParentMenuItems.indexOf(ParentItemName);

       return ParentIndex;
    }


    public int GetAdminsChildIndex(String AdminsChildName){

        AdminsItems.add(0,null) ;
        AdminsItems.add(1,"List") ;
        AdminsItems.add(2,"Sales") ;
        AdminsItems.add(3,"AddAdmin") ;
        AdminsItems.add(4,"RejectionHistory") ;

        int ChildIndex = AdminsItems.indexOf(AdminsChildName);

        return ChildIndex;

    }



    public By GetMenuParentLocator(int ParentIndex){

        By ParentIMenuItem = By.cssSelector("app-sidebar-nav-dropdown:nth-child("+ParentIndex+")") ;
        return ParentIMenuItem ;
    }

    public By GetMenuChildLocator(int ChildIndex){
        By ChildMenuItem = By.cssSelector("app-sidebar-nav-dropdown.nav-item.nav-dropdown.open > app-sidebar-nav-items > app-sidebar-nav-link:nth-child("+ChildIndex+")");
        return ChildMenuItem;
    }





    public void ClickOnAdmins(){

        int AdminsIndex = GetMenuParentIndex("Admins") ;
        ElementActions.ClickElement(driver , GetMenuParentLocator(AdminsIndex) , "Add admin");
    }

    public AddAdminPage ClickOnAddAdmin(){

        addAdminPage = new AddAdminPage(driver);
        int AddAdminIndex = GetAdminsChildIndex("AddAdmin");
        ElementActions.ClickElement(driver , GetMenuChildLocator(AddAdminIndex) , "Add admin");
        return addAdminPage ;
    }

    public AdminListPage ClickOnAdminList(){

        adminListPage = new AdminListPage(driver);
        int AdminListIndex = GetAdminsChildIndex("List");
        ElementActions.ClickElement(driver , GetMenuChildLocator(AdminListIndex) , "Admin list");
        return adminListPage ;
    }

}


