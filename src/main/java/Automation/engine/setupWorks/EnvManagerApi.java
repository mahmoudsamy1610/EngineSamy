package Automation.engine.setupWorks;

import Automation.engine.config.ConfigTestEnvironment;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;

import java.io.IOException;

public class EnvManagerApi {

    public static String SelectApiEnvironment() throws IOException {

        String EnvApi = ConfigTestEnvironment.GetTestEnvironment();
        String  Domain = null;

        EngineLogger.EngineInfo("Selecting Api environment to work on : " + EnvApi);

        if (EnvApi.equalsIgnoreCase("dev")){
            try {
                Domain = PropertyGetter.GetPropertyValue("Environment","ApiDev");
            }catch (Exception E){
                EngineLogger.EngineExceptionError("Failed to work on Api  Environment : " + EnvApi, E);
            }
        }

        else if (EnvApi.equalsIgnoreCase("alpha")) {
            try{
                Domain = PropertyGetter.GetPropertyValue("Environment","ApiAlpha");
            }catch(Exception E){
                EngineLogger.EngineExceptionError("Failed to work on Api  Environment : " + EnvApi, E);
            }
        }

        else if (EnvApi.equalsIgnoreCase("live")) {
            try {
                Domain = PropertyGetter.GetPropertyValue("Environment","ApiLive");
            }catch (Exception E){
                EngineLogger.EngineExceptionError("Failed to work on Api  Environment : " + EnvApi, E);
            }


        } else {
            EngineLogger.EngineError("Invalid Api environment key provided : " + EnvApi);
            throw new IOException();
        }

        return Domain;
    }

    public static void main(String[] args) {
        try {
            System.out.println(SelectApiEnvironment());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
