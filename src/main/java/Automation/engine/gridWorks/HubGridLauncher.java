package Automation.engine.gridWorks;

import Automation.engine.helpers.FileNameGetter;
import Automation.engine.helpers.PathConverter;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;

public class HubGridLauncher {

    public static String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String HubGridCommand = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubGridCommand") ;
    public static String HubDirRelativePath = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubNodesDirPath") ;
    public static String HubFileRelativePath = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubFileRelativePath") ;
    public static String HubTomlName = FileNameGetter.GetFileName(HubFileRelativePath);
    public static String HubAbsolutePath = PathConverter.ConvertPath(HubDirRelativePath, HubTomlName ) ;
    public static String HubGridHost = PropertyGetter.GetPropertyValue("ParaRunOptions", "HubGridHost") ;
    public static String RunHubGridCommand = "cd " + GridJarLocation  + " && " + HubGridCommand + " " + HubAbsolutePath  ;



    public static void HubGridStart() {
        try {
            CMDRunner.runCommand(RunHubGridCommand);
            System.out.println(" Hub server is launched on  " + HubGridHost );


        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing Hub Grid Server CMD command from properties");}
    }

}
