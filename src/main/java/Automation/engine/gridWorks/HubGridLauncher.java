package Automation.engine.gridWorks;

import Automation.utils.helpers.PathConverter;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.helpers.CMDRunner;
import org.testng.Assert;
import org.testng.ISuiteListener;

public class HubGridLauncher  implements ISuiteListener {

    public static String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String HubGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridCommand") ;
    public static String HubFileRelativePath = PropertyGetter.GetPropertyValue("ParaRunData", "HubFileRelativePath") ;
    public static String HubAbsolutePath = PathConverter.ConvertPathToAbs(HubFileRelativePath ) ;
    public static String HubGridHost = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridHost") ;
    public static String RunHubGridCommand = "cd " + GridJarLocation  + " && " + HubGridCommand + " " + HubAbsolutePath  ;



    public static void StartGrid() {
        try {
            EngineLogger.EngineInfo("Running CMD command + " + RunHubGridCommand);
            EngineLogger.EngineInfo("Starting Selenium grid hub on : " + HubGridHost);

            CMDRunner.runCommand(RunHubGridCommand);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while starting selenium grid Hub ", E);
            Assert.fail("An error occurred while starting selenium grid Hub ", E);
        }
    }






    public static void main(String[] args) {
        System.out.println(RunHubGridCommand);
        StartGrid();

    }

}
