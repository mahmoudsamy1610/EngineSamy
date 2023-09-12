package Automation.engine.gridWorks;

import Automation.engine.helpers.DirFilesCounter;

public class NodeTomlSuffixCreator {

    public static int CountNodeFiles(String DirRelativePath) {

        try {
            int DirTomlCounts =  DirFilesCounter.CountDirFiles(DirRelativePath);
            return  DirTomlCounts ;
        }catch (IllegalArgumentException IAE){IAE.getMessage();}
        return 0 ;
    }

    public static String CreateNodeSuffix( String DirRelativePath) {

        try {
            int NodeTomlSuffix =  CountNodeFiles(DirRelativePath)+1;
            return String.valueOf(NodeTomlSuffix);
        }catch (IllegalArgumentException IAE){IAE.getMessage();}
        return "0" ;

    }


    public static void main(String[] args) {
      //  String suffix = CreateNodeSuffix("src/main/resources/AutomationResources/TomlFiles/GridHubNodes/Linux/Firefox") ;
      //  System.out.println(suffix);

    }


}
