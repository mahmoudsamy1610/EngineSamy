package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.IExecutionListener;

public class GridSetup implements IExecutionListener {



  @Override
    public void onExecutionStart() {

      String ExecutionType = PropertyGetter.GetPropertyValue("RunOptions", "ExecutionType");

      if (ExecutionType.equalsIgnoreCase("Local") || ExecutionType.equalsIgnoreCase("ParaLocal")){
                System.out.println("Test is running Locally --> Selenium Grid Stopped");
      }
      else {
          SetupGrid();
             }
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
