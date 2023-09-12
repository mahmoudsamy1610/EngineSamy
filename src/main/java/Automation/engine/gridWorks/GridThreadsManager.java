package Automation.engine.gridWorks;

public class GridThreadsManager {

    public static void HubThread(){


        try {
            Runnable HubTask = () -> {HubGridLauncher.StartGrid();} ;
            Thread HubThread = new Thread(HubTask);
            HubThread.start();
            HubThread.sleep(10000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    public static void BuildNodeThread() {

        Thread BuildNodeThread;

        try {
            Runnable BuildNodeTask = () -> {
                NodeBuilder.BuildNode();
            };
            BuildNodeThread = new Thread(BuildNodeTask);
            BuildNodeThread.start();
            BuildNodeThread.sleep(5000);



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}

