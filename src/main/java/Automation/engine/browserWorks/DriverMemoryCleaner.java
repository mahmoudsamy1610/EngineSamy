package Automation.engine.browserWorks;

import Automation.engine.helpers.TaskCleaner;
import Automation.engine.loggers.Loggers;
import org.testng.IExecutionListener;

public class DriverMemoryCleaner implements IExecutionListener {


    public void onExecutionFinish(){
        CleanAllDriverTasks();
    }

    public static void CleanAllDriverTasks() {
        try {

            CleanChromeDriverTasks();
            CleanGeckoDriverTasks();
            CleanEdgeDriverTasks();
            Loggers.Info("All Web drivers tasks in the background are purged");

        } catch (Exception E) {
            Loggers.ExceptionError("Unknown error while cleaning a specific webdriver task in background" , E);
        }
    }

    public static void CleanChromeDriverTasks() {
        try {

            TaskCleaner.CleanTasks("chromedriver","chromedriver.exe");
            Loggers.Info("Cleaning Chrome webdriver Tasks in the background");

        } catch (Exception E) {
            Loggers.ExceptionError("Unknown error while Chrome webdriver Tasks in the background" , E);
        }
    }

    public static void CleanGeckoDriverTasks() {
        try {

            TaskCleaner.CleanTasks("geckodriver","geckodriver.exe");
            Loggers.Info("Cleaning Gecko webdriver Tasks in the background");

        } catch (Exception E) {
            Loggers.ExceptionError("Unknown error while Gecko webdriver Tasks in the background" , E);
        }
    }

    public static void CleanEdgeDriverTasks() {
        try {

            Loggers.Info("Cleaning Edge webdriver Tasks in the background");

        } catch (Exception E) {
            Loggers.ExceptionError("Unknown error while Edge webdriver Tasks in the background" , E);
        }
    }


    public static void main(String[] args) {
        CleanAllDriverTasks();
    }

}
