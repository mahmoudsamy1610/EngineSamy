package Automation.engine.gridWorks;

<<<<<<< HEAD
import Automation.utils.helpers.PathConverter;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.helpers.CMDRunner;
=======
import Automation.engine.helpers.PathConverter;
import Automation.engine.helpers.StringConcatenator;
import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.helpers.CMDRunner;
>>>>>>> main
import org.testng.Assert;

public class NodeRegister {



       public static void RegisterNode(String CreatedNodePath){

           try {

               String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions", "GridJarFile");
               String NodeAbsolutePath = StringConcatenator.Concatenate("\"" , PathConverter.ConvertPathToAbs(CreatedNodePath) , "\"");
               String NodeGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "NodeRegisterCommand");
               String NodeRegisterCommand = StringConcatenator.Concatenate("cd " , GridJarLocation , " && " , NodeGridCommand , " " , NodeAbsolutePath);

               EngineLogger.EngineInfo("Running CMD command : " + NodeRegisterCommand );
               EngineLogger.EngineInfo("Registering node from : " + CreatedNodePath );

               CMDRunner.runCommand(NodeRegisterCommand);

           }catch (Exception E){
               EngineLogger.EngineExceptionError("Failed to Register node from : " + CreatedNodePath, E);
           }
       }


    public static void main(String[] args) {
        //GridSetup.SetupGrid();
        String Path =  NodeWriter.CreateNodeToml("Linux" , "firefox");
        RegisterNode(Path);

    }


}
