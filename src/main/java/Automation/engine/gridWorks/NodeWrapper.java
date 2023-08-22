package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.PropertyGetter;

public class NodeWrapper {


    public static String WrapNodePlatform() {

        String NodePlatformType = PropertyGetter.GetPropertyValue("NodeCapDecider" , "Platform");

        return NodePlatformType;
    }

    public static String WrapNodeBrowser() {

        String NodeBrowserType = PropertyGetter.GetPropertyValue("NodeCapDecider" , "Browser");

        return NodeBrowserType;
    }


}
