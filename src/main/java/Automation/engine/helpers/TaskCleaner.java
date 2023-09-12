package Automation.engine.helpers;

public class TaskCleaner {

    public static void CleanTasks(String TaskName , String PID) {
        // PID is case sensitive


        try {
            String TaskListCommand = "tasklist | findstr \"" + TaskName + "\"";
            String TaskKillCommand = "taskkill /F /PID " + PID;
            String CleanMemoryCommand = TaskListCommand + " & " + TaskKillCommand;

            CMDRunner.runCommand(CleanMemoryCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CleanTasks("Runtime Broker"  , "RuntimeBroker.exe");
    }
}