package Automation.engine.gridWorks;

import Automation.utils.loggers.EngineLogger;
import org.testng.Assert;

public class GridThreadsManager {

    public static void HubThread(){
        EngineLogger.EngineInfo("Starting new thread for Selenium grid Hub");


        try {
            Runnable HubTask = () -> {HubGridLauncher.StartGrid();} ;
            Thread HubThread = new Thread(HubTask);
            HubThread.start();
            HubThread.sleep(5000);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while creating new thread for Selenium grid Hub " , E );
        }
    }


    public static void BuildNodeThread() {
        EngineLogger.EngineInfo("Starting new thread for Selenium grid Node");

        Thread BuildNodeThread;

        try {
            Runnable BuildNodeTask = () -> {
                NodeBuilder.BuildNode();
            };
            BuildNodeThread = new Thread(BuildNodeTask);
            BuildNodeThread.start();
            BuildNodeThread.sleep(5000);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while creating new thread for Selenium grid Node " , E );
        }

    }



}

