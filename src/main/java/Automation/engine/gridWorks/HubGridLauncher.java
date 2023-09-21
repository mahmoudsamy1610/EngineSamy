package Automation.engine.gridWorks;

import Automation.engine.helpers.PathConverter;
import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.helpers.CMDRunner;
import org.testng.Assert;
import org.testng.ISuiteListener;

public class HubGridLauncher  implements ISuiteListener {



    public static void StartGrid() {
        try {

              String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
              String HubGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridCommand") ;
              String HubFileRelativePath = PropertyGetter.GetPropertyValue("ParaRunData", "HubFileRelativePath") ;
              String HubAbsolutePath = PathConverter.ConvertPathToAbs(HubFileRelativePath ) ;
              String HubGridHost = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridHost") ;
              String RunHubGridCommand = "cd " + GridJarLocation  + " && " + HubGridCommand + " " + HubAbsolutePath  ;


            EngineLogger.EngineInfo("Running CMD command + " + RunHubGridCommand);
            EngineLogger.EngineInfo("Starting Selenium grid hub on : " + HubGridHost);
            EngineLogger.EngineWarn("IF SELENIUM GRID WAS ALREADY RUNNING BEFORE ... PLEASE NEGLECT THE EXCEPTION ERROR RELATED");

            CMDRunner.runCommand(RunHubGridCommand);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while starting selenium grid Hub ", E);
        }
    }






    public static void main(String[] args) {
        StartGrid();

    }

}
