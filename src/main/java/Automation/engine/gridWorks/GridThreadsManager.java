package Automation.engine.gridWorks;

import Automation.engine.loggers.EngineLogger;
import org.testng.Assert;

public class GridThreadsManager {

    public static void HubThread(){


        try {
            EngineLogger.EngineInfo("Starting new thread for Selenium grid Hub");

            Runnable HubTask = () -> {HubGridLauncher.StartGrid();} ;
            Thread HubThread = new Thread(HubTask);
            HubThread.start();
            HubThread.sleep(10000);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while creating new thread for Selenium grid Hub " , E );
            Assert.fail("An error occurred while creating new thread for Selenium grid Hub " , E );
        }
    }


    public static void BuildNodeThread() {

        Thread BuildNodeThread;

        try {
            EngineLogger.EngineInfo("Starting new thread for Selenium grid Node");

            Runnable BuildNodeTask = () -> {
                NodeBuilder.BuildNode();
            };
            BuildNodeThread = new Thread(BuildNodeTask);
            BuildNodeThread.start();
            BuildNodeThread.sleep(5000);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while creating new thread for Selenium grid Node " , E );
            Assert.fail("An error occurred while creating new thread for Selenium grid Node " , E );
        }

    }



}

