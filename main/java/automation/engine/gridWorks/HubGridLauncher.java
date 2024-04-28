package automation.engine.gridWorks;

import automation.utils.loggers.EngineLogger;
import org.testng.ISuiteListener;

public class HubGridLauncher  implements ISuiteListener {



    public static void StartGrid() {

        try {
            EngineLogger.EngineInfo("--------------Starting Selenium Grid server---------");
            GridCmdCommander.HubCmdCommander();

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while starting selenium grid Hub ", E);
        }
    }






    public static void main(String[] args) {
       StartGrid();

    }

}
