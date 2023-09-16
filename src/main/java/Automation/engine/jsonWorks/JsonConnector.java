package Automation.engine.jsonWorks;

import Automation.engine.loggers.CoreJavaLogger;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;

import java.io.File;
import java.io.IOException;

public class JsonConnector {

  public static String ConnectToJson(String JsonFileName) {
      CoreJavaLogger.CoreJavaInfo("Getting json file : " +JsonFileName+ " , from Json files connector" );

      try {
          JsonNode rootNode = JsonReader.ReadJson("src/main/resources/AutomationResources/JsonFiles/JsonPath.json");
          JsonNode FilePathTextNode = rootNode.get(JsonFileName);

          if (FilePathTextNode != null) {
              return FilePathTextNode.asText();
          } else {
              CoreJavaLogger.CoreJavaError(" Json file : " +JsonFileName+ " , cannot be found in Json connector" );
          }
      } catch (Exception E) {
          CoreJavaLogger.CoreJavaExceptionError("problem while reading json connector for file : " + JsonFileName , E);
      }
        return null ;
  }

    public static void main(String[] args) {

        System.out.println(ConnectToJson("TiameSaving"));
    }

  }

