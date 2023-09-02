package Automation.engine.gridWorks;

import Automation.engine.helpers.PathConverter;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;

public class NodeRegister {



       public static void RegisterNode(String CreatedNodePath){

           String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
           String NodeAbsolutePath = "\""+PathConverter.ConvertPathToAbs(CreatedNodePath)+"\"";
           String NodeGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "NodeRegisterCommand") ;
           String NodeRegisterCommand = "cd " + GridJarLocation  + " && " + NodeGridCommand + " " + NodeAbsolutePath ;

            System.out.println(NodeRegisterCommand);
            CMDRunner.runCommand(NodeRegisterCommand);

    }

    public static void main(String[] args) {

        String Path =  NodeWriter.CreateNodeToml("Linux" , "chrome");
        RegisterNode(Path);

    }


}
