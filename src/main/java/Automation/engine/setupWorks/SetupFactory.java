package Automation.engine.setupWorks;

import org.openqa.selenium.WebDriver;

public class SetupFactory {


    public static WebDriver Run() {

        return RunSpace.SetRunningType();
    }


    public static void main(String[] args) {
        Run();
    }

}
