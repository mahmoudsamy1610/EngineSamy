package Automation.engine.reportingWorks;

import Automation.utils.helpers.CMDRunner;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;

public class AllureCmdCommander {

    public static void GenerateAllureCommander(){

        String AllureReportLPath = null;

        try {
            String AllureResultPath = PropertyGetter.GetPropertyValue("allure", "AllureResultDirectory");
            AllureReportLPath = PropertyGetter.GetPropertyValue("allure", "AllureReportDirectory");
            String AllureGenerateCommand = PropertyGetter.GetPropertyValue("allure", "AllureGenerateCommand");
            String AllureCleanCommand = PropertyGetter.GetPropertyValue("allure", "AllureCleanCommand");
            String AllureReportCommand = AllureGenerateCommand + " " + AllureResultPath + " " + AllureCleanCommand + " " + AllureReportLPath;
            CMDRunner.runCommand(AllureReportCommand);

            EngineLogger.EngineInfo("Running CMD command to generate Allure Report at : " + AllureReportLPath);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed running CMD command to Generate Allure Report at : " + AllureReportLPath, E);

        }
    }

}
