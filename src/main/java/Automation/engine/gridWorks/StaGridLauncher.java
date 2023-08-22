package Automation.engine.gridWorks;

import Automation.engine.setupWorks.CMDRunner;
import Automation.engine.propertyWorks.PropertyGetter;

public class StaGridLauncher {

    public static String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String StaGridCommand = PropertyGetter.GetPropertyValue("RunOptions", "StaGridCommand") ;
    public static String RunStaGridCommand = "cd " + GridJarLocation  + " && " + StaGridCommand;
    public static String StaGridHost = PropertyGetter.GetPropertyValue("RunOptions", "StaGridHost") ;

    public static void StaGridStart() {
        try {
            CMDRunner.runCommand(RunStaGridCommand);
            System.out.println(" Stand alone Selenium grid is launched on  " + StaGridHost);


        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing Stand alone Grid CMD command from properties");}
    }

}



