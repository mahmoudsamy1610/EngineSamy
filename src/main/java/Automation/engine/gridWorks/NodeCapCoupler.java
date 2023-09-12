package Automation.engine.gridWorks;

import Automation.engine.helpers.ListToTwoDArrayConverter;

import java.util.List;

public class NodeCapCoupler {

    public static String[][] CoupleNodeCap(List<String> NodePlatformTypes , List<String> NodeBrowserTypes){

        String[][] NodeCaps =  ListToTwoDArrayConverter.ConvertListToTwoDArray(NodePlatformTypes , NodeBrowserTypes);

        return NodeCaps ;

    }


}
