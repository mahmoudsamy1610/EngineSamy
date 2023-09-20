package Automation.engine.gridWorks;

import Automation.utils.helpers.PathConverter;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.helpers.CMDRunner;
import org.testng.Assert;

public class NodeRegister {



       public static void RegisterNode(String CreatedNodePath){

           try {

               String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions", "GridJarFile");
               String NodeAbsolutePath = "\"" + PathConverter.ConvertPathToAbs(CreatedNodePath) + "\"";
               String NodeGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "NodeRegisterCommand");
               String NodeRegisterCommand = "cd " + GridJarLocation + " && " + NodeGridCommand + " " + NodeAbsolutePath;

               EngineLogger.EngineInfo("Running CMD command : " + NodeRegisterCommand );
               EngineLogger.EngineInfo("Registering node from : " + CreatedNodePath );

               CMDRunner.runCommand(NodeRegisterCommand);

           }catch (Exception E){
               EngineLogger.EngineExceptionError("Failed to Register node from : " + CreatedNodePath, E);
               Assert.fail("Failed to Register node from : " + CreatedNodePath, E);
           }
       }


    public static void main(String[] args) {

        String Path =  NodeWriter.CreateNodeToml("Linasdasdux" , "chrome");
        RegisterNode(Path);

    }


}
