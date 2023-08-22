package Automation.engine.gridWorks;

import Automation.engine.helpers.PathConverter;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;

public class NodeRegister {





       public static void RegisterNode(String NodePlatformType , String NodeBrowserType){

        String NodeRelativePath = NodePathGenerator.GenerateNodeTomlPath(NodePlatformType ,NodeBrowserType );

        NodeWriter.CreateNodeToml(NodeRelativePath , NodePlatformType , NodeBrowserType);


        String NodeTomlName = NodePathGenerator.GenerateNodeTomlName(NodePlatformType ,NodeBrowserType);
        String NodeAbsolutePath = PathConverter.ConvertPath(NodeRelativePath , NodeTomlName);
        String NodeGridCommand = PropertyGetter.GetPropertyValue("ParaRunOptions" , "NodeRegisterCommand") ;
        String NodeRegisterCommand = NodeGridCommand + " " + NodeAbsolutePath ;

                    CMDRunner.runCommand(NodeRegisterCommand);

    }



}
