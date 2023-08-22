package Automation.engine.jsonWorks;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class GetJsonValueByKey {

    public static List<String> GetValueByNodeKey(List<JsonNode> Nodes, String KeyName) {

        List<String> KeyValues = new ArrayList<>();

        for (JsonNode node : Nodes) {
            JsonNode keyValueNode = node.get(KeyName);
            if (keyValueNode != null && keyValueNode.isValueNode()) {
                KeyValues.add(keyValueNode.asText());
            }
        }
        return KeyValues;
    }



    public static List <String> GetValueByKeyName (String KeyName , String JsonFileName ){

        List<JsonNode> ResultNodes = new ArrayList<>();
        JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
        List <JsonNode>  TargetNode = GetJsonNodeByKey.GetValueNode(RootNode , KeyName , ResultNodes);
        List<String> KeyValues = GetValueByNodeKey(TargetNode, KeyName);

        //This block should be replaced by try and catch
        if (!KeyValues.isEmpty()) {
            for (String value : KeyValues) {
                System.out.println(value);
            }
        } else {
            System.out.println("No values found.");
        }

        return KeyValues ;


    }


    public static List <String> GetValueByContainerKey (String KeyName , String JsonFileName , String NodeDefinerValue){

        List<JsonNode> ResultNodes = new ArrayList<>();
        JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
        List <JsonNode>  TargetNode = GetJsonNodeByValue.GetContainerNode(RootNode , NodeDefinerValue , RootNode , ResultNodes);
        List<String> KeyValues = GetValueByNodeKey(TargetNode, KeyName);

        //This block should be replaced by try and catch
        if (!KeyValues.isEmpty()) {
            for (String value : KeyValues) {
                System.out.println(value);
            }
        } else {
            System.out.println("No values found.");
        }

        return KeyValues ;


    }




    public static void main1(String[] args) {

        GetValueByContainerKey("Platform" , "TimeSavingModule" , "Login2") ;

    }

    public static void main(String[] args) {

        GetValueByKeyName("Suite" , "TimeSavingModule");


    }

}


