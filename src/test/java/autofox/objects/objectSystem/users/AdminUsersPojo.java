package autofox.objects.objectSystem.users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUsersPojo {

    //--------------------------------Json parameters---------------------------------
    @JsonProperty("status")
    public int Status;

    @JsonProperty("data")
    public  Data Data;

    @JsonProperty("errors")
    public List<AdminErrors> AdminErrors;


    //---------------------------Getters and Setters----------------------------------
    public int getStatus() {return Status;}

    @JsonProperty("status")
    public void setStatus(int Status) {this.Status = Status;}

    public  Data getData() {return Data;}

    @JsonProperty("data")
    public void setData(AdminUsersPojo.Data Data) {this.Data = Data;}

    public List<AdminErrors> getAdminErrors() {return AdminErrors;}
    @JsonProperty("errors")
    public void setAdminErrors(List<AdminErrors> adminErrors) {AdminErrors = adminErrors;}


    //------------------------------------Object subClasses---------------------------------
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {

        //------------------------------- sub class json parameters-------------------------
        @JsonProperty("id")
        public int Id;
        @JsonProperty("email")
        public String Email;
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
        @JsonProperty("language")
        public String Language;
        @JsonProperty("country_id")
        public String Country;
        @JsonProperty("is_superuser")
        public String IsSuperUser;
        @JsonProperty("is_staff")
        public String IsStaff;

        @JsonProperty("settings")
        public String UserSettings;

        @JsonProperty("admin_settings")
        public String AdminSettings;

        //-----------------------------Sub class Constructors--------------------------------
        public Data() {
        }

        public Data(String LoginToken, String Email) {
            this.Email = Email;
            this.LoginToken = LoginToken;
        }


        //----------------------------sub class getters and setters--------------------------
        @JsonProperty("id")
        public int getId() {return Id;}
        @JsonProperty("id")
        public void setId(int id) {Id = id;}


        @JsonProperty("email")
        public void setEmail(String Email) {
            this.Email = Email;
        }
        @JsonProperty("email")
        public String getEmail() {
            return Email;
        }


        @JsonProperty("username")
        public void setUserName(String UserName) {
            this.UserName = UserName;
        }
        @JsonProperty("username")
        public String getUserName() {
            return UserName;
        }


        @JsonProperty("first_name")
        public void setFirstName(String FirstName) {
            this.FirstName = FirstName;
        }
        @JsonProperty("first_name")
        public String getFirstName() {
            return FirstName;
        }


        @JsonProperty("last_name")
        public void setLastName(String LastName) {
            this.LastName = LastName;
        }
        @JsonProperty("last_name")
        public String getLastName() {
            return LastName;
        }


        @JsonProperty("company_name")
        public void setCompanyName(String CompanyName) {
            this.CompanyName = CompanyName;
        }
        @JsonProperty("company_name")
        public String getCompanyName() {
            return CompanyName;
        }


        @JsonProperty("company_address")
        public void setCompanyAddress(String CompanyAddress) {
            this.CompanyAddress = CompanyAddress;
        }
        @JsonProperty("company_address")
        public String getCompanyAddress() {
            return CompanyAddress;
        }


        @JsonProperty("is_superuser")
        public String getIsSuperUser() {return IsSuperUser;}
        @JsonProperty("is_superuser")
        public void setIsSuperUser(String isSuperUser) {IsSuperUser = isSuperUser;}


        @JsonProperty("is_staff")
        public String getIsStaff() {return IsStaff;}
        @JsonProperty("is_staff")
        public void setIsStaff(String isStaff) {IsStaff = isStaff;}


        @JsonProperty("login_token")
        public void setLoginToken(String LoginToken) {
            this.LoginToken = LoginToken;
        }
        @JsonProperty("login_token")
        public String getLoginToken() {
            return LoginToken;
        }

        @JsonProperty("language")
        public String getLanguage() {return Language;}
        @JsonProperty("language")
        public void setLanguage(String language) {Language = language;}


        @JsonProperty("country_id")
        public String getCountry() {return Country;}
        @JsonProperty("country_id")
        public void setCountry(String country) {Country = country;}

        @JsonProperty("settings")
        public String getUserSettings() {return UserSettings;}
        @JsonProperty("settings")
        public void setUserSettings(String userSettings) {UserSettings = userSettings;}

        @JsonProperty("admin_settings")
        public String getAdminSettings() {return AdminSettings;}
        @JsonProperty("admin_settings")
        public void setAdminSettings(String adminSettings) {AdminSettings = adminSettings;}

    }



    @JsonIgnoreProperties(ignoreUnknown = true)
        public static class UserSettings{
        //------------------------------- sub class json parameters-------------------------


    }

    @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdminSettings{
        //------------------------------- sub class json parameters-------------------------


    }



    @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdminErrors {

        //------------------------------- sub class json parameters-------------------------
        @JsonProperty("code")
        public int Code;

        @JsonProperty("name")
        public String ErrorName;

        @JsonProperty("description")
        public String ErrorMessage;

        //----------------------------sub class getters and setters--------------------------
         public String getErrorMessage() {
            return ErrorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            ErrorMessage = errorMessage;
        }
    }

}



