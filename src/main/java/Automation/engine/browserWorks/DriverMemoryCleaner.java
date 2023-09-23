package Automation.engine.browserWorks;

import Automation.utils.helpers.TaskCleaner;
import Automation.utils.loggers.EngineLogger;
import org.testng.IExecutionListener;

public class DriverMemoryCleaner implements IExecutionListener {


    public void onExecutionFinish(){
        CleanAllDriverTasks();
    }

    public static void CleanAllDriverTasks() {
        EngineLogger.EngineInfo("All Web drivers tasks in the background are purged");

        try {
            CleanChromeDriverTasks();
            CleanGeckoDriverTasks();
            CleanEdgeDriverTasks();

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Unknown error while cleaning a specific webdriver task in background" , E);
        }
    }

    public static void CleanChromeDriverTasks() {
        EngineLogger.EngineInfo("Cleaning Chrome webdriver Tasks in the background");

        try {
            TaskCleaner.CleanTasks("chromedriver","chromedriver.exe");
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Unknown error while Chrome webdriver Tasks in the background" , E);
        }
    }

    public static void CleanGeckoDriverTasks() {
        EngineLogger.EngineInfo("Cleaning Gecko webdriver Tasks in the background");

        try {
            TaskCleaner.CleanTasks("geckodriver","geckodriver.exe");
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Unknown error while Gecko webdriver Tasks in the background" , E);
        }
    }

    public static void CleanEdgeDriverTasks() {
        EngineLogger.EngineInfo("Cleaning Edge webdriver Tasks in the background");

        try {
            TaskCleaner.CleanTasks("msedgedriver","msedgedriver.exe");

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Unknown error while Edge webdriver Tasks in the background" , E);
        }
    }


    public static void main(String[] args) {
        CleanAllDriverTasks();
    }

}
