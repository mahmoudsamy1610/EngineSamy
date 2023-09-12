package Automation.engine.gridWorks;

import Automation.engine.helpers.FileCleaner;
import org.apache.commons.io.filefilter.CanReadFileFilter;

public class NodeCleaner {

    public static void CleanNode(String NodeDirRelativePath){

        try {
            Thread DeleteNodeTomlThread;
            Runnable DeleteNodeTomlTask = () -> {
                FileCleaner.CleanFile(NodeDirRelativePath);
                System.out.println("Node Toml Deleted at" + NodeDirRelativePath);
            };

            DeleteNodeTomlThread = new Thread(DeleteNodeTomlTask);
            DeleteNodeTomlThread.start();


        } catch (Exception e) {
            e.getMessage();
        }


    }

    public static void main(String[] args) {
        CleanNode("src/main/resources/AutomationResources/TomlFiles/GridHubNodes/Linux/Firefox/linuxfirefoxNode_63sdsdf87.toml");
    }

}
