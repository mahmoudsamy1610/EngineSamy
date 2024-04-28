package business.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {


   public WebDriver driver;
   public static By EmailField = By.id("email");
   public static By PasswordField = By.id("password");
   public static By SubmitButton = By.id("submit");

   public LoginPage(WebDriver driver) {
      this.driver = driver;
   }

   public void InsertEmail(String TextInput){
      ElementActions.WriteText(driver , EmailField , TextInput , "Login Email text field");
   }

   //should return contact page
   public void InsertPassword(String TextInput){
      ElementActions.WriteText(driver , PasswordField , TextInput , "Login Password text field");
   }

   public void ClickSubmitRegistration(){
      ElementActions.ClickElement(driver , SubmitButton , "login Submit button");
   }

}
