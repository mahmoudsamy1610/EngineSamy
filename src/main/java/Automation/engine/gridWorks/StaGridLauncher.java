package Automation.engine.gridWorks;

import Automation.utils.helpers.CMDRunner;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import org.testng.Assert;

public class StaGridLauncher {



    public static void StaGridStart() {

        try {
            EngineLogger.EngineInfo("Running Stand alone selenium grid");
            GridCmdCommander.StaGridCommander();

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed starting stand alone grid", E);
        }
    }

    public static void main(String[] args) {
        StaGridStart();
    }

}



