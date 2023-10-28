package Automation.engine.gridWorks;

import Automation.utils.helpers.CMDRunner;
import Automation.utils.helpers.PathConverter;
import Automation.utils.helpers.StringConcatenator;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;

public class GridCmdCommander {


    public static void HubCmdCommander(){

        try {
            String GridJarLocation = PropertyGetter.GetPropertyValue("SelGridData","GridJarFile") ;
            String HubGridCommand = PropertyGetter.GetPropertyValue("SelGridData", "HubGridCommand") ;
            String HubFileRelativePath = PropertyGetter.GetPropertyValue("SelGridData", "HubFileRelativePath") ;
            String HubAbsolutePath = PathConverter.ConvertPathToAbs(HubFileRelativePath ) ;
            String HubGridHost = PropertyGetter.GetPropertyValue("SelGridData", "HubGridHost") ;
            String RunHubGridCommand = "cd " + GridJarLocation  + " && " + HubGridCommand + " " + HubAbsolutePath  ;


            EngineLogger.EngineInfo("Running Selenium Grid Hub server CMD command + " + RunHubGridCommand);
            EngineLogger.EngineInfo("launching Selenium grid hub on : " + HubGridHost);
            EngineLogger.EngineWarn("IF SELENIUM GRID WAS ALREADY RUNNING BEFORE ... PLEASE NEGLECT THE FOLLOWING INTERRUPTED EXCEPTION ERROR RELATED");

            CMDRunner.runCommand(RunHubGridCommand);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while running CMD command to start selenium grid hub server ", E);
        }
    }


    public static void NodeRegisterCommander(String CreatedNodePath){

        try {

            String GridJarLocation = PropertyGetter.GetPropertyValue("SelGridData", "GridJarFile");
            String NodeAbsolutePath = StringConcatenator.Concatenate("\"" , PathConverter.ConvertPathToAbs(CreatedNodePath) , "\"");
            String NodeGridCommand = PropertyGetter.GetPropertyValue("SelGridData", "NodeRegisterCommand");
            String NodeRegisterCommand = StringConcatenator.Concatenate("cd " , GridJarLocation , " && " , NodeGridCommand , " " , NodeAbsolutePath);

            EngineLogger.EngineInfo("Running node config registration CMD command : " + NodeRegisterCommand );

            CMDRunner.runCommand(NodeRegisterCommand);

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to run CMD command to Register node from : " + CreatedNodePath, E);
        }

    }


    public static void StaGridCommander(){

          String GridJarLocation = PropertyGetter.GetPropertyValue("SelGridData","GridJarFile") ;
          String StaGridCommand = PropertyGetter.GetPropertyValue("SelGridData", "StaGridCommand") ;
          String RunStaGridCommand = "cd " + GridJarLocation  + " && " + StaGridCommand;
          String StaGridHost = PropertyGetter.GetPropertyValue("SelGridData", "StaGridHost") ;

        try {
            EngineLogger.EngineInfo("Running Stand alone selenium grid CMD command : " + RunStaGridCommand);
            EngineLogger.EngineInfo("Starting stand alone grid on " + StaGridHost);
            EngineLogger.EngineWarn("IF SELENIUM STAND ALONE WAS ALREADY RUNNING BEFORE ... PLEASE NEGLECT THE FOLLOWING INTERRUPTED EXCEPTION ERROR RELATED");

            CMDRunner.runCommand(RunStaGridCommand);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed running CMD command to start stand alone grid", E);
        }

    }

    public static void main(String[] args) {

        String GridJarLocation = PropertyGetter.GetPropertyValue("SelGridData","GridJarFile") ;
        String StaGridCommand = PropertyGetter.GetPropertyValue("SelGridData", "StaGridCommand") ;
        String RunStaGridCommand = "cd " + GridJarLocation  + " && " + StaGridCommand;
        String StaGridHost = PropertyGetter.GetPropertyValue("SelGridData", "StaGridHost") ;

        System.out.println("RunStaGridCommand");
        CMDRunner.runCommand("java -jar src/main/resources/automationResources/executableFiles/selenium-server-4.12.0.jar standalone --selenium-manager true");


    }
}
