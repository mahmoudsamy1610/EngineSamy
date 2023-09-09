package Automation.engine.gridWorks;

import org.testng.IExecutionListener;

public class GridSetup implements IExecutionListener {



  @Override
    public void onExecutionStart(){
        SetupGrid();
    }


    public static void SetupGrid( ) {

        try {
                GridThreadsManager.HubThread();
                GridThreadsManager.BuildNodeThread();


        } catch (Exception e) {e.getMessage();
        }

  }


    public static void main(String[] args) {
       SetupGrid();
      //  StopBlocked(thread);

    }

}
