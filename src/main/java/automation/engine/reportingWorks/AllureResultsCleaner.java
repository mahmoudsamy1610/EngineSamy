package automation.engine.reportingWorks;

import automation.utils.helpers.DirCleaner;
import automation.utils.loggers.EngineLogger;
import automation.utils.propertyWorks.PropertyGetter;
import org.testng.IExecutionListener;

public class AllureResultsCleaner implements IExecutionListener {


    public static void CleanAllurePreviousResults() {

        String AllureResultPath = PropertyGetter.GetPropertyValue("Allure","AllureResultDirectory");
        String AllureReportLPath = PropertyGetter.GetPropertyValue("Allure","AllureReportDirectory");

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

    public static void main(String[] args) {
        CleanAllurePreviousResults();
    }

    }
