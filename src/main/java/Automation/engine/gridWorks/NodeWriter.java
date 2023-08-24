package Automation.engine.gridWorks;

import Automation.engine.helpers.TomlFileCreator;
import org.testng.annotations.Parameters;

public class NodeWriter {


    public static void CreateNodeToml(String NodePlatformType , String NodeBrowserType) {

        int Port = PortGenerator.GenerateHubPort(5);
        String NodeRelativePath = NodePathGenerator.GenerateNodeTomlPath( NodePlatformType ,  NodeBrowserType);

        String NodeContent = "[Server]\n" +
                                 "Port=" + Port + "\n" +
                                 "[node]\n" +
                                 "[[node.driver-configuration]]\n" +
                                 "display-name =\"" +  NodeBrowserType + " \"\n" +
                                 "stereotype=\"{" + "\\\"browserName\\\": \\\""  + NodeBrowserType + "," + "\\\"platformName\\\": \\\""  + NodePlatformType + "\\\"" + "}\"" ;


         TomlFileCreator.CreateToml(NodeContent , NodeRelativePath);

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