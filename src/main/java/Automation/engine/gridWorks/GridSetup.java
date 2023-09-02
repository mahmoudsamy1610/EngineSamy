package Automation.engine.gridWorks;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class GridSetup extends TestListenerAdapter {


    public static void SetupGrid(String  ParaModule){

        GridThreadsManager.HubThread();
        GridThreadsManager.BuildNodeThread(ParaModule);
       // GridThreadsManager.RegisterNodeThread(NodePlatformType , NodeBrowserType);

    }



    public static void main(String[] args) {
        //SetupGrid();
    }

}
