package Automation.engine.reportingWorks;

import io.qameta.allure.Allure;

public class Loggers {
    public static void logStep(String Step) {
        try {
            Allure.step(Step);}
        catch (Exception e) {e.getMessage();
            System.out.println("an Error occurred while logging the step");
        }
    }
}
