package Autofox.objects.objectSystem.users;

public class Retoucher extends AdminUsers{



    public Retoucher() {
    }

    public Retoucher(String LoginToken) {
        super(LoginToken);
    }

    public Retoucher(String Email, String UserName) {
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


}
