package Automation.engine.gridWorks;

import Automation.utils.helpers.PathConverter;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.helpers.CMDRunner;
import org.testng.Assert;
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
