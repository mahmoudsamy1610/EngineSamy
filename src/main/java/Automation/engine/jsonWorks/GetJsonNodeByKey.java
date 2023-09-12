package Automation.engine.jsonWorks;

import com.fasterxml.jackson.databind.JsonNode;
import org.checkerframework.checker.units.qual.K;

import java.util.ArrayList;
import java.util.List;

public class GetJsonNodeByKey {


    public static List<JsonNode> GetValueNode(JsonNode CurrentNode, String KeyName, List<JsonNode> ResultNodes) {
        if (CurrentNode.isObject() && CurrentNode.has(KeyName)) {
            ResultNodes.add(CurrentNode);
        }

        for (JsonNode ChildNode : CurrentNode) {
            GetValueNode(ChildNode , KeyName , ResultNodes) ;
        }

        return ResultNodes;
    }


    public static List<JsonNode> GetContainerNode(JsonNode CurrentNode, String KeyName, JsonNode ContainerNode , List<JsonNode> ResultNodes) {

        if (CurrentNode.isObject() && CurrentNode.has(KeyName)) {
            ResultNodes.add(CurrentNode);
        }

        for (JsonNode ChildNode : CurrentNode) {
            GetContainerNode(ChildNode , KeyName , ChildNode , ResultNodes) ;
        }

        return ResultNodes;
    }

    public static void main(String[] args) {

        JsonNode RootNode = RootNodeProvider.GetRootNode("TimeSavingModule");
        String KeyName = "Suite" ;

        List<JsonNode> ResultNodes = new ArrayList<>();
        List<JsonNode> valueNodes = GetValueNode(RootNode, KeyName, ResultNodes) ;

        if (!valueNodes.isEmpty()) {
            System.out.println("Value Nodes Containing '" + KeyName + "':");
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
        List <JsonNode> ContainerNode = GetContainerNode(RootNode , "test1" , RootNode, ResultNodes);

        if (!ContainerNode.isEmpty()) {
            for (JsonNode node : ContainerNode) {
                System.out.println(node);
            }

        } else {
            System.out.println("Value node not found in any containing nodes.");
        }

    }




}
