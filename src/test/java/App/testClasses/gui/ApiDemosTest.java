package App.testClasses.gui;

import automation.engine.appDriverWorks.AppDriverStarter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiDemosTest {

    AppiumDriver driver ;

    @BeforeTest
    public void Setup(){

        driver = AppDriverStarter.StartApp();

    }


    @Test
    public void test(){
        //test
        driver.findElement(new AppiumBy.ByAccessibilityId("App")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Loader")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Cursor")).click();
    }

    @AfterTest
    public void TearDown(){
        //driver.quit();
    }




}
