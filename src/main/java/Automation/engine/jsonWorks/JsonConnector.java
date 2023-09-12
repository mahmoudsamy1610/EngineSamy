package Automation.engine.jsonWorks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;

import java.io.File;
import java.io.IOException;

public class JsonConnector {

  public static String ConnectToJson(String JsonFileName) {


      try {
          JsonNode rootNode = JsonReader.ReadJson("src/main/resources/AutomationResources/JsonFiles/JsonPath.json");
          JsonNode FilePathTextNode = rootNode.get(JsonFileName);
          //String JsonFilePath = null ;

          if (FilePathTextNode != null) {
              return FilePathTextNode.asText();
          } else {
              return "Key not found.";
          }
      } catch (Exception e) {
          e.printStackTrace();
          return "Error reading JSON file.";
      }

  }

    public static void main(String[] args) {

        System.out.println(ConnectToJson("TimeSaving"));
    }

  }

