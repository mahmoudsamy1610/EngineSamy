package Automation.engine.jsonWorks;

import com.fasterxml.jackson.databind.JsonNode;

public class RootNodeProvider {
    public static JsonNode GetRootNode(String JsonFileName){
        String JsonFilePath = JsonConnector.ConnectToJson(JsonFileName);
        JsonNode RootNode = JsonReader.ReadJson(JsonFilePath);
        return RootNode;
    }
}
