package testClasses.gui;

import automation.engine.browserWorks.BrowserActions;
import automation.engine.browserWorks.BrowserRunner;
import automation.engine.dataWorks.DataFaker;
import business.objects.objectGui.RegisterPage;
import business.objects.objectSystem.users.User;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register {

    WebDriver driver;
    RegisterPage registerPage;


    @DataProvider(name = "ValidUser")
    public static Object[][] ValidUserData(){
        return new String[][]{
                {User.FirstName, User.LastName, User.Email, User.Password} ,
                {User.FirstName, User.LastName, User.Email, User.Password}
        } ;
    }

    @DataProvider(name = "InvalidUser")
    public static Object[][] InvalidUserData(){
        return new String[][]{
                {" ", " ", "invalidEmail_1", "1"} ,
                {" ", " ", "invalidEmail_2", "2"}
        } ;
    }


    @BeforeClass
    public void Setup(){

        // Start driver
        driver = BrowserRunner.StartBrowser();
        BrowserActions.MaxWindow(driver);

        //Objects
       registerPage = new RegisterPage(driver) ;
    }


    @Test (priority = 1 , dataProvider = "ValidUser")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that user can register with valid data")
    public void RegisterValidUser(String FirstName , String LastName , String Email , String Password){

        registerPage.OpenRegisterPage();
        registerPage.InsertFirstName(FirstName);
        registerPage.InsertLastName(LastName);
        registerPage.InsertEmail(Email);
        registerPage.InsertPassword(Password);
        registerPage.ClickSubmitRegistration();
        registerPage.OpenRegisterPage();

    }
}
