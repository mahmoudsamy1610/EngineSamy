package Automation.engine.browserWorks;

import Automation.engine.helpers.TaskCleaner;
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

        } catch (Exception e) {
            System.out.println(e.getMessage());}
    }

    public static void CleanChromeDriverTasks() {
        try {

            TaskCleaner.CleanTasks("chromedriver","chromedriver.exe");

        } catch (Exception e) {
            System.out.println(e.getMessage());}
    }

    public static void CleanGeckoDriverTasks() {
        try {

            TaskCleaner.CleanTasks("geckodriver","geckodriver.exe");

        } catch (Exception e) {
            System.out.println(e.getMessage());}
    }

    public static void CleanEdgeDriverTasks() {
        try {

            TaskCleaner.CleanTasks("msedgedriver","msedgedriver.exe");

        } catch (Exception e) {
            System.out.println(e.getMessage());}
    }


    public static void main(String[] args) {
        CleanAllDriverTasks();
    }

}
