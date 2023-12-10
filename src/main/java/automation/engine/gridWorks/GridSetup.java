package automation.engine.gridWorks;

import automation.engine.config.ConfigExecutionType;
import automation.utils.loggers.EngineLogger;
import org.testng.IExecutionListener;

public class GridSetup implements IExecutionListener {



  @Override
    public void onExecutionStart() {
      EngineLogger.EngineInfo("Running on local machine , no need for selenium grid hub and nodes");
      EngineLogger.EngineInfo("Selenium Grid gub and nodes stopped");

      String ExecutionType = null;

      try {
          ExecutionType = ConfigExecutionType.GetExecutionType();

          if (ExecutionType.equalsIgnoreCase("Local") || ExecutionType.equalsIgnoreCase("ParaLocal")) {


          } else {
              SetupGrid();

          }
      } catch (Exception E) {
          EngineLogger.EngineExceptionError("Failed to install Selenium grid while running  : " + ExecutionType, E);
      }
  }


    public static void SetupGrid( ) {

        try {
            EngineLogger.EngineInfo("-----------INSTALLING SELENIUM GRID------------");

            GridThreadsManager.HubThread();
            GridThreadsManager.BuildNodeThread();

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while installing Selenium grid " , E );
        }

  }


    public static void main(String[] args) {
       SetupGrid();
      //  StopBlocked(thread);

    }

}
