package Automation.engine.gridWorks;

import Automation.engine.helpers.CMDRunner;
import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.Assert;

public class StaGridLauncher {

    public static String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String StaGridCommand = PropertyGetter.GetPropertyValue("RunOptions", "StaGridCommand") ;
    public static String RunStaGridCommand = "cd " + GridJarLocation  + " && " + StaGridCommand;
    public static String StaGridHost = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost") ;

    public static void StaGridStart() {
        try {
            EngineLogger.EngineInfo("Running CMD command : " + RunStaGridCommand);
            EngineLogger.EngineInfo("Starting stand alone grid on " + StaGridHost);

            CMDRunner.runCommand(RunStaGridCommand);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed starting stand alone grid", E);
            Assert.fail("Failed starting stand alone grid", E);
        }
    }

    public static void main(String[] args) {
        StaGridStart();
    }

}


