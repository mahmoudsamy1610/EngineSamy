package Automation.engine.gridWorks;

import Automation.engine.helpers.StringPicker;
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



    public static String GenerateNodeTomlPathName(String  NodePlatformType , String NodeBrowserType){

        int Port = PortGenerator.GenerateHubPort(4);
        String NodeRelativeDirPath =GenerateNodeTomlPathOnly(NodePlatformType ,NodeBrowserType);
        String NodeTomlName = GenerateNodeTomlName(NodePlatformType ,NodeBrowserType );
        String NodeRelativePath =  NodeRelativeDirPath+"\\"+NodeTomlName+"_"+Port+".toml" ;

        return NodeRelativePath ;
    }

    public static int GetNodePort(String NodeRelativePath){

        String PortWithName = StringPicker.PickString(NodeRelativePath , "_.*.toml") ;
        String PortNumber = StringPicker.ExtractString(PortWithName ,1 ,5 );
        int Port = Integer.parseInt(PortNumber);
       return  Port ;
    }



    public static void main(String[] args) {
        String path =  GenerateNodeTomlPathName("MacOs" , "Chrome");
        int port = GetNodePort(path);
        System.out.println(port);
    }


}
