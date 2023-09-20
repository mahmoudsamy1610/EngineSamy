package Automation.engine.gridWorks;

import Automation.utils.helpers.TaskCleaner;
import Automation.utils.loggers.EngineLogger;
import org.testng.Assert;
import org.testng.IExecutionListener;

//usage is not recommended
// it deletes all java.exe , you will need to reRun any class twice , this needs to be solved first before using this java cleaner


public class GridMemoryCleaner implements IExecutionListener {


    public void onExecutionFinish() {

        try {
            CleanJavaTasks();

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to remove all or one of the background Java tasks" , E );
            Assert.fail("Failed to remove all or one of the background Java tasks" , E );
        }
    }

    public static void CleanJavaTasks() {
        try {

            EngineLogger.EngineInfo("Cleaning all Java tasks in the background");
            TaskCleaner.CleanTasks("java","java.exe");

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Java tasks cleaning from the back ground failed" , E );
            Assert.fail("Java tasks cleaning from the back ground failed" , E );
        }
    }



    public static void main(String[] args) {
        CleanJavaTasks();
    }

}
