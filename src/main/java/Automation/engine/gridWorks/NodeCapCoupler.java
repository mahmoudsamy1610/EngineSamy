package Automation.engine.gridWorks;

import Automation.engine.helpers.ListToTwoDArrayConverter;
import Automation.engine.loggers.EngineLogger;
import org.testng.Assert;

import java.util.List;

public class NodeCapCoupler {

    public static String[][] CoupleNodeCap(List<String> NodePlatformTypes , List<String> NodeBrowserTypes) {

        String[][] NodeCaps = new String[0][];

        try {
            EngineLogger.EngineInfo("Coupling node capabilities : " + NodePlatformTypes  + NodeBrowserTypes);
            NodeCaps = ListToTwoDArrayConverter.ConvertListToTwoDArray(NodePlatformTypes, NodeBrowserTypes);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to couple : " + NodePlatformTypes  + NodeBrowserTypes, E);
            Assert.fail("Failed to couple : " + NodePlatformTypes  + NodeBrowserTypes, E);
        }
        return NodeCaps;

    }


}
