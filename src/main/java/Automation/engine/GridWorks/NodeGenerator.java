package Automation.engine.GridWorks;

import Automation.engine.helpers.TomlFileCreator;
import org.testng.annotations.Parameters;

public class NodeGenerator {


    @Parameters(value = {"NodePlatformType", "NodeBrowserType"})
    public static void CreateNodeToml(String NodeRelativePath , String NodePlatformType , String NodeBrowserType) {

        int Port = PortGenerator.GenerateHubPort(5);

        String NodeContent = "[Server]\n" +
                                 "Port=" + Port + "\n" +
                                 "[node]\n" +
                                 "[[node.driver-configuration]]\n" +
                                 "display-name =\"" +  NodeBrowserType + " \"\n" +
                                 "stereotype=\"{" + "\\\"browserName\\\": \\\""  + NodeBrowserType + "," + "\\\"platformName\\\": \\\""  + NodeBrowserType + "\\\"" + "}\"" ;


         TomlFileCreator.CreateToml(NodeContent , NodeRelativePath);

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