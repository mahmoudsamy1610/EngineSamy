package Automation.engine.gridWorks;

import Automation.engine.setupWorks.CMDRunner;
import Automation.engine.propertyWorks.GetProperty;

public class StaGridLauncher {

    public static String GridJarLocation = GetProperty.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String StaGridCommand = GetProperty.GetPropertyValue("RunOptions", "StaGridCommand") ;
    public static String RunStaGridCommand = "cd " + GridJarLocation  + " && " + StaGridCommand;
    public static String StaGridHost = GetProperty.GetPropertyValue("RunOptions", "StaGridHost") ;

    public static void StaGridStart() {
        try {
            CMDRunner.runCommand(RunStaGridCommand);
            System.out.println(" Stand alone Selenium grid is launched on  " + StaGridHost);


        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing Stand alone Grid CMD command from properties");}
    }

}



