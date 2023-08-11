package Automation.engine.GridWorks;

import Automation.engine.helpers.PathConverter;
import Automation.engine.propertyWorks.GetProperty;
import Automation.engine.setupWorks.CMDRunner;
import org.testng.annotations.Parameters;

public class NodeRegister {





    @Parameters(value = {"NodePlatformType", "NodeBrowserType"})
       public static void RegisterNode(String NodePlatformType , String NodeBrowserType){

        String NodeRelativePath = NodePathGenerator.GenerateNodeTomlPath(NodePlatformType ,NodeBrowserType );

                    NodeGenerator.CreateNodeToml(NodeRelativePath , NodePlatformType , NodeBrowserType);


        String NodeTomlName = NodePathGenerator.GenerateNodeTomlName(NodePlatformType ,NodeBrowserType);
        String NodeAbsolutePath = PathConverter.ConvertPath(NodeRelativePath , NodeTomlName);
        String NodeGridCommand = GetProperty.GetPropertyValue("ParaRunOptions" , "NodeRegisterCommand") ;
        String NodeRegisterCommand = NodeGridCommand + " " + NodeAbsolutePath ;

                    CMDRunner.runCommand(NodeRegisterCommand);

    }



}
