package automation.engine.webElementWorks;

import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WebMenuActions {

    public static List<WebElement> GetMenuItems(WebDriver Driver, By MenuLocator , String MenuElemenName , By MenuParentItem){
        EngineLogger.EngineInfo("Fetching menu all items elements [" + MenuElemenName+ "]");
        AllureStepLogger.logStep("Fetching menu all items elements [" + MenuElemenName+ "]");

        List<WebElement> MenuParentItems = new ArrayList<>();

        try {
            WebLocatorActions.locateElement(Driver, MenuLocator, MenuElemenName);
               Driver.findElements(MenuParentItem);

        }catch (Exception E){
            EngineLogger.EngineExceptionError(" Failed Fetching menu all items elements [" + MenuElemenName+ "]" ,E);
            AllureStepLogger.logStep(" Failed Fetching menu all items elements [" + MenuElemenName+ "]" );
            Assert.fail(" Failed Fetching menu all items elements [" + MenuElemenName+ "]"  , E);
        }
    return MenuParentItems;
    }


    public static WebElement PickMenuItem(List<WebElement> MenuParentItems , int ItemIndex , String ItemName){
        EngineLogger.EngineInfo("Picking one menu item [" + ItemName+ "]  , From menu" );
        AllureStepLogger.logStep("Picking one menu item [" + ItemName+ "]  , From menu" );

        try {
            WebElement MenuItem;
            MenuItem = MenuParentItems.get(ItemIndex);
            return MenuItem;
        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed picking one menu item [" + ItemName+ "]  , From menu"  ,E);
            AllureStepLogger.logStep("Failed picking one menu item [" + ItemName+ "]  , From menu" );
            Assert.fail("Failed picking one menu item [" + ItemName+ "]  , From menu"  , E);
        }
        return null ;
    }


    public static void clickMenuElement(WebElement MenuElement , String MenuElementName){
        EngineLogger.EngineInfo("Clicking on [" + MenuElementName+ "]");
        AllureStepLogger.logStep("Click on [" + MenuElementName+ "]" );

        try {
            MenuElement.click();
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed to click on :[" + MenuElementName+ "]" ,E);
            AllureStepLogger.logStep("Click on [" + MenuElementName+ "]" );
            Assert.fail(" Failed to click on :[" + MenuElementName+ "]"  , E);
        }
    }

}
