package Automation.engine.suiteWorks;

import Automation.engine.helpers.FileNameGetter;
import Automation.engine.xmlWorks.XmlParser;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import java.util.List;

public  class SuiteDataGetterByRun extends TestListenerAdapter {

    public static String SuiteName ;
    public static String SuitePath ;

    @Override
    public void onStart(ITestContext TestContext) {

        SuitePath = TestContext.getSuite().getXmlSuite().getFileName();
        SuiteName = FileNameGetter.GetFileName(SuitePath);
        System.out.println("Suite Name: " + SuiteName);


    }

    /*
    public static String GetSuiteNameByRun(){

        return SuiteName;
    }


     */
    public static String GetSuitePathByRun(){

        return SuitePath;
    }

    public static List<String> GetTestNameByRun() {

        String SuiteRelativePath = GetSuitePathByRun();
       List<String> TestNames = XmlParser.FindXmlData(SuiteRelativePath , "test" , "name");
        return TestNames;
    }

    public static List<String> GetSuiteNameByRun() {

        String SuiteRelativePath = GetSuitePathByRun();
        List<String> SuiteNames = XmlParser.FindXmlData(SuiteRelativePath , "suite" , "name");
        return SuiteNames;
    }


}
