package automation.utils.jsonWorks;

import automation.utils.loggers.JavaLogger;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonConnector {

  public static String ConnectToJson(String JsonFileName) {
      JavaLogger.JavaInfo("Getting json file : " + JsonFileName + " , from Json files connector");

      JsonNode FilePathTextNode = null;

      try {
          JsonNode rootNode = JsonReader.ReadJson("src/main/resources/AutomationResources/JsonFiles/JsonPath.json");
          FilePathTextNode = rootNode.get(JsonFileName);


      } catch (Exception E) {
          JavaLogger.JavaExceptionError("problem while reading json connector for file : " + JsonFileName, E);
      }
      return FilePathTextNode.asText();
  }

    public static void main(String[] args) {

        System.out.println(ConnectToJson("TimeSaving"));
    }

  }

