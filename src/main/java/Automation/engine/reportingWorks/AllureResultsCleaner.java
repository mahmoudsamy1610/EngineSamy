package Automation.engine.reportingWorks;

import Automation.engine.helpers.DirCleaner;
import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.IExecutionListener;

public class AllureResultsCleaner implements IExecutionListener {


    public static void CleanAllurePreviousResults() {

        String AllureResultPath = PropertyGetter.GetPropertyValue("allure","AllureResultDirectory");
        String AllureReportLPath = PropertyGetter.GetPropertyValue("allure","AllureReportDirectory");

        try {
               DirCleaner.CleanDir(AllureResultPath);
              System.out.println("Previous Results Cleaned" );
               DirCleaner.CleanDir(AllureReportLPath);
              System.out.println("Previous Reports Cleaned" );

        } catch (Exception E){E.getMessage();}
        }


    public void onExecutionStart(){
        CleanAllurePreviousResults();
    }


    public static void main(String[] args) {
        CleanAllurePreviousResults();

    }


    }
