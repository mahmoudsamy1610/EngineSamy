package Automation.engine.reportingWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;

public class AllureReportGenerator {



    public static void GenerateAllureReport() {
        try {

             String AllureResultPath = PropertyGetter.GetPropertyValue("allure","AllureResultDirectory");
             String AllureReportLPath = PropertyGetter.GetPropertyValue("allure","AllureReportDirectory");
             String AllureGenerateCommand = PropertyGetter.GetPropertyValue("allure","AllureGenerateCommand");
             String AllureCleanCommand = PropertyGetter.GetPropertyValue("allure","AllureCleanCommand");
             String  AllureReportCommand =  AllureGenerateCommand + " " + AllureResultPath + " " + AllureCleanCommand + " " + AllureReportLPath ;

            CMDRunner.runCommand(AllureReportCommand);
            System.out.println("Test Run is Done and, Allure Report Generated successfully to " + AllureResultPath  + ", Check HTML file in " + AllureReportLPath );


    } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while creating allure reports");}
        }


    public static void main(String[] args) {
       GenerateAllureReport();
        //System.out.println(AllureReportCommand);
    }



}
