package automation.engine.reportingWorks;

import automation.utils.loggers.EngineLogger;
import org.testng.IExecutionListener;

public class AllureReportGenerator implements IExecutionListener {


    public void onExecutionFinish(){
        GenerateAllureReport();
        EngineLogger.EngineInfo("Allure report generated successfully ");
    }


    public static void GenerateAllureReport() {


        try {
            EngineLogger.EngineInfo("------------------Generating Allure Report----------------");
            AllureCmdCommander.GenerateAllureCommander();


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Generating Allure Report", E);

        }
    }

    public static void main(String[] args) {
        GenerateAllureReport();
    }


}
