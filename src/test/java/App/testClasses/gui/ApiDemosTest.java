package App.testClasses.gui;

import automation.engine.appDriverWorks.AppDriverStarter;
import automation.engine.appDriverWorks.AppiumServices;
import automation.engine.gridWorks.HubGridLauncher;
import automation.utils.cmdWorks.CMDRunner;
import com.github.javafaker.App;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiDemosTest {

    AndroidDriver driver ;
    ;


    @BeforeTest
    public void Setup()  {

            driver = (AndroidDriver) AppDriverStarter.StartApp();


    }



    @Test
    public void test(){
        //test

       AppiumBy app = new AppiumBy.ByAccessibilityId("App");

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(app)).getId()
        ));

        driver.findElement(app).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Loader")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Cursor")).click();

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(app)).getId()
        ));



    }

    @AfterTest
    public void TearDown(){
        //driver.quit();
       // AppiumServices.StopAppiumService();

    }




}
