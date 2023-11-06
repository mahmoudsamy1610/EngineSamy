package automation.utils.jsonWorks;

import automation.utils.loggers.JavaLogger;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonReader {

    public static JsonNode ReadJson(String JsonFileRelativePath) {
    JavaLogger.JavaInfo("Reading Json file from : " +JsonFileRelativePath );

        JsonNode RootNode = null;

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                RootNode = objectMapper.readTree(new File(JsonFileRelativePath));

            } catch (Exception E) {
                JavaLogger.JavaExceptionError("Invalid json file provided : " + JsonFileRelativePath, E);
            }
        return RootNode;
    }

    public static void main(String[] args) {
       JsonNode node =  ReadJson("src/main/resources/AutomationResources/JsonFiles/JsonPathaa.json");
        System.out.println(node);

    }

}
