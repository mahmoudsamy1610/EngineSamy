package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.GetProperty;

public class NodeWrapper {


    public static String WrapNodePlatform() {

        String NodePlatformType = GetProperty.GetPropertyValue("NodeCapDecider" , "Platform");

        return NodePlatformType;
    }

    public static String WrapNodeBrowser() {

        String NodeBrowserType = GetProperty.GetPropertyValue("NodeCapDecider" , "Browser");

        return NodeBrowserType;
    }


}
