package Autofox.pages;

import Automation.engine.ElementActions;
import Automation.engine.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
