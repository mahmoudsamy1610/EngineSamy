package Automation.engine.reportingWorks;

import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.helpers.CMDRunner;
import org.testng.IExecutionListener;

public class AllureReportGenerator implements IExecutionListener {


    public void onExecutionFinish(){
        GenerateAllureReport();
        EngineLogger.EngineInfo("Allure report generated successfully ");
    }


    public static void GenerateAllureReport() {

        String AllureReportLPath = null;

        try {
            String AllureResultPath = PropertyGetter.GetPropertyValue("allure", "AllureResultDirectory");
            AllureReportLPath = PropertyGetter.GetPropertyValue("allure", "AllureReportDirectory");
            String AllureGenerateCommand = PropertyGetter.GetPropertyValue("allure", "AllureGenerateCommand");
            String AllureCleanCommand = PropertyGetter.GetPropertyValue("allure", "AllureCleanCommand");
            String AllureReportCommand = AllureGenerateCommand + " " + AllureResultPath + " " + AllureCleanCommand + " " + AllureReportLPath;
            CMDRunner.runCommand(AllureReportCommand);

            EngineLogger.EngineInfo("Generating Allure Report at : " + AllureReportLPath);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Generating Allure Report at : " + AllureReportLPath, E);

        }
    }


}
