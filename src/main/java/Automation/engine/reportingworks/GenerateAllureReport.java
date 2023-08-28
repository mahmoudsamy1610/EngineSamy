package Automation.engine.reportingworks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;

public class GenerateAllureReport {

    static String AllureResultPath = PropertyGetter.GetPropertyValue("allure","AllureResultDirectory");
    static  String AllureReportLPath = PropertyGetter.GetPropertyValue("allure","AllureReportDirectory");
    static  String AllureGenerateCommand = PropertyGetter.GetPropertyValue("allure","AllureGenerateCommand");
    static  String AllureCleanCommand = PropertyGetter.GetPropertyValue("allure","AllureCleanCommand");
    static String  AllureReportCommand =  AllureGenerateCommand + " " + AllureResultPath + " " + AllureCleanCommand + " " + AllureReportLPath ;



    public static void GenerateAllureReport() {
        try {
             AllureResultsCleaner.CleanAllurePreviousResults(AllureResultPath);
            CMDRunner.runCommand(AllureReportCommand);
            System.out.println("Test Run is Done and, Allure Report Generated successfully to " + AllureResultPath  + ", Check HTML file in " + AllureReportLPath );


    } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing CMD command from properties");}
        }

}
