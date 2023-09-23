package Automation.engine.gridWorks;

<<<<<<< HEAD
import Automation.utils.helpers.StringPicker;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
=======
import Automation.engine.helpers.StringConcatenator;
import Automation.engine.helpers.StringPicker;
import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
>>>>>>> main
import org.testng.Assert;

public class NodePathGenerator {





    public static String GenerateNodeTomlName(String  NodePlatformType , String NodeBrowserType ) {
        EngineLogger.EngineInfo("Creating node TOML file name for : " +NodePlatformType+ " & " + NodeBrowserType);

        String NodeTomlName = null;

        try {
            NodeTomlName = StringConcatenator.Concatenate(NodePlatformType, NodeBrowserType , "Node");

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to Create node TOML file name : " +NodePlatformType + NodeBrowserType , E);
        }
        return NodeTomlName;
    }


    public static String GenerateNodeTomlPathOnly(String  NodePlatformType , String NodeBrowserType) {

        String NodeRelativePath = null;

        try {
            String NodeGeneralPath = PropertyGetter.GetPropertyValue("ParaRunData", "NodePathDir");
            NodeRelativePath = StringConcatenator.Concatenate(NodeGeneralPath,NodePlatformType,"\\", NodeBrowserType);
            EngineLogger.EngineInfo("Generating node TOML file path at : " + NodeRelativePath);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to Decide node TOML file path at : " + NodeRelativePath, E);
            Assert.fail("Failed Generating node TOML file path at : " + NodeRelativePath, E);
        }
        return NodeRelativePath;
    }



    public static String GenerateNodeTomlFullPath(String  NodePlatformType , String NodeBrowserType) {

        String NodeRelativePath = null;

        try {
            int Port = PortGenerator.GenerateHubPort(4);
            String NodeRelativeDirPath = GenerateNodeTomlPathOnly(NodePlatformType, NodeBrowserType);
            String NodeTomlName = GenerateNodeTomlName(NodePlatformType, NodeBrowserType);
            NodeRelativePath = StringConcatenator.Concatenate(NodeRelativeDirPath , "\\" , NodeTomlName , "_" + Port , ".toml");
            EngineLogger.EngineInfo("Generating node TOML file FULL path : " + NodeRelativePath);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to Created node TOML file FULL path : " + NodeRelativePath, E);
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

        String path = GenerateNodeTomlFullPath("" , "chrome");
        GetNodePort(path);
    }


}
