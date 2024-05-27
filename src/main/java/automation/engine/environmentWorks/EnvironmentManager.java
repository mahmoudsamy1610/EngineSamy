package automation.engine.environmentWorks;


import automation.engine.config.ConfigTestEnvironment;
import automation.utils.loggers.EngineLogger;
import automation.utils.propertyWorks.PropertyGetter;

public class EnvironmentManager {



    //Method of decide the Environment
    public static String SelectEnvironment() {

          String Environment = ConfigTestEnvironment.GetTestEnvironment();
          String  Domain = null;

        EngineLogger.EngineInfo("Selecting environment to work on : " + Environment);

        if (Environment.equalsIgnoreCase("dev")){
            try {
                Domain = PropertyGetter.GetPropertyValue("Environment","HomeDev");
            }catch (Exception E){
                EngineLogger.EngineExceptionError("Failed to work on Environment : " + Environment , E);
            }
        }

        else if (Environment.equalsIgnoreCase("alpha")) {
            try{
                 Domain = PropertyGetter.GetPropertyValue("Environment","HomeAlpha");
              }catch(Exception E){
                EngineLogger.EngineExceptionError("Failed to work on Environment : " + Environment , E);
            }
        }

        else if (Environment.equalsIgnoreCase("live")) {
            try {
                Domain = PropertyGetter.GetPropertyValue("Environment","HomeLive");
            }catch (Exception E){
                EngineLogger.EngineExceptionError("Failed to work on Environment : " + Environment , E);
            }


        } else {
            EngineLogger.EngineError("Invalid environment key provided : " +Environment);
            throw new NullPointerException();
        }
        return Domain;
    }

    public static void main(String[] args) {
        try {
            System.out.println(SelectEnvironment());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
