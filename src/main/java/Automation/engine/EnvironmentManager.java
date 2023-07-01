package Automation.engine;


public class EnvironmentManager {

    public static String Environment = GetProperty.GetPropertyValue("Environment","EnvironmentName");
    public static String  Domain;


    //Method of decide the Environment
    public static String SelectEnvironment() {

        if (Environment.equalsIgnoreCase("dev")){
            try {
                Domain =GetProperty.GetPropertyValue("Environment","HomeDev");
            }catch (Exception e){e.getMessage();
                System.out.println("DEV Environment is not inserted correctly ");}
        }

        else if (Environment.equalsIgnoreCase("alpha")) {
              try{
                 Domain = GetProperty.GetPropertyValue("Environment","HomeAlpha");
              }catch(Exception e){e.getMessage();
                  System.out.println("Alpha Environment is not inserted correctly ");}
        }

        else if (Environment.equalsIgnoreCase("live")) {
            try {
                Domain = GetProperty.GetPropertyValue("Environment","HomeLive");
            }catch (Exception e){e.getMessage();
                System.out.println("Live Environment is not inserted correctly ");}


        } else {System.out.println("Invalid Environment Url");}

        return Domain;

    }



}
