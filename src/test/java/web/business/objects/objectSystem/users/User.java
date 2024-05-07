package web.business.objects.objectSystem.users;

import automation.engine.dataWorks.DataFaker;

public class User {


    public static String FirstName = DataFaker.FakeFirstName() ;
    public static String LastName = DataFaker.FakeLastName() ;
    public static String Email = DataFaker.FakeEmail() ;
    public static String Password = "123456789" ;



}

