package Autofox.sharedSteps.gui.user;

import Autofox.objects.objectGui.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginGuiSteps {

    WebDriver driver ;

    public LoginGuiSteps(WebDriver driver) {this.driver = driver;
    }

    public void UserLogin(String LoginToken){

        LoginPage loginPage = new LoginPage(driver) ;

        loginPage.openLoginPage();
        loginPage.insertLoginToken(LoginToken);
        loginPage.clickLogin();

    }


}
