package Automation.engine.gridWorks;

import Automation.engine.helpers.TomlFileCreator;
import Automation.engine.loggers.Loggers;
import org.testng.Assert;

public class NodeWriter {


    public static String CreateNodeToml(String NodePlatformType , String NodeBrowserType) {

        String NodeRelativePath = NodePathGenerator.GenerateNodeTomlFullPath(NodePlatformType , NodeBrowserType);
        int Port = NodePathGenerator.GetNodePort(NodeRelativePath);


        String NodeContent = "[server]\n" +
                                 "port=" + Port + "\n" +
                                    "\n"  +
                                 "[node]\n" +
                                 "[[node.driver-configuration]]\n" +
                                 "display-name =\"" +  NodeBrowserType + "\"\n" +
                                 "stereotype=\"{" + "\\\"browserName\\\": \\\""  + NodeBrowserType + "\\\"" + "," + "\\\"platformName\\\": \\\""  + NodePlatformType + "\\\"" + "}\"" ;

            try {
                Loggers.Info("Writing node TOML content for : " +NodePlatformType + " & " + NodeBrowserType );
                TomlFileCreator.CreateToml(NodeContent, NodeRelativePath);
            }catch (Exception E){
                Loggers.ExceptionError("Failed to write node TOML content for : " +NodePlatformType + " & " + NodeBrowserType, E);
                Assert.fail("Failed to write node TOML content for : " +NodePlatformType + " & " + NodeBrowserType, E);
            }
         return NodeRelativePath ;

    }

    public static void main(String[] args) {

        CreateNodeToml("Windows 11" , "asdasdad");
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