package Autofox.users;

public class SuperAdmin extends AdminUsers {



    public SuperAdmin() {
    }

    public SuperAdmin(String Email, String UserName, String LoginToken) {
        super(Email, UserName, LoginToken);
    }

    @Override
    public void setLoginToken(String LoginToken) {super.setLoginToken(LoginToken);}

    @Override
    public String getLoginToken() {
        return super.getLoginToken();
    }

    @Override
    public void setEmail(String Email) {
        super.setEmail(Email);
    }

    @Override
    public String getEmail() {return super.getEmail();}


    public static void main(String[] args) {
          SuperAdmin Super = new SuperAdmin();
          System.out.println(Super.getEmail());
    }
}
