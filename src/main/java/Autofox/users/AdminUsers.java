package Autofox.users;

//import Autofox.tools.GetAutofoxProperty;
import Automation.engine.propertyWorks.GetProperty;

public abstract class AdminUsers {

    private String Email;
    private String Username;
    private String FirstName;
    private String LastName;
    private String CompanyName;
    private String CompanyAddress;
    private String LoginToken;


    public AdminUsers() {
    }


    public String getEmail() {return Email;}

    public void setEmail(String EmailProperty) {

        Email = GetProperty.GetPropertyValue("AutofoxSuperAdminData","Valid_SuperAdmin_Email");
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }

    public String getLoginToken() {
        return LoginToken;
    }

    public void setLoginToken(String loginTokenProperty) {
        LoginToken = GetProperty.GetPropertyValue("AutofoxSuperAdminData","Valid_SuperAdmin_LoginToken");
    }
}

