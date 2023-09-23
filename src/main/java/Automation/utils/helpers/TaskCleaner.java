package Automation.utils.helpers;

import Automation.utils.loggers.JavaLogger;

public class TaskCleaner {

    public static void CleanTasks(String TaskName , String PID) {
        // PID is case-sensitive
        JavaLogger.JavaInfo("Cleaning background tasks of : " + TaskName);

        try {
            String TaskListCommand = "tasklist | findstr \"" + TaskName + "\"";
            String TaskKillCommand = "taskkill /F /PID " + PID;
            String CleanMemoryCommand = TaskListCommand + " & " + TaskKillCommand;

            CMDRunner.runCommand(CleanMemoryCommand);

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed cleaning background tasks of : " + TaskName + " , and PID : " + PID, E);
        }
    }


    public static void main(String[] args) {
        CleanTasks("Runtime Broaker"  , "RuntimeBroker.exe");
    }
}