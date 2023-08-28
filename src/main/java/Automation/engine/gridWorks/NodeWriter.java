package Automation.engine.gridWorks;

import Automation.engine.helpers.TomlFileCreator;

public class NodeWriter {


    public static String CreateNodeToml(String NodePlatformType , String NodeBrowserType) {

        int Port = PortGenerator.GenerateHubPort(4);
        String NodeRelativePath = NodePathGenerator.GenerateNodeTomlPathName(NodePlatformType , NodeBrowserType , String.valueOf(Port));

        String NodeContent = "[server]\n" +
                                 "port=" + Port + "\n" +
                                    "\n"  +
                                 "[node]\n" +
                                 "[[node.driver-configuration]]\n" +
                                 "display-name =\"" +  NodeBrowserType + "\"\n" +
                                 "stereotype=\"{" + "\\\"browserName\\\": \\\""  + NodeBrowserType + "\\\"" + "," + "\\\"platformName\\\": \\\""  + NodePlatformType + "\\\"" + "}\"" ;


         TomlFileCreator.CreateToml(NodeContent , NodeRelativePath);
         System.out.println("Node Toml File created for : " + NodePlatformType + " and " + NodeBrowserType + " at Port : " + Port);

         return NodeRelativePath;
    }

    public static void main(String[] args) {

        CreateNodeToml("Windows 11" , "Firefox" );
    }


}



/*
Ex
"title = \"My TOML File\"\n" +
                                "[author]\n" +
                                "name = \"John Doe\"\n" +
                                "email = \"john@example.com\"\n";

-----------------------------------------------------
title = "My TOML File"
        [author]
        name = "John Doe"
        email = "john@example.com"
 ----------------------------------------------------------
 [server]
port = 10001
[node]
[[node.driver-configuration]]
display-name = "firefox"
stereotype = "{\"browserName\": \"firefox\", \"platformName\": \"Windows 10\" }"


 */