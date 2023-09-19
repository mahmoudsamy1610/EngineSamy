package Automation.engine.setupWorks;


import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;

public class EnvironmentManager {

    public static String Environment = PropertyGetter.GetPropertyValue("Environment","EnvironmentName");
    public static String  Domain;


    //Method of decide the Environment
    public static String SelectEnvironment() {
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
        }

        return Domain;

    }

    public static void main(String[] args) {
       System.out.println(SelectEnvironment());
    }

}
