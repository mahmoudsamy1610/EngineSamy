package App.testClasses.gui;

import automation.engine.Assertions.CompareText;
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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiDemosTest {

    AndroidDriver driver ;

    @BeforeTest
    public void Setup()  {

            driver = (AndroidDriver) AppDriverStarter.StartApp();

    }

    @Test
    public void test(){
        //test

        // the app is too simple to build page object .. building page object will have the same approach done in the web
       By Content = By.xpath("//android.widget.TextView[@content-desc=\"Content\"]" );
       By Assets = By.xpath("//android.widget.TextView[@content-desc=\"Assets\"]");
       By Read =  By.xpath("//android.widget.TextView[@content-desc=\"Read Asset\"]");
       By Text =  By.xpath("//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/text\"]");

        driver.findElement(Content).click();
        driver.findElement(Assets).click();
        driver.findElement(Read).click();
        String ReadText = driver.findElement(Text).getText();

        CompareText.CheckText(ReadText , "This text is" , "Read text result" );


    }

    @AfterTest
    public void TearDown(){
        //driver.quit();
       // AppiumServices.StopAppiumService();

    }




}
