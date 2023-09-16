package Automation.engine.jsonWorks;

import Automation.engine.loggers.CoreJavaLogger;
import com.fasterxml.jackson.databind.JsonNode;

public class RootNodeProvider {


    public static JsonNode GetRootNode(String JsonFileName) {
        CoreJavaLogger.CoreJavaInfo("Reading root json node from file : " + JsonFileName);

        JsonNode RootNode = null;

        try {
            String JsonFilePath = JsonConnector.ConnectToJson(JsonFileName);
            RootNode = JsonReader.ReadJson(JsonFilePath);

        } catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Cannot get json root node from file : " +JsonFileName , E);
        }
        return RootNode;
    }

    public static void main(String[] args) {
        GetRootNode("asdadsadas");
    }

}
