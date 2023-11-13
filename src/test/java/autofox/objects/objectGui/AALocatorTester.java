package autofox.objects.objectGui;

import autofox.data.user.StaticSuperAdmin;
import autofox.sharedSteps.gui.user.LoginGuiSteps;
import automation.engine.browserWorks.BrowserActions;
import automation.engine.browserWorks.BrowserRunner;
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
    }


    @Test
    public void TestLocator()   {


        String SuperAdminToken = StaticSuperAdmin.LoginToken ;
        loginGuiSteps.UserLogin(SuperAdminToken);
        autofoxSideMenu.ClickOnAdmins();
        addAdminPage.OpenAddAdminPage();
        addAdminPage.ClickLanguageDropDown();
        addAdminPage.SelectAdminLanguage("PT");
        addAdminPage.ClickCountryDropDown();
        addAdminPage.SelectAdminCountry("LU");




    }

    @AfterClass
    public void TearDown(){
      //  BrowserActions.Shutdown(driver);
    }


}
