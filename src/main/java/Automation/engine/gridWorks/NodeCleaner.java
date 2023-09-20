package Automation.engine.gridWorks;

import Automation.engine.helpers.FileCleaner;
import Automation.engine.loggers.EngineLogger;
import org.testng.Assert;

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
            Assert.fail("Failed to clean Node file at : " + NodeDirRelativePath, E);
        }


    }

    public static void main(String[] args) {
        CleanNode("src/main/resources/AutomationResources/TomlFiles/GridHubNodes/Linux/Firefox/linuxfirefoxNode_63sdsdf87.toml");
    }

}
