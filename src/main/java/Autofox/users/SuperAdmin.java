package Autofox.users;

public class SuperAdmin extends AdminUsers {



    public SuperAdmin() {
    }

    @Override
    public void setLoginToken(String loginTokenProperty) {
        super.setLoginToken(loginTokenProperty);
    }

    @Override
    public String getLoginToken() {
        return super.getLoginToken();
    }


    @Override
    public void setEmail(String EmailProperty) {
        super.setEmail(EmailProperty);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

}
