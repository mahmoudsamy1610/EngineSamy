package Automation.engine.GridWorks;

import Automation.engine.helpers.PathConverter;
import Automation.engine.propertyWorks.GetProperty;
import org.testng.annotations.Parameters;

public class NodePathGenerator {


    @Parameters(value = {"NodePlatformType", "NodeBrowserType"})
    public static String GenerateNodeTomlName(String  NodePlatformType , String NodeBrowserType ){

        String NodeTomlName = NodePlatformType+NodeBrowserType+"Node.toml";

        return NodeTomlName ;
    }


    @Parameters(value = {"NodePlatformType", "NodeBrowserType"})
    public static String GenerateNodeTomlPath(String  NodePlatformType , String NodeBrowserType ){

        String NodeGeneralPath = GetProperty.GetPropertyValue("ParaRunOptions" , "NodePathDir") ;
        String NodeTomlName = GenerateNodeTomlName(NodePlatformType ,NodeBrowserType );

         String NodeRelativePath =  NodeGeneralPath+NodePlatformType+NodeBrowserType+NodeTomlName ;

        return NodeRelativePath ;
    }



}
