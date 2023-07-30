package Automation.engine.GridWorks;

import Automation.engine.setupWorks.CMDRunner;
import Automation.engine.propertyWorks.GetProperty;

public class GridLauncher {

    public static String GridJarLocation = GetProperty.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String GridStaCommand = GetProperty.GetPropertyValue("RunOptions", "StaGridCommand") ;
    public static String RunGridStaCommand = "cd " + GridJarLocation  + " && " + GridStaCommand ;
    public static String GridStaHost = GetProperty.GetPropertyValue("RunOptions", "StaGridHost") ;

    public static void GridStaLauncher() {
        try {
            CMDRunner.runCommand(RunGridStaCommand);
            System.out.println(" Stand alone Selenium grid is launched on  " + GridStaHost );


        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing CMD command from properties");}
    }

}



