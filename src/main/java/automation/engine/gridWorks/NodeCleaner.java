package automation.engine.gridWorks;

import automation.utils.helpers.FileCleaner;
import automation.utils.loggers.EngineLogger;

public class NodeCleaner {

    public static void CleanNode(String NodeDirRelativePath){

        try {
            EngineLogger.EngineInfo("Cleaning TOML node file at : " + NodeDirRelativePath);

            Thread DeleteNodeTomlThread;
            Runnable DeleteNodeTomlTask = () -> {
                FileCleaner.CleanFile(NodeDirRelativePath);
            };

            DeleteNodeTomlThread = new Thread(DeleteNodeTomlTask);
            DeleteNodeTomlThread.start();


        }catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to clean Node file at : " + NodeDirRelativePath, E);
        }


    }

    public static void main(String[] args) {
        CleanNode("src/main/resources/AutomationResources/TomlFiles/GridHubNodes/Linux/Firefox/linuxfirefoxNode_63sdsdf87.toml");
    }

}
