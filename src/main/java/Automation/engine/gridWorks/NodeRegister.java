package Automation.engine.gridWorks;

import Automation.utils.helpers.PathConverter;
import Automation.utils.helpers.StringConcatenator;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.helpers.CMDRunner;
import org.checkerframework.checker.units.qual.C;


public class NodeRegister {



       public static void RegisterNode(String CreatedNodePath){

           try {
               EngineLogger.EngineInfo("Registering node from : " + CreatedNodePath);
               GridCmdCommander.NodeRegisterCommander(CreatedNodePath);

           }catch (Exception E){
               EngineLogger.EngineExceptionError("Failed to Register node from : " + CreatedNodePath, E);
           }
       }


    public static void main(String[] args) {
        //GridSetup.SetupGrid();
     //   String Path =  NodeWriter.CreateNodeToml("Linux" , "firefox");
        RegisterNode("D:\\Automation\\Autofox\\src\\main\\resources\\automationResources\\tomlFiles\\gridHubNodes\\windows 11\\chrome\\Windows 11chromeNode_2241.toml");

    }


}
