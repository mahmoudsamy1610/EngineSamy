package Automation.engine.gridWorks;

import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.Assert;
import org.testng.IExecutionListener;

public class GridSetup implements IExecutionListener {



  @Override
    public void onExecutionStart() {

      String ExecutionType = PropertyGetter.GetPropertyValue("RunOptions", "ExecutionType");

      try {

          if (ExecutionType.equalsIgnoreCase("Local") || ExecutionType.equalsIgnoreCase("ParaLocal")) {
              EngineLogger.EngineInfo("Running on local machine , no need for selenium grid hub and nodes");
              EngineLogger.EngineInfo("Selenium Grid gub and nodes stopped");

          } else {
              SetupGrid();

          }
      }catch (Exception E){
          EngineLogger.EngineExceptionError("Failed to install Selenium grid while running  : " + ExecutionType , E );
          Assert.fail("Failed to install Selenium grid while running  : " + ExecutionType , E );
      }
    }


    public static void SetupGrid( ) {

        try {
            EngineLogger.EngineInfo("installing Selenium Grid");

            GridThreadsManager.HubThread();
            GridThreadsManager.BuildNodeThread();

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while installing Selenium grid " , E );
            Assert.fail("An error occurred while installing Selenium grid " , E);
        }

  }


    public static void main(String[] args) {
       SetupGrid();
      //  StopBlocked(thread);

    }

}
