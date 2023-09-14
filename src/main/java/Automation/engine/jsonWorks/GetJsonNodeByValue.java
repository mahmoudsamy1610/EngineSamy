package Automation.engine.jsonWorks;

import Automation.engine.loggers.Loggers;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class GetJsonNodeByValue {


    public static List<JsonNode> GetValueNode(JsonNode CurrentNode, String KeyValue, List<JsonNode> ResultNodes) {
        if (CurrentNode.isValueNode() && CurrentNode.asText().equals(KeyValue)) {
            ResultNodes.add(CurrentNode);
        }

        if (CurrentNode.isObject() || CurrentNode.isArray()) {
            for (JsonNode childNode : CurrentNode) {
                GetValueNode(childNode, KeyValue, ResultNodes);
            }
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
                }else if (KeyValue ==null){Loggers.Error("Asdasda");}

            } catch (Exception E) {
                E.printStackTrace();
            }
        return ResultNodes;
    }


    public static void main(String[] args) {

        JsonNode RootNode = RootNodeProvider.GetRootNode("TimeSavingModule");
        String KeyValue = "bla1" ;

        List<JsonNode> ResultNodes = new ArrayList<>();
        List<JsonNode> valueNodes = GetValueNode(RootNode, KeyValue, ResultNodes) ;

        if (!valueNodes.isEmpty()) {
            System.out.println("Value Nodes Containing '" + KeyValue + "':");
            for (JsonNode node : valueNodes) {
                System.out.println(node);
            }
        } else {
            System.out.println("Value node not found in any containing nodes.");
        }
    }

    public static void main1(String[] args) {

        JsonNode RootNode = RootNodeProvider.GetRootNode("TimeSavingModule");
        List<JsonNode> ResultNodes = new ArrayList<>();
        List <JsonNode> ContainerNode = GetContainerNode(RootNode , "bla1" , RootNode, ResultNodes);

        if (!ContainerNode.isEmpty()) {
            for (JsonNode node : ContainerNode) {
                System.out.println(node);
            }
        }
    }


}