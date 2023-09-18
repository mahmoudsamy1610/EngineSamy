package Automation.engine.jsonWorks;

import Automation.engine.loggers.CoreJavaLogger;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;

import java.io.File;
import java.io.IOException;

public class JsonConnector {

  public static String ConnectToJson(String JsonFileName) {
      CoreJavaLogger.CoreJavaInfo("Getting json file : " + JsonFileName + " , from Json files connector");

      JsonNode FilePathTextNode = null;

      try {
          JsonNode rootNode = JsonReader.ReadJson("src/main/resources/AutomationResources/JsonFiles/JsonPath.json");
          FilePathTextNode = rootNode.get(JsonFileName);


      } catch (Exception E) {
          CoreJavaLogger.CoreJavaExceptionError("problem while reading json connector for file : " + JsonFileName, E);
      }
      return FilePathTextNode.asText();
  }

    public static void main(String[] args) {

        System.out.println(ConnectToJson("TimeSaving"));
    }

  }

