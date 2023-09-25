package Automation.engine.reportingWorks;

import Automation.utils.helpers.DirCleaner;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import org.testng.IExecutionListener;

public class AllureResultsCleaner implements IExecutionListener {


    public static void CleanAllurePreviousResults() {

        String AllureResultPath = PropertyGetter.GetPropertyValue("allure","AllureResultDirectory");
        String AllureReportLPath = PropertyGetter.GetPropertyValue("allure","AllureReportDirectory");

        EngineLogger.EngineInfo("Cleaning previous Allure results at :  " + AllureResultPath);
        EngineLogger.EngineInfo("Cleaning previous Allure reports at :  " + AllureReportLPath);

        try {
            DirCleaner.CleanDir(AllureResultPath);
            DirCleaner.CleanDir(AllureReportLPath);

        } catch (Exception E){
            EngineLogger.EngineExceptionError("Failed cleaning Allure results or Allure reports " , E);
        }
        }


    public void onExecutionStart(){
        CleanAllurePreviousResults();
        EngineLogger.EngineInfo("Allure previous reports/results cleaned successfully ");
    }


    }
