package Automation.engine.gridWorks;

import Automation.engine.helpers.CMDRunner;
import Automation.engine.helpers.TaskCleaner;
import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.IExecutionListener;

//usage is not recommended
// it deletes all java.exe , you will need to reRun any class twice , this needs to be solved first before using this java cleaner


public class GridMemoryCleaner implements IExecutionListener {


    public void onExecutionFinish(){
        CleanJavaTasks();
        ReGenerateJavaAfterClean();
        ReGenerateJavaAfterClean();
    }

    public static void CleanJavaTasks() {
        try {

            TaskCleaner.CleanTasks("java","java.exe");
            ReGenerateJavaAfterClean();

        } catch (Exception e) {
            System.out.println(e.getMessage());}
    }


    public static void ReGenerateJavaAfterClean(){

        System.out.println("Regenerating Main Java.exe");
        System.out.println("Main Java.exe Generated, Rerunning is now valid");

    }



    public static void main(String[] args) {
        CleanJavaTasks();
    }

}
