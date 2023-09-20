package Autofox.users;

//import Autofox.tools.GetAutofoxProperty;
import Automation.engine.dataWorks.DataFaker;

public abstract class AdminUsers {

    public String Email = DataFaker.FakeEmail();
    public String UserName;
    public String FirstName;
    public String LastName;
    public String CompanyName;
    public String CompanyAddress;
    public String LoginToken;


    public AdminUsers() {
    }

    public AdminUsers(String Email ,String UserName, String LoginToken ) {
        this.Email = Email ;
        this.UserName = UserName ;
        this.LoginToken = LoginToken;
    }

    public String getEmail() {return Email;}

    public void setEmail(String Email) {
        this.Email = Email ;
    }

    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) { this.UserName = UserName ;}
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String CompanyAddress) {
        this.CompanyAddress = CompanyAddress;
    }

    public String getLoginToken() {
        return LoginToken;
    }

    public void setLoginToken(String loginToken) {this.LoginToken = LoginToken; }


}

