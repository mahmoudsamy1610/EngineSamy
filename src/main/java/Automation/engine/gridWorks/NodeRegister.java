package Automation.engine.gridWorks;

import Automation.engine.helpers.PathConverter;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;

public class NodeRegister {



       public static void RegisterNode(String NodePlatformType , String NodeBrowserType){

           String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
           String NodeRelativePath = NodeWriter.CreateNodeToml(NodePlatformType , NodeBrowserType);
           String NodeAbsolutePath = "\""+PathConverter.ConvertPathToAbs(NodeRelativePath)+"\"";
           String NodeGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "NodeRegisterCommand") ;
           String NodeRegisterCommand = "cd " + GridJarLocation  + " && " + NodeGridCommand + " " + NodeAbsolutePath ;

            System.out.println(NodeRegisterCommand);
            CMDRunner.runCommand(NodeRegisterCommand);

    }

    public static void main(String[] args) {

        RegisterNode("windows 11" , "MicrosoftEdge");

    }


}
