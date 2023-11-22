package autofox.objects.objectGui;

import autofox.data.user.StaticSuperAdmin;
import autofox.sharedSteps.gui.user.LoginGuiSteps;
import automation.engine.browserWorks.BrowserActions;
import automation.engine.browserWorks.BrowserRunner;
import automation.engine.elementWorks.ElementActions;
import automation.engine.elementWorks.KeyboardActions;
import org.openqa.selenium.By;
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
       // addAdminPage.OpenAddAdminPage();
       // addAdminPage.InsertAdminData("email" , "asdas");
        //addAdminPage.InsertAdminData("username" , "asdas");
        //addAdminPage.InsertAdminData("first_name" , "asdas");
        //addAdminPage.InsertAdminData("email" , "as123231231312311das");
        //addAdminPage.ClickDropDown("language");
        //addAdminPage.SelectAdminLanguage("PT");
      //  addAdminPage.ClickDropDown("country_id");
      //  addAdminPage.SelectAdminCountry("FR");
      //  addAdminPage.SelectAdminPermission("is_review_user" , true);
      //  addAdminPage.InsertAdminData("review_images_target" , "123");
      //  addAdminPage.ClickDropDown("working_days");
      //  addAdminPage.SelectWorkingDay("Monday");
     //   addAdminPage.SelectWorkingDay("Tuesday");
     //   KeyboardActions.PressEscapeKey(driver);
      //  addAdminPage.SelectAdminPermission("is_sales_user" , true);
      //  addAdminPage.ClickSaveAdmin();

        autofoxSideMenu.ClickOnAdminList();
        System.out.println(adminListPage.GetCellText(2, "Email"));







    }

    @AfterClass
    public void TearDown(){
      //  BrowserActions.Shutdown(driver);
    }


}
