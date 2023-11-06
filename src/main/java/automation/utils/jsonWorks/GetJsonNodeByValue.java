package automation.utils.jsonWorks;

import automation.utils.loggers.JavaLogger;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class GetJsonNodeByValue {


    public static List<JsonNode> GetValueNode(JsonNode CurrentNode, String KeyValue, List<JsonNode> ResultNodes) {

        try {
            if (CurrentNode.isValueNode() && CurrentNode.asText().equals(KeyValue)) {
                ResultNodes.add(CurrentNode);
            }
            if (CurrentNode.isObject() || CurrentNode.isArray()) {
                for (JsonNode childNode : CurrentNode) {
                    GetValueNode(childNode, KeyValue, ResultNodes);
                }
            }
        }catch (Exception E){
            JavaLogger.JavaExceptionError("Failed to get any -Value- node by iterating using value : " + KeyValue, E);
        }
        return ResultNodes ;
    }


    public static List<JsonNode> GetContainerNode(JsonNode CurrentNode, String KeyValue, JsonNode ContainerNode , List<JsonNode> ResultNodes) {

        try {
                if (CurrentNode.isValueNode() && CurrentNode.asText().equals(KeyValue)) {
                    ResultNodes.add(ContainerNode);
                }
                if (CurrentNode.isObject() || CurrentNode.isArray()) {
                    for (JsonNode ChildNode : CurrentNode) {
                        GetContainerNode(ChildNode, KeyValue, CurrentNode, ResultNodes);
                    }
                }

            } catch (Exception E){
            JavaLogger.JavaExceptionError("Failed to get any -Container- node by iterating using value : " + KeyValue, E);
            }
        return ResultNodes;
    }


    public static void main(String[] args) {
       List< JsonNode > ResultNode = new ArrayList<>();
        JsonNode RootNode =  RootNodeProvider.GetRootNode("aTimeSaving");
        GetContainerNode(RootNode , "test"  , RootNode, ResultNode);
    }

}