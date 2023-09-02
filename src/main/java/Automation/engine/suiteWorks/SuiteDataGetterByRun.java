package Automation.engine.suiteWorks;

import Automation.engine.helpers.FileNameGetter;
import Automation.engine.xmlWorks.XmlParser;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import java.util.List;

public  class SuiteDataGetterByRun extends TestListenerAdapter {

    public static String SuiteName ;
    public static String SuitePath ;
    public static String CurrentTestName;

    @Override
    public void onStart(ITestContext TestContext) {

        SuitePath = TestContext.getSuite().getXmlSuite().getFileName();
        SuiteName = FileNameGetter.GetFileName(SuitePath);
        System.out.println("Running Suite : " + SuiteName);
        CurrentTestName = TestContext.getCurrentXmlTest().getName();
        System.out.println("Running Test : " + CurrentTestName);

    }



    public static String GetSuitePathByRun(){
        return SuitePath;
    }

    public static String GetCurrentTestNameByRun(){
        return CurrentTestName;
    }


    public static List<String> GetTestNamesByRun() {

        String SuiteRelativePath = GetSuitePathByRun();
       List<String> TestNames = XmlParser.FindXmlAttributes(SuiteRelativePath , "test" , "name");
        return TestNames;
    }

    public static List<String> GetSuiteNamesByRun() {

        String SuiteRelativePath = GetSuitePathByRun();
        List<String> SuiteNames = XmlParser.FindXmlAttributes(SuiteRelativePath , "suite" , "name");
        return SuiteNames;
    }


    /*
      @Override
    public void onStart(ITestContext Context) {
          CurrentTestName = Context.getCurrentXmlTest().getName();
        System.out.println("Test Name: " + CurrentTestName);

    }

    public static String GetAllureTestNameByRun(){

        return CurrentTestName ;
    }

     */

}
