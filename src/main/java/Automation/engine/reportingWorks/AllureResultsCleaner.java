package Automation.engine.reportingWorks;

import Automation.engine.helpers.DirCleaner;
import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.IExecutionListener;

public class AllureResultsCleaner implements IExecutionListener {


    public static void CleanAllurePreviousResults() {

        String AllureResultPath = PropertyGetter.GetPropertyValue("allure","AllureResultDirectory");
        String AllureReportLPath = PropertyGetter.GetPropertyValue("allure","AllureReportDirectory");


        try {
               DirCleaner.CleanDir(AllureResultPath);
                 EngineLogger.EngineInfo("Cleaning previous Allure results at :  " + AllureResultPath);
               DirCleaner.CleanDir(AllureReportLPath);
                 EngineLogger.EngineInfo("Cleaning previous Allure reports at :  " + AllureReportLPath);

        } catch (Exception E){
            EngineLogger.EngineExceptionError("Failed cleaning Allure results or Allure reports " , E);
        }
        }


    public void onExecutionStart(){
        CleanAllurePreviousResults();
        EngineLogger.EngineInfo("Allure previous reports/results cleaned successfully ");
    }


    }
