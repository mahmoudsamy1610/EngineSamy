package autofox.objects.objectGui;

import autofox.data.user.staticUser.StaticSuperAdmin;
import autofox.sharedSteps.gui.user.LoginGuiSteps;
import automation.engine.browserWorks.BrowserActions;
import automation.engine.browserWorks.BrowserRunner;
import automation.engine.elementWorks.KeyboardActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AALocatorTester {


    //Initialization
    WebDriver driver;
    LoginPage loginPage ;
    AutofoxHeader autofoxElements;
    LoginGuiSteps loginGuiSteps;
    AutofoxSideMenu autofoxSideMenu ;
    AddAdminPage addAdminPage ;
    AdminListPage adminListPage ;


    @BeforeClass
    public void setup(){

        // Start driver
        driver = BrowserRunner.StartBrowser();
        BrowserActions.MaxWindow(driver);

        //pages
        loginPage = new LoginPage(driver);
        autofoxElements = new AutofoxHeader(driver) ;
        loginGuiSteps = new LoginGuiSteps(driver);
        autofoxSideMenu = new AutofoxSideMenu(driver);
        addAdminPage = new AddAdminPage(driver);
        adminListPage = new AdminListPage(driver);
    }


    @Test
    public void TestLocator()   {


        String SuperAdminToken = StaticSuperAdmin.LoginToken ;
        loginGuiSteps.UserLogin(SuperAdminToken);
        autofoxSideMenu.ClickOnAdmins();
        AddAdminPage NewAddAdminPage =  autofoxSideMenu.ClickOnAddAdmin();
        NewAddAdminPage.InsertAdminData("email" , "123");
        KeyboardActions.PressTabKey(driver);
        String AngularErrorOfEmail = NewAddAdminPage.GetAdminDataAngularError("email");
        System.out.println(AngularErrorOfEmail);







    }

    @AfterClass
    public void TearDown(){
      //  BrowserActions.Shutdown(driver);
    }


}
