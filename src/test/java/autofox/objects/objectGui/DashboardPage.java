package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import automation.engine.elementWorks.LocatorActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {


    //locators
    public static By DashboardTab = By.cssSelector("app-sidebar-nav-link.nav-item.ng-star-inserted");
    public static By DashboardPageTitle = By.cssSelector("p");

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



}
