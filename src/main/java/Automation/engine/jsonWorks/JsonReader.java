package Automation.engine.jsonWorks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static JsonNode ReadJson(String JsonFileRelativePath) {
        // Specify the path to the JSON file

        // Create an ObjectMapper instance

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode RootNode = objectMapper.readTree(new File(JsonFileRelativePath));
            return RootNode ;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null ;
    }

    public static void main(String[] args) {
       JsonNode node =  ReadJson("src/main/resources/AutomationResources/JsonFiles/GridFiles/TimeSavingModule.json");
        System.out.println(node);

    }

}
