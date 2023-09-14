package Automation.engine.gridWorks;

import Automation.engine.helpers.PathConverter;
import Automation.engine.loggers.Loggers;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.helpers.CMDRunner;
import org.testng.Assert;

public class NodeRegister {



       public static void RegisterNode(String CreatedNodePath){

           try {

               String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions", "GridJarFile");
               String NodeAbsolutePath = "\"" + PathConverter.ConvertPathToAbs(CreatedNodePath) + "\"";
               String NodeGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "NodeRegisterCommand");
               String NodeRegisterCommand = "cd " + GridJarLocation + " && " + NodeGridCommand + " " + NodeAbsolutePath;

               Loggers.Info("Running CMD command : " + NodeRegisterCommand );
               Loggers.Info("Registering node from : " + CreatedNodePath );

               CMDRunner.runCommand(NodeRegisterCommand);

           }catch (Exception E){
               Loggers.ExceptionError("Failed to Register node from : " + CreatedNodePath, E);
               Assert.fail("Failed to Register node from : " + CreatedNodePath, E);
           }
       }


    public static void main(String[] args) {

        String Path =  NodeWriter.CreateNodeToml("Linasdasdux" , "chrome");
        RegisterNode(Path);

    }


}
