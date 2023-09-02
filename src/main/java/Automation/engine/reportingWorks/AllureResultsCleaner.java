package Automation.engine.reportingWorks;

import Automation.engine.helpers.DirCleaner;
import Automation.engine.propertyWorks.PropertyGetter;

public class AllureResultsCleaner {


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


    public static void main(String[] args) {
        CleanAllurePreviousResults();

    }


    }
