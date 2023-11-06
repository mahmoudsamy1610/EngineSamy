package automation.engine.gridWorks;

import automation.utils.helpers.ListToTwoDArrayConverter;
import automation.utils.loggers.EngineLogger;

import java.util.List;

public class NodeCapCoupler {

    public static String[][] CoupleNodeCap(List<String> NodePlatformTypes , List<String> NodeBrowserTypes) {

        String[][] NodeCaps = new String[0][];

        try {
            EngineLogger.EngineInfo("Coupling node capabilities : " + NodePlatformTypes  + NodeBrowserTypes);
            NodeCaps = ListToTwoDArrayConverter.ConvertListToTwoDArray(NodePlatformTypes, NodeBrowserTypes);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to couple : " + NodePlatformTypes  + NodeBrowserTypes, E);
        }
        return NodeCaps;

    }


}
