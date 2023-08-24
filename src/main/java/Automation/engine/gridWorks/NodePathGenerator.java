package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.PropertyGetter;

import java.net.CacheRequest;

public class NodePathGenerator {


    public static String GenerateNodeTomlName(String  NodePlatformType , String NodeBrowserType ){

        String NodeTomlName = NodePlatformType+NodeBrowserType+"Node.toml";

        return NodeTomlName ;
    }


    public static String GenerateNodeTomlPath(String  NodePlatformType , String NodeBrowserType ){

        String NodeGeneralPath = PropertyGetter.GetPropertyValue("ParaRunData", "NodePathDir") ;
        String NodeTomlName = GenerateNodeTomlName(NodePlatformType ,NodeBrowserType );

         String NodeRelativePath =  NodeGeneralPath+NodePlatformType+"\\"+NodeBrowserType+"\\"+NodeTomlName ;

        return NodeRelativePath ;
    }


    public static void main(String[] args) {
        System.out.println(GenerateNodeTomlPath("MacOs" , "Chrome"));
    }


}
