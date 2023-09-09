package Automation.engine.suiteWorks;

import Automation.engine.helpers.FileNameGetter;
import Automation.engine.xmlWorks.XmlParser;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.List;

public  class SuiteDataGetterByRun implements ITestListener {

    public static ThreadLocal<String> SuiteNameThreadLocal = new ThreadLocal<>();
    public static ThreadLocal<String> TestNameThreadLocal = new ThreadLocal<>();



    @Override
    public void onStart(ITestContext TestContext) {
        SuiteNameThreadLocal.set(TestContext.getSuite().getName());
        TestNameThreadLocal.set(TestContext.getName());


    }


  //  @Override
    public void aonStart(ITestContext TestContext){


    }


    public static String CurrentSuiteName(){

        String  SuiteName = SuiteNameThreadLocal.get();
        System.out.println(SuiteName);
        return SuiteName ;

    }

    public static String CurrentTestName(){
        String  TestName = TestNameThreadLocal.get();
        System.out.println(TestName);
        return TestName ;

    }
}



