package Automation.engine.gridWorks;

import Automation.engine.helpers.ListToTwoDArrayConverter;
import Automation.engine.loggers.Loggers;
import org.testng.Assert;

import java.util.List;

public class NodeCapCoupler {

    public static String[][] CoupleNodeCap(List<String> NodePlatformTypes , List<String> NodeBrowserTypes) {

        String[][] NodeCaps = new String[0][];

        try {
            Loggers.Info("Coupling node capabilities : " + NodePlatformTypes  + NodeBrowserTypes);
            NodeCaps = ListToTwoDArrayConverter.ConvertListToTwoDArray(NodePlatformTypes, NodeBrowserTypes);

        } catch (Exception E) {
            Loggers.ExceptionError("Failed to couple : " + NodePlatformTypes  + NodeBrowserTypes, E);
            Assert.fail("Failed to couple : " + NodePlatformTypes  + NodeBrowserTypes, E);
        }
        return NodeCaps;

    }


}
