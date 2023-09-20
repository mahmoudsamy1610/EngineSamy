package Automation.engine.reportingWorks;

import Automation.utils.loggers.EngineLogger;
import io.qameta.allure.Allure;

public class AllureStepLogger {
    public static void logStep(String Step) {
        try {
            Allure.step(Step);
        }
        catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed logging this step : " + Step , E);
        }
    }
}
