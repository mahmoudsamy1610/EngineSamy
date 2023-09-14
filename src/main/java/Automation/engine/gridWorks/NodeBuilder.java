package Automation.engine.gridWorks;

import Automation.engine.helpers.FileCleaner;
import Automation.engine.helpers.ListToTwoDArrayConverter;
import Automation.engine.loggers.Loggers;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.xmlWorks.XmlParser;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class NodeBuilder {


    public static void BuildNode() {

        String PomRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "PomRelativePath");
        String ParaScope = XmlParser.FindXmlTag(PomRelativePath, "parallel");

        try {
            if (ParaScope.equalsIgnoreCase("suites")) {
                BuildNodeFromSuites();
            } else if (ParaScope.equalsIgnoreCase("tests")) {
                BuildNodeFromTests();
            }
        } catch (Exception E) {
            Loggers.ExceptionError("An error occurred while building nodes", E);
            Assert.fail("An error occurred while building nodes", E);
        }

    }


    public static void BuildNodeFromTests() {

        List<String> NodePlatformTypes = TestNodeWrapper.WrapNodeTestPlatforms();
        List<String> NodeBrowserTypes = TestNodeWrapper.WrapNodeTestBrowsers();
        String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
        String NodePlatformType = null;
        String NodeBrowserType = null;


        try {

            for (String[] Couple : NodeCaps) {

                Thread BuildNodeThread;
                NodePlatformType = Couple[0];
                NodeBrowserType = Couple[1];
                Loggers.Info("Building node on : " + NodePlatformType + " for : " + NodeBrowserType + " - Detected by test level");

                String CreatedNodePath = NodeWriter.CreateNodeToml(NodePlatformType, NodeBrowserType);

                Runnable BuildNodeTask = () -> {
                    NodeRegister.RegisterNode(CreatedNodePath);
                };

                BuildNodeThread = new Thread(BuildNodeTask);
                BuildNodeThread.start();
                BuildNodeThread.sleep(3000);
                NodeCleaner.CleanNode(CreatedNodePath);

            }
        } catch (Exception E) {
            Loggers.ExceptionError("Failed to build node on : " + NodePlatformType + " for : " + NodeBrowserType + " - Detected by test level", E);
            Assert.fail("Failed to build node on : " + NodePlatformType + " for : " + NodeBrowserType + " - Detected by test level", E);
        }

    }


    public static void BuildNodeFromSuites() {

        List<String> NodePlatformTypes = SuiteNodeWrapper.WrapNodeSuitePlatforms();
        List<String> NodeBrowserTypes = SuiteNodeWrapper.WrapNodeSuiteBrowsers();
        String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
        String NodePlatformType = null;
        String NodeBrowserType = null;

        try {

            for (String[] Couple : NodeCaps) {

                Thread BuildNodeThread;
                NodePlatformType = Couple[0];
                NodeBrowserType = Couple[1];
                Loggers.Info("Building node on : " + NodePlatformType + " for : " + NodeBrowserType + " - Detected by suite level");
                String CreatedNodePath = NodeWriter.CreateNodeToml(NodePlatformType, NodeBrowserType);

                Runnable BuildNodeTask = () -> {
                    NodeRegister.RegisterNode(CreatedNodePath);
                };

                BuildNodeThread = new Thread(BuildNodeTask);
                BuildNodeThread.start();
                BuildNodeThread.sleep(3000);
                NodeCleaner.CleanNode(CreatedNodePath);
                Loggers.Info("Node has been built on : " + NodePlatformType + " for : " + NodeBrowserType + " - Detected by suite level");
            }

        } catch (Exception E) {
            Loggers.ExceptionError("Failed to build node on : " + NodePlatformType + " for : " + NodeBrowserType + " - Detected by suite level", E);
            Assert.fail("Failed to build node on : " + NodePlatformType + " for : " + NodeBrowserType + " - Detected by suite level", E);
        }

    }



    public static void main(String[] args) {

        BuildNode();


    }


}

