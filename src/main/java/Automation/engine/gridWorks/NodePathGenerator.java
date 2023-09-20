package Automation.engine.gridWorks;

import Automation.utils.helpers.StringPicker;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import org.testng.Assert;

public class NodePathGenerator {





    public static String GenerateNodeTomlName(String  NodePlatformType , String NodeBrowserType ) {

        String NodeTomlName = null;

        try {
            EngineLogger.EngineInfo("Creating node TOML file name : " +NodePlatformType + NodeBrowserType);

            NodeTomlName = NodePlatformType + NodeBrowserType + "Node";

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to Create node TOML file name : " +NodePlatformType + NodeBrowserType , E);
            Assert.fail("Failed to Create node TOML file name : " +NodePlatformType +  NodeBrowserType , E);
        }
        return NodeTomlName;
    }


    public static String GenerateNodeTomlPathOnly(String  NodePlatformType , String NodeBrowserType) {

        String NodeRelativePath = null;
        try {

            String NodeGeneralPath = PropertyGetter.GetPropertyValue("ParaRunData", "NodePathDir");
            NodeRelativePath = NodeGeneralPath + NodePlatformType + "\\" + NodeBrowserType;
            EngineLogger.EngineInfo("Deciding node TOML file path at : " + NodeRelativePath);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to Decide node TOML file path at : " + NodeRelativePath, E);
            Assert.fail("Failed to Decide node TOML file path at : " + NodeRelativePath, E);
        }
        return NodeRelativePath;
    }



    public static String GenerateNodeTomlFullPath(String  NodePlatformType , String NodeBrowserType) {

        String NodeRelativePath = null;
        try {

            int Port = PortGenerator.GenerateHubPort(4);
            String NodeRelativeDirPath = GenerateNodeTomlPathOnly(NodePlatformType, NodeBrowserType);
            String NodeTomlName = GenerateNodeTomlName(NodePlatformType, NodeBrowserType);
            NodeRelativePath = NodeRelativeDirPath + "\\" + NodeTomlName + "_" + Port + ".toml";
            EngineLogger.EngineInfo("Creating node TOML file FULL path : " + NodeRelativePath);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to Created node TOML file FULL path : " + NodeRelativePath, E);
            Assert.fail("Failed to Created node TOML file FULL path : " + NodeRelativePath, E);
        }

        return NodeRelativePath;
    }

    public static int GetNodePort(String NodeRelativePath) {

        int Port = 0;
        try {

            String PortWithName = StringPicker.PickString(NodeRelativePath, "_.*.toml");
            String PortNumber = StringPicker.ExtractString(PortWithName, 1, 5);
            Port = Integer.parseInt(PortNumber);
            EngineLogger.EngineInfo("Detecting port number : " + Port);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to detect port number : " + Port, E);
            Assert.fail("Failed to detect port number : " + Port, E);
        }
        return Port;
    }



    public static void main(String[] args) {

        String path = GenerateNodeTomlFullPath("Linux" , "chrome");
        GetNodePort(path);
    }


}
