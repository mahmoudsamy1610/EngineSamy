package Automation.engine.setupWorks;


import Automation.engine.config.ConfigTestEnvironment;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;

import java.io.IOException;

public class EnvironmentManager {



    //Method of decide the Environment
    public static String SelectEnvironment() throws IOException {

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
            throw new IOException();
        }
        return Domain;
    }

    public static void main(String[] args) {
        try {
            System.out.println(SelectEnvironment());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
