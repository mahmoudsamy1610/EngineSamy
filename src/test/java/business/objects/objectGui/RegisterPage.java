package business.objects.objectGui;

import automation.engine.webDriverWorks.WebBrowserActions;
import automation.engine.webElementWorks.WebElementActions;
import business.data.routes.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class RegisterPage {

    public WebDriver driver;
    public static By FirstNameField = By.id("firstName");
    public static By LastNameField = By.id("lastName");
    public static By EmailField = By.id("email");
    public static By PasswordField = By.id("password");
    public static By SubmitButton = By.id("submit");
    public static By CancelButton = By.id("cancel");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public void OpenRegisterPage(){
        WebBrowserActions.goToUrl(driver,  Pages.Domain+Pages.RegisterPagePath ,  "Register page");
    }


    public void InsertFirstName(String TextInput){
        WebElementActions.WriteText(driver , FirstNameField , TextInput , "Login First name text field");
    }

    public void InsertLastName(String TextInput){
        WebElementActions.WriteText(driver , LastNameField , TextInput , "Login Last name text field");
    }

    public void InsertEmail(String TextInput){
        WebElementActions.WriteText(driver , EmailField , TextInput , "Login Email text field");
    }

    //should return contact page
    public void InsertPassword(String TextInput){
        WebElementActions.WriteText(driver , PasswordField , TextInput , "Login Password text field");
    }

    public void ClickSubmitRegistration(){
        WebElementActions.ClickElement(driver , SubmitButton , "Login Submit button");
    }

}
