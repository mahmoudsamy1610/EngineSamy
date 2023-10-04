package Autofox.objects.objectPage;

import Automation.engine.elementWorks.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminSideMenu {

        //locators
       private By DashboardTab = By.cssSelector("app-sidebar-nav-link.nav-item.ng-star-inserted");

    //variables
       WebDriver driver ;

    //driver construct
        public AdminSideMenu(WebDriver driver){this.driver = driver;}



    public void  ClickOnDashboardtab() {
         ElementActions.clickElement(driver , DashboardTab , "Dashboard Tab"); ;
    }





}
