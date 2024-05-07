package App.business.objects.objectGui;

import automation.engine.webDriverWorks.WebBrowserActions;
import automation.engine.webDriverWorks.WebDriverStarter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AALocatorTester {


    //Initialization
    WebDriver driver;



    @BeforeClass
    public void setup(){

        // Start driver
        driver = WebDriverStarter.StartBrowser();
        WebBrowserActions.MaxWindow(driver);

        //pages


    }


    @Test
    public void TestLocator()   {









    }

    @AfterClass
    public void TearDown(){
      //  BrowserActions.Shutdown(driver);
    }


}
