package Automation.engine.dataFaker;
import com.github.javafaker.Faker;


public class dataFaker {

    public static String FakeEmail(){

        String Email  ;
        Faker Faker = new Faker();
        Email = Faker.internet().emailAddress();
        return Email;
    }


    public static String FakeUserName(){

        String UserName  ;
        Faker Faker = new Faker();
        UserName = Faker.name().username();
        return UserName;
    }


    public static String FakeFirstName(){

            String FirstName  ;
            Faker Faker = new Faker();
            FirstName = Faker.name().firstName();
            return FirstName;
    }

    public static String FakeLastName(){

        String LastName  ;
        Faker Faker = new Faker();
        LastName = Faker.name().lastName();
        return LastName;
    }


    public static String FakeCompanyName(){

        String CompanyName  ;
        Faker Faker = new Faker();
        CompanyName = Faker.company().name();
        return CompanyName;
    }

    public static String FakeCompanyAddress(){

        String CompanyAddress  ;
        Faker Faker = new Faker();
        CompanyAddress = Faker.address().secondaryAddress();
        return CompanyAddress;
    }



    public static void main(String[] args) {
       System.out.println(FakeCompanyAddress());
    }

}
