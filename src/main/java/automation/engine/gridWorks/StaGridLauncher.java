package automation.engine.gridWorks;

import automation.utils.loggers.EngineLogger;

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



