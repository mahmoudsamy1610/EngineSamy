package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.GetProperty;
import org.testng.annotations.Parameters;

public class NodePathGenerator {


    public static String GenerateNodeTomlName(String  NodePlatformType , String NodeBrowserType ){

        String NodeTomlName = NodePlatformType+NodeBrowserType+"Node.toml";

        return NodeTomlName ;
    }


    public static String GenerateNodeTomlPath(String  NodePlatformType , String NodeBrowserType ){

        String NodeGeneralPath = GetProperty.GetPropertyValue("ParaRunOptions" , "NodePathDir") ;
        String NodeTomlName = GenerateNodeTomlName(NodePlatformType ,NodeBrowserType );

         String NodeRelativePath =  NodeGeneralPath+NodePlatformType+NodeBrowserType+NodeTomlName ;

        return NodeRelativePath ;
    }



}
