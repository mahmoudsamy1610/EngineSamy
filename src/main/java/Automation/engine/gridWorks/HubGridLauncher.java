package Automation.engine.gridWorks;

import Automation.engine.helpers.FileNameGetter;
import Automation.engine.helpers.PathConverter;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class HubGridLauncher  implements ISuiteListener {

    public static String GridJarLocation = PropertyGetter.GetPropertyValue("RunOptions","GridJarFile") ;
    public static String HubGridCommand = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridCommand") ;
    public static String HubFileRelativePath = PropertyGetter.GetPropertyValue("ParaRunData", "HubFileRelativePath") ;
    public static String HubAbsolutePath = PathConverter.ConvertPathToAbs(HubFileRelativePath ) ;
    public static String HubGridHost = PropertyGetter.GetPropertyValue("ParaRunData", "HubGridHost") ;
    public static String RunHubGridCommand = "cd " + GridJarLocation  + " && " + HubGridCommand + " " + HubAbsolutePath  ;


    @Override
    public void onStart(ISuite suite) {
        HubGridLauncher.StartGrid();
    }


    public static void StartGrid() {
        try {
            CMDRunner.runCommand(RunHubGridCommand);
            System.out.println(" Hub server is launched on  " + HubGridHost );


        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing Hub Grid Server CMD command from properties");}
    }






    public static void main(String[] args) {
        System.out.println(RunHubGridCommand);
        StartGrid();

    }

}
