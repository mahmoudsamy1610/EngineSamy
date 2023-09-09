package Automation.engine.gridWorks;

import Automation.engine.helpers.ListToTwoDArrayConverter;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.xmlWorks.XmlParser;

import java.util.List;
import java.util.Properties;

public class NodeBuilder {




    public static void BuildNode() {

        String PomRelativePath = PropertyGetter.GetPropertyValue("RunOptions" , "PomRelativePath");
        String ParaScope = XmlParser.FindXmlTag(PomRelativePath,"parallel");

        if (ParaScope.equalsIgnoreCase("suites")){
            BuildNodeFromSuites();
        }else if (ParaScope.equalsIgnoreCase("tests")){
            BuildNodeFromTests();
        }

    }





    public static void BuildNodeFromTests() {

        List<String> NodePlatformTypes = TestNodeWrapper.WrapNodeTestPlatforms();
        List<String> NodeBrowserTypes = TestNodeWrapper.WrapNodeTestBrowsers();
        String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);


        for (String[] Couple : NodeCaps) {
            Thread BuildNodeThread;
            try {
                Runnable BuildNodeTask = () -> {
                    String NodePlatformType = Couple[0];
                    String NodeBrowserType = Couple[1];
                    String CreatedNodePath = NodeWriter.CreateNodeToml(NodePlatformType, NodeBrowserType);
                    NodeRegister.RegisterNode(CreatedNodePath);
                };

                BuildNodeThread = new Thread(BuildNodeTask);
                BuildNodeThread.start();
                BuildNodeThread.sleep(5000);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }





        }
    }




    public static void BuildNodeFromSuites() {

        List<String> NodePlatformTypes = SuiteNodeWrapper.WrapNodeSuitePlatforms();
        List<String> NodeBrowserTypes = SuiteNodeWrapper.WrapNodeSuiteBrowsers();
        String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);


        for (String[] Couple : NodeCaps) {
            Thread BuildNodeThread;
            try {
                Runnable BuildNodeTask = () -> {
                    String NodePlatformType = Couple[0];
                    String NodeBrowserType = Couple[1];
                    String CreatedNodePath = NodeWriter.CreateNodeToml(NodePlatformType, NodeBrowserType);
                    NodeRegister.RegisterNode(CreatedNodePath);
                };

                BuildNodeThread = new Thread(BuildNodeTask);
                BuildNodeThread.start();
                BuildNodeThread.sleep(5000);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }





    public static void main(String[] args) {

        BuildNode();


    }


}

