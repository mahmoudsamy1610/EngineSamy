package Automation.engine.jsonWorks;

import Automation.engine.loggers.JavaLogger;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class GetJsonNodeByKey {


    public static List<JsonNode> GetValueNode(JsonNode CurrentNode, String KeyName, List<JsonNode> ResultNodes) {

        try {
            if (CurrentNode.isObject() && CurrentNode.has(KeyName)) {
                ResultNodes.add(CurrentNode);
            }

            for (JsonNode ChildNode : CurrentNode) {
                GetValueNode(ChildNode, KeyName, ResultNodes);
            }

        }catch (Exception E){
            JavaLogger.JavaExceptionError("Cannot return a -VALUE- node for " + KeyName+ " , from an empty node"  , E);
        }

        return ResultNodes;
    }


    public static List<JsonNode> GetContainerNode(JsonNode CurrentNode, String KeyName, JsonNode ContainerNode , List<JsonNode> ResultNodes) {


        try {
            if (CurrentNode.isObject() && CurrentNode.has(KeyName)) {
                ResultNodes.add(CurrentNode);
            }

            for (JsonNode ChildNode : CurrentNode) {
                GetContainerNode(ChildNode, KeyName, ChildNode, ResultNodes);
            }
        }catch (Exception E){
            JavaLogger.JavaExceptionError("Cannot return a -c=Container- node for " + KeyName+ " , from an empty node"  , E);
        }

        return ResultNodes;
    }



}
