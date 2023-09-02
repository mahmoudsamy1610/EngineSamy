package Automation.engine.gridWorks;

import Automation.engine.propertyWorks.PropertyGetter;

import java.util.ArrayList;
import java.util.List;

public class NodeBuilder {


    public static void BuildNode(String ParaModule) {

        String NodePlatformType = NodeWrapper.WrapNodePlatformList(ParaModule);
        String NodeBrowserType = NodeWrapper.WrapNodeBrowserList(ParaModule);

               String CreatedNodePath = NodeWriter.CreateNodeToml(NodePlatformType, NodeBrowserType);
               NodeRegister.RegisterNode(CreatedNodePath);
            }



    public static void main2(String[] args) {
        BuildNode("");
    }

    /*
    public static void main1(String[] args) {
      List<String> NodePlatformTypes = NodeWrapper.WrapNodePlatform("TimeSavingModule");
      List<String> NodeBrowserTypes = NodeWrapper.WrapNodeBrowser("TimeSavingModule");

        List<String>[][] matrix = {
                {NodePlatformTypes, NodeBrowserTypes}
        };

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row]+ " ");
            }
            System.out.println();
        }

    }


     */

/*
    public static void main(String[] args) {


        List<List<String>> PlatformsBrowsersCombined = new ArrayList<>();
        List<String> NodePlatformTypes = NodeWrapper.WrapNodePlatformList("TimeSavingModule");
        List<String> NodeBrowserTypes = NodeWrapper.WrapNodeBrowserList("TimeSavingModule");


        PlatformsBrowsersCombined.add(NodePlatformTypes);
        PlatformsBrowsersCombined.add(NodeBrowserTypes);

/*
        for( List<List<String>> PlatformBrowserCombined : PlatformsBrowsersCombined) {

                NodeWriter.CreateNodeToml(NodePlatformType, NodeBrowserType);
            }




        // Accessing elements
         String WrappedNodePlatforms =  PlatformBrowserCombined.get(0).get(0);
         String WrappedNodeBrowsers =  PlatformBrowserCombined.get(1).get(0);
    }



 */

    }

