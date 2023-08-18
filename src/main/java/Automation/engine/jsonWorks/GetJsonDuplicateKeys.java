package Automation.engine.jsonWorks;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class GetJsonDuplicateKeys {

    public static List<String> GetJsonDuplicateKeys(String JsonFileName , String KeyName) {

        List<String> keyValues = new ArrayList<>();


        try {
            String JsonFilePath = JsonConnector.ConnectToJson(JsonFileName);
            JsonNode RootNode = JsonReader.ReadJson(JsonFilePath);

            for (JsonNode GridNode : RootNode) {
                String keyValue = GridNode.get(KeyName).asText();
                keyValues.add(keyValue);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return keyValues;
    }



    public static void main(String[] args) {
        System.out.println(GetJsonDuplicateKeys("TimeSavingModule" , "Suite"));
    }

    }


