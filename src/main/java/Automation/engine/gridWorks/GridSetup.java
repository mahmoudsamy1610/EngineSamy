package Automation.engine.gridWorks;

import Automation.engine.loggers.Loggers;
import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.Assert;
import org.testng.IExecutionListener;

public class GridSetup implements IExecutionListener {



  @Override
    public void onExecutionStart() {

      String ExecutionType = PropertyGetter.GetPropertyValue("RunOptions", "ExecutionType");

      try {

          if (ExecutionType.equalsIgnoreCase("Local") || ExecutionType.equalsIgnoreCase("ParaLocal")) {
              Loggers.Info("Running on local machine , no need for selenium grid hub and nodes");
              Loggers.Info("Selenium Grid gub and nodes stopped");

          } else {
              SetupGrid();

          }
      }catch (Exception E){
          Loggers.ExceptionError("Failed to install Selenium grid while running  : " + ExecutionType , E );
          Assert.fail("Failed to install Selenium grid while running  : " + ExecutionType , E );
      }
    }


    public static void SetupGrid( ) {

        try {
            Loggers.Info("installing Selenium Grid");

            GridThreadsManager.HubThread();
            GridThreadsManager.BuildNodeThread();

        } catch (Exception E) {
            Loggers.ExceptionError("An error occurred while installing Selenium grid " , E );
            Assert.fail("An error occurred while installing Selenium grid " , E);
        }

  }


    public static void main(String[] args) {
       SetupGrid();
      //  StopBlocked(thread);

    }

}
