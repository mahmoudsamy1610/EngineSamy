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


    public static void BuildNodeThread(String  ParaModule) {


        Thread BuildNodeThread;

        try {
            Runnable BuildNodeTask = () -> {
                NodeBuilder.BuildNode(ParaModule);
            };
            BuildNodeThread = new Thread(BuildNodeTask);
            BuildNodeThread.start();
            BuildNodeThread.sleep(10000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public static void RegisterNodeThread(String  NodePlatformType ,String  NodeBrowserType) {


        Thread RegisterNodeThread;
        try {
            Runnable RegisterNodeTask = () -> {
                NodeRegister.RegisterNode("");
            };
            RegisterNodeThread = new Thread(RegisterNodeTask);

            RegisterNodeThread.sleep(10000);
            RegisterNodeThread.start();
            RegisterNodeThread.sleep(5000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
