package Autofox.objects.objectSystem.users;

//import Autofox.tools.GetAutofoxProperty;
import Automation.engine.dataWorks.DataFaker;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AdminUsers {
    @JsonProperty("email")
    public String Email ;
    @JsonProperty("username")
    public String UserName;
    @JsonProperty("first_name")
    public String FirstName;
    @JsonProperty("last_name")
    public String LastName;
    @JsonProperty("company_name")
    public String CompanyName;
    @JsonProperty("company_address")
    public String CompanyAddress;
    @JsonProperty("login_token")
    public String LoginToken;


    public AdminUsers() {
    }

    public AdminUsers(String Email ,String UserName) {
        this.Email = Email ;
        this.UserName = UserName ;
    }

    public AdminUsers(String LoginToken) {
        this.LoginToken = LoginToken;
    }



    @JsonProperty("email")
    public void setEmail(String Email) {
        this.Email = Email ;
    }
    public String getEmail() {return Email;}


    @JsonProperty("username")
    public void setUserName(String UserName) { this.UserName = UserName ;}
    public String getUserName() {
        return UserName;
    }


    @JsonProperty("first_name")
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getFirstName() {
        return FirstName;
    }


    @JsonProperty("last_name")
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getLastName() {
        return LastName;
    }


    @JsonProperty("company_name")
    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }
    public String getCompanyName() {
        return CompanyName;
    }


    @JsonProperty("company_address")
    public void setCompanyAddress(String CompanyAddress) {
        this.CompanyAddress = CompanyAddress;
    }
    public String getCompanyAddress() {
        return CompanyAddress;
    }


    @JsonProperty("login_token")
    public void setLoginToken(String LoginToken) {this.LoginToken = LoginToken; }
    public String getLoginToken() {
        return LoginToken;
    }


}

