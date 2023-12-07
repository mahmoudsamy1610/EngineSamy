package automation.engine.gridWorks;

import automation.utils.fileWorks.TomlFileCreator;
import automation.utils.loggers.EngineLogger;

public class NodeWriter {
    /**
     *<p> Ex
     *<p> "title = \"My TOML File\"\n" +
     *<p>                       "[author]\n" +
     *<p>                        "name = \"John Doe\"\n" +
     *<p>                        "email = \"john@example.com\"\n";
     *<p>
     *<p> -----------------------------------------------------
     *<p> title = "My TOML File"
     *<p>         [author]
     *<p>         name = "John Doe"
     *<p>         email = "john@example.com"
     *<p> ----------------------------------------------------------
     *<p> [server]
     *<p> port = 10001
     *<p> [node]
     *<p> [[node.driver-configuration]]
     *<p> display-name = "firefox"
     *<p> stereotype = "{\"browserName\": \"firefox\", \"platformName\": \"Windows 10\" }"
     *<p>
     */

    public static String CreateNodeToml(String NodePlatformType , String NodeBrowserType) {
        EngineLogger.EngineInfo("Writing node TOML content for : " + NodePlatformType + " & " + NodeBrowserType);

        String NodeRelativePath = null;

        try {
            NodeRelativePath = NodePathGenerator.GenerateNodeTomlFullPath(NodePlatformType, NodeBrowserType);
            int Port = NodePathGenerator.GetNodePort(NodeRelativePath);

            String NodeContent = "[server]\n" +
                    "port=" + Port + "\n" +
                    "\n" +
                    "[node]\n" +
                    "selenium-manager = true\n" +
                    "[[node.driver-configuration]]\n" +
                    "display-name =\"" + NodeBrowserType + "\"\n" +
                    "stereotype=\"{" + "\\\"browserName\\\": \\\"" + NodeBrowserType + "\\\"" + "," + "\\\"platformName\\\": \\\"" + NodePlatformType + "\\\"" + "}\"";

            TomlFileCreator.CreateToml(NodeContent, NodeRelativePath);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to write node TOML content for : " + NodePlatformType + " & " + NodeBrowserType, E);
        }
        return NodeRelativePath;

    }

    public static void main(String[] args) {

        //CreateNodeToml("Windows 11" , "chrome");
    }

}

