package Automation.engine.jsonWorks;

import Automation.engine.loggers.CoreJavaLogger;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static JsonNode ReadJson(String JsonFileRelativePath) {
    CoreJavaLogger.CoreJavaInfo("Reading Json file from : " +JsonFileRelativePath );

        JsonNode RootNode = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RootNode = objectMapper.readTree(new File(JsonFileRelativePath));

        } catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Invalid json file provided : " + JsonFileRelativePath, E);
        }
        return RootNode;
    }

    public static void main(String[] args) {
       JsonNode node =  ReadJson(null);
        System.out.println(node);

    }

}
