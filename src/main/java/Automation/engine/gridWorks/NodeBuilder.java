package Automation.engine.gridWorks;

import Automation.engine.suiteWorks.SuiteDataGetterByRun;

import java.util.List;

public class NodeBuilder {

    public static void BuildNode(){

        List<String> NodePlatformTypes = NodeWrapper.WrapNodePlatform("TimeSavingModule");
        List<String> NodeBrowserTypes = NodeWrapper.WrapNodeBrowser("TimeSavingModule");

        for(String NodePlatformType : NodePlatformTypes) {
            for(String NodeBrowserType : NodeBrowserTypes) {
                NodeWriter.CreateNodeToml(NodePlatformType, NodeBrowserType);
            }
        }
    }

    public static void main(String[] args) {
        BuildNode();
    }

}
