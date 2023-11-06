package automation.engine.dataWorks;
import automation.utils.loggers.EngineLogger;
import com.github.javafaker.Faker;


public class DataFaker {

    public static String FakeEmail(){

        String Email  ;
        Faker Faker = new Faker();
        Email = Faker.internet().emailAddress();

        if (Email != null){
            EngineLogger.EngineInfo("Faking new Email : " + Email);
        }else {
            EngineLogger.EngineError("Failed faking new Email");
            throw new NullPointerException();
        }

        return Email;
    }


    public static String FakeUserName(){

        String UserName  ;
        Faker Faker = new Faker();
        UserName = Faker.name().username();

        if (UserName != null){
            EngineLogger.EngineInfo("Faking new UserName : " + UserName);
        }else {
            EngineLogger.EngineError("Failed faking new UserName");
            throw new NullPointerException();
        }
        return UserName;
    }


    public static String FakeFirstName(){

        String FirstName  ;
        Faker Faker = new Faker();
        FirstName = Faker.name().firstName();

        if (FirstName != null){
            EngineLogger.EngineInfo("Faking new FirstName : " + FirstName);
        }else {
            EngineLogger.EngineError("Failed faking new FirstName");
            throw new NullPointerException();
        }

        return FirstName;
    }

    public static String FakeLastName(){

        String LastName  ;
        Faker Faker = new Faker();
        LastName = Faker.name().lastName();

        if (LastName != null){
            EngineLogger.EngineInfo("Faking new LastName : " + LastName);
        }else {
            EngineLogger.EngineError("Failed faking new LastName");
            throw new NullPointerException();
        }

        return LastName;
    }


    public static String FakeCompanyName(){

        String CompanyName  ;
        Faker Faker = new Faker();
        CompanyName = Faker.company().name();

        if (CompanyName != null){
            EngineLogger.EngineInfo("Faking new CompanyName : " + CompanyName);
        }else {
            EngineLogger.EngineError("Failed faking new CompanyName");
            throw new NullPointerException();
        }

        return CompanyName;
    }

    public static String FakeCompanyAddress(){

        String CompanyAddress  ;
        Faker Faker = new Faker();
        CompanyAddress = Faker.address().secondaryAddress();

        if (CompanyAddress != null){
            EngineLogger.EngineInfo("Faking new CompanyAddress : " + CompanyAddress);
        }else {
            EngineLogger.EngineError("Failed faking new CompanyAddress");
            throw new NullPointerException();
        }

        return CompanyAddress;
    }



    public static void main(String[] args) {
        System.out.println(FakeCompanyAddress());
    }

}