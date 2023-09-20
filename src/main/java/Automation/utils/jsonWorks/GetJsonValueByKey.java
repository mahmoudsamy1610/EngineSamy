package Automation.utils.jsonWorks;

import Automation.utils.loggers.JavaLogger;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class GetJsonValueByKey {

    public static List<String> GetValueByNodeKey(List<JsonNode> Nodes, String KeyName) {
        //Just a helper not actually used in the engine
        JavaLogger.JavaInfo("Fetching list of values of key : " + KeyName+ " using provided -VALUE- node");

        List<String> KeyValues = new ArrayList<>();
        try {
        for (JsonNode node : Nodes) {
            JsonNode keyValueNode = node.get(KeyName);
            if (keyValueNode != null && keyValueNode.isValueNode()) {
                KeyValues.add(keyValueNode.asText());
            }
        }
        if (KeyValues.isEmpty()){
            JavaLogger.JavaError("The key : " +KeyName+  " is not found , Cannot return list of values");
            throw new IllegalArgumentException();
        }

        }catch (Exception E){
            JavaLogger.JavaExceptionError("Failed to find key : " +KeyName+  " inside the provided node " , E);
        }
        return KeyValues;
    }



    public static List <String> GetValueByKeyName (String KeyName , String JsonFileName ) {
        JavaLogger.JavaInfo("Fetching list of values of : " + KeyName + " from file : " + JsonFileName);

        List<String> KeyValues = new ArrayList<>();

        try {
            List<JsonNode> ResultNodes = new ArrayList<>();
            JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
            List<JsonNode> TargetNode = GetJsonNodeByKey.GetValueNode(RootNode, KeyName, ResultNodes);
            KeyValues = GetValueByNodeKey(TargetNode, KeyName);

        } catch (Exception E) {
        JavaLogger.JavaExceptionError("Invalid json file provided : " + JsonFileName , E);
        }
        return KeyValues;
    }


    public static List <String> GetValueByContainerKey (String KeyName , String JsonFileName , String NodeDefinerValue) {
        JavaLogger.JavaInfo("Fetching list of values of : " + KeyName + " ,from file : " + JsonFileName+ " ,Defined by : " + NodeDefinerValue);


        List<JsonNode> ResultNodes = new ArrayList<>();
        JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
        List<JsonNode> TargetNode = GetJsonNodeByValue.GetContainerNode(RootNode, NodeDefinerValue, RootNode, ResultNodes);
        List<String> KeyValues = new ArrayList<>();

        try {
            KeyValues = GetValueByNodeKey(TargetNode, KeyName);

        }catch (Exception E) {
            JavaLogger.JavaExceptionError("Invalid json file provided : " + JsonFileName , E);
        }

        return KeyValues;
    }


    public static void main(String[] args) {
            String JsonFileName = "TimeSaving";
            String NodeDefinerValue = "test1a" ;
            String KeyName = "Platform" ;
          //  List<JsonNode> ResultNodes = new ArrayList<>();

        JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
     //   List<JsonNode> TargetNode = GetJsonNodeByValue.GetContainerNode(RootNode, NodeDefinerValue, RootNode, ResultNodes);
       System.out.println(GetValueByKeyName(KeyName , JsonFileName ));
    }


}


