package Autofox.objects.objectSystem.users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUsersPojo {


    @JsonProperty("status")
    public int Status;

    @JsonProperty("data")
    public  Data Data;

    @JsonProperty("errors")
    public List<AdminErrors> AdminErrors;

    public int getStatus() {return Status;}

    @JsonProperty("status")
    public void setStatus(int Status) {this.Status = Status;}

    public  Data getData() {return Data;}

    @JsonProperty("data")
    public void setData(AdminUsersPojo.Data Data) {this.Data = Data;}

    public List<AdminErrors> getAdminErrors() {return AdminErrors;}
    @JsonProperty("errors")
    public void setAdminErrors(List<AdminErrors> adminErrors) {AdminErrors = adminErrors;}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {

        @JsonProperty("access_token")
        public String AccessToken;
        @JsonProperty("user")
        public AdminUsers adminUsers;

        public String getAccessToken() {
            return AccessToken;
        }

        public void setAccessToken(String accessToken) {
            this.AccessToken = accessToken;
        }

        public AdminUsers getAdminUsers() {
            return adminUsers;
        }
        @JsonProperty("user")
        public void setAdminUsers(AdminUsers adminUsers) {
            this.adminUsers = adminUsers;
        }
    }




    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AdminErrors {
        @JsonProperty("code")
        public int Code;

        @JsonProperty("name")
        public String ErrorName;

        @JsonProperty("description")
        public String ErrorMessage;

        public String getErrorMessage() {
            return ErrorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            ErrorMessage = errorMessage;
        }
    }





    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AdminUsers {

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

        public AdminUsers() {
        }

        public AdminUsers(String LoginToken , String Email) {
            this.Email = Email;
            this.LoginToken = LoginToken;
        }

        public AdminUsers(String LoginToken) {
            this.LoginToken = LoginToken;
        }


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
        public void setLoginToken(String LoginToken) {
            this.LoginToken = LoginToken;
        }

        public String getLoginToken() {
            return LoginToken;
        }


        public class Status {
            @JsonProperty("status")
            int Status;

            public int getStatus() {
                return Status;
            }

            @JsonProperty("status")
            public void setStatus(int status) {
                Status = status;
            }
        }

        public class Data {
            @JsonProperty("access_token")
            String AccessToken;

            public String getAccessToken() {
                return AccessToken;
            }

            public void setAccessToken(String accessToken) {
                AccessToken = accessToken;
            }
        }

    }
}


