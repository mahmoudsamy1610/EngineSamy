package Autofox.users;

public class SuperAdmin extends AdminUsers {



    public SuperAdmin() {
    }

    public SuperAdmin(String Email, String UserName, String LoginToken) {
        super(Email, UserName, LoginToken);
    }

    @Override
    public void setLoginToken(String loginToken) {super.setLoginToken(loginToken);}

    @Override
    public String getLoginToken() {
        return super.getLoginToken();
    }

    @Override
    public void setEmail(String Email) {super.setEmail(Email);}

    @Override
    public String getEmail() {return super.getEmail();}

}
