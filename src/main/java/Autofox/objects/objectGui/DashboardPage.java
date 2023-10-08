package Autofox.objects.objectGui;

import Automation.engine.elementWorks.ElementActions;
import Automation.engine.elementWorks.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {


    //locators
    private By DashboardTab = By.cssSelector("app-sidebar-nav-link.nav-item.ng-star-inserted");
    private By DashboardPageTitle = By.cssSelector("p");

    //Variables
        WebDriver driver ;

    //Constructor

    public DashboardPage (WebDriver driver){this.driver = driver;}


    public String GetDashboardName() {

        //  return ElementHelper.locateElement(driver, DashboardTab,"Dashboard").getAccessibleName();
        return ElementActions.GetElementText(driver ,  DashboardTab , "Dashboard") ;
    }

    public String GetDashboardPageTitleName() {

        return ElementActions.GetElementText(driver ,  DashboardPageTitle , "Dashboard page title") ;

    }

    public WebElement GetDashboardPageTitle() {

        WebElement DashboardPageTitleName = ElementHelper.locateElement(driver, DashboardPageTitle, "Dashboard page title name");

        return DashboardPageTitleName ;
    }

}
