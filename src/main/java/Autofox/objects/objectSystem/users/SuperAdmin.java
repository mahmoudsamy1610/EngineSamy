package Autofox.objects.objectSystem.users;

public class SuperAdmin extends AdminUsers {



    public SuperAdmin() {
    }

    public SuperAdmin(String LoginToken) {
        super(LoginToken);
    }

    public SuperAdmin(String Email, String UserName) {
        super(Email, UserName);
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
