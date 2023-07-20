package Automation.engine;

public class GridLauncher {

    public static String GridJarLocation = GetProperty.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String GridStaCommand = GetProperty.GetPropertyValue("RunOptions","GridStaCommand") ;
    public static String RunGridStaCommand = "cd " + GridJarLocation  + " && " + GridStaCommand ;
    public static String GridStaHost = GetProperty.GetPropertyValue("RunOptions","RemoteHost") ;

    public static void GridStaLauncher() {
        try {
            CMDRunner.runCommand(RunGridStaCommand);
            System.out.println(" Stand alone Selenium grid is launched on  " + GridStaHost );


        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing CMD command from properties");}
    }

}



