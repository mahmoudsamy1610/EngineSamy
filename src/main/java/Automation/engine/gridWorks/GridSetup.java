package Automation.engine.gridWorks;

public class GridSetup {


    public static void SetupGrid(String NodePlatformType ,String NodeBrowserType ,String  ParaModule){

        GridThreadsManager.HubThread();
        GridThreadsManager.BuildNodeThread(ParaModule );
        GridThreadsManager.RegisterNodeThread(NodePlatformType , NodeBrowserType);

    }


    public static void main(String[] args) {
        //SetupGrid();
    }

}
