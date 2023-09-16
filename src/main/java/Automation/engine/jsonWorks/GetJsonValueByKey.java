package Automation.engine.jsonWorks;

import Automation.engine.loggers.CoreJavaLogger;
import Automation.engine.loggers.EngineLogger;
import com.fasterxml.jackson.databind.JsonNode;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class GetJsonValueByKey {

    public static List<String> GetValueByNodeKey(List<JsonNode> Nodes, String KeyName) {
        //Just a helper not actually used in the engine
        CoreJavaLogger.CoreJavaInfo("Fetching list of values of key : " + KeyName+ " using provided -VALUE- node");

        List<String> KeyValues = new ArrayList<>();
        try {
        for (JsonNode node : Nodes) {
            JsonNode keyValueNode = node.get(KeyName);
            if (keyValueNode != null && keyValueNode.isValueNode()) {
                KeyValues.add(keyValueNode.asText());
            }

        }if (Nodes.isEmpty()){
                CoreJavaLogger.CoreJavaError("Cannot find : " +KeyName+  " inside an empty json node ");
            }

        if (KeyValues.isEmpty()){
            CoreJavaLogger.CoreJavaError("The key : " +KeyName+  " is not found , Cannot return list of values");
             }

        }catch (Exception E){
            CoreJavaLogger.CoreJavaExceptionError("Failed to find key : " +KeyName+  " inside the provided node " , E);
        }
        return KeyValues;
    }



    public static List <String> GetValueByKeyName (String KeyName , String JsonFileName ) {
        CoreJavaLogger.CoreJavaInfo("Fetching list of values of : " + KeyName + " from file : " + JsonFileName);

        List<String> KeyValues = new ArrayList<>();

        try {
            List<JsonNode> ResultNodes = new ArrayList<>();
            JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
            List<JsonNode> TargetNode = GetJsonNodeByKey.GetValueNode(RootNode, KeyName, ResultNodes);
            KeyValues = GetValueByNodeKey(TargetNode, KeyName);

            /*
            if (!KeyValues.isEmpty()) {
                for (String value : KeyValues) {
                    System.out.println(value);
                }
                }
             */
             if (KeyValues.isEmpty()){
                CoreJavaLogger.CoreJavaError("Cannot find : " +KeyName+  " from file : " + JsonFileName);
            }
            if (TargetNode.isEmpty()){
                CoreJavaLogger.CoreJavaError("Node resultant from : " +KeyName+  " ,is empty");
            }

        } catch (Exception E) {
        CoreJavaLogger.CoreJavaExceptionError("Invalid json file provided : " + JsonFileName , E);
        }
        return KeyValues;
    }


    public static List <String> GetValueByContainerKey (String KeyName , String JsonFileName , String NodeDefinerValue) {
        CoreJavaLogger.CoreJavaInfo("Fetching list of values of : " + KeyName + " ,from file : " + JsonFileName+ " ,Defined by : " + NodeDefinerValue);


        List<JsonNode> ResultNodes = new ArrayList<>();
        JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
        List<JsonNode> TargetNode = GetJsonNodeByValue.GetContainerNode(RootNode, NodeDefinerValue, RootNode, ResultNodes);
        List<String> KeyValues = new ArrayList<>();

        try {
            KeyValues = GetValueByNodeKey(TargetNode, KeyName);

            if (KeyValues.isEmpty()) {
                CoreJavaLogger.CoreJavaError("Cannot find : " + KeyName + " , Searching by : " + NodeDefinerValue + " ,from file : " + JsonFileName);
            }
            if (TargetNode.isEmpty()){
                CoreJavaLogger.CoreJavaError("Cannot find : " + NodeDefinerValue + " ,from file : " + JsonFileName);
            }

        }catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Invalid json file provided : " + JsonFileName , E);
        }

        return KeyValues;
    }


    public static void main(String[] args) {
            String JsonFileName = "TimeSaving";
            String NodeDefinerValue = "test1" ;
            String KeyName = "aPlatform" ;
          //  List<JsonNode> ResultNodes = new ArrayList<>();

        JsonNode RootNode = RootNodeProvider.GetRootNode(JsonFileName);
     //   List<JsonNode> TargetNode = GetJsonNodeByValue.GetContainerNode(RootNode, NodeDefinerValue, RootNode, ResultNodes);
       System.out.println(GetValueByContainerKey(KeyName , JsonFileName ,NodeDefinerValue));
    }


}


