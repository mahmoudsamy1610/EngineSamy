package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.PropertyGetter;

public class NodePathGenerator {


    public static String GenerateNodeTomlName(String  NodePlatformType , String NodeBrowserType ){

        String NodeTomlName = NodePlatformType+NodeBrowserType+"Node";

        return NodeTomlName ;
    }


    public static String GenerateNodeTomlPathOnly(String  NodePlatformType , String NodeBrowserType){

        String NodeGeneralPath = PropertyGetter.GetPropertyValue("ParaRunData", "NodePathDir") ;
        String NodeRelativePath =  NodeGeneralPath+NodePlatformType+"\\"+NodeBrowserType ;

        return NodeRelativePath ;
    }



    public static String GenerateNodeTomlPathName(String  NodePlatformType , String NodeBrowserType , String NodeSuffix){

        String NodeRelativeDirPath =GenerateNodeTomlPathOnly(NodePlatformType ,NodeBrowserType);
       // String NodeSuffix =  NodeTomlSuffixCreator.CreateNodeSuffix(NodeRelativeDirPath);
        String NodeTomlName = GenerateNodeTomlName(NodePlatformType ,NodeBrowserType );
        String NodeRelativePath =  NodeRelativeDirPath+"\\"+NodeTomlName+"_"+NodeSuffix+".toml" ;

        return NodeRelativePath ;
    }


    public static void main(String[] args) {
        System.out.println(GenerateNodeTomlPathName("MacOs" , "Chrome" , "5050"));
    }


}
