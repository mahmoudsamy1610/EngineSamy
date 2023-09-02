package Automation.engine.reportingWorks;

import Automation.engine.helpers.DirCreator;
import Automation.engine.helpers.RandomDigitsGenerator;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.setupWorks.CMDRunner;
import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.internal.TestNamesMatcher;

public class AllureReportXmlGenerator extends TestListenerAdapter {

// DEPRICATED !
    // Made many issues with allure reports VS parralel execution results .. overwriting the results of test


/*

    @Override
    public void onFinish(ITestContext testContext) {
        try {

            String AllureSuffix = String.valueOf(RandomDigitsGenerator.GenerateRandomNumber(6));
            String AllureResultPath = PropertyGetter.GetPropertyValue("allure","AllureResultDirectory");
           // String AllureResultDirPath = DirCreator.CreateDir(AllureResultPath , AllureSuffix);
            String AllureReportLPath = PropertyGetter.GetPropertyValue("allure","AllureReportDirectory")+"_"+AllureSuffix;
             String AllureGenerateCommand = PropertyGetter.GetPropertyValue("allure","AllureGenerateCommand");
             String AllureCleanCommand = PropertyGetter.GetPropertyValue("allure","AllureCleanCommand");
             String  AllureReportCommand =  AllureGenerateCommand + " " + AllureResultPath + " " + AllureCleanCommand + " " + AllureReportLPath ;

            CMDRunner.runCommand(AllureReportCommand);
            System.out.println("Test Run is Done and, Allure Report Generated successfully to " + AllureResultPath  + ", Check HTML file in " + AllureReportLPath );

        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while creating allure reports");}
    }



 */

    /*
    @Override
    public void onFinish(ITestContext testContext) {
        try {

            String TestSuffix = String.valueOf(RandomDigitsGenerator.GenerateRandomNumber(5));
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


     */




/*
    public static void GenerateAllureReportFromXml(ITestContext testContext){
        AllureReportXmlGenerator Generator = new AllureReportXmlGenerator();
        Generator.onFinish(testContext);

    }
   */
}




