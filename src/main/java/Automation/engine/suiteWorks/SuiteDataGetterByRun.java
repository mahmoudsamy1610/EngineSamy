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
    //public static ThreadLocal<String> ClassTestNameThreadLocal = new ThreadLocal<>();




    @Override
    public void onStart(ITestContext TestContext) {
        SuiteNameThreadLocal.set(TestContext.getSuite().getName());
        TestNameThreadLocal.set(TestContext.getName());
       // ClassTestNameThreadLocal.set(TestContext.getClass().getName());

    }


  //  @Override
    public void onTestStart(ITestResult result){

     //   ClassTestNameThreadLocal.set(result.getTestContext().getClass().getName());

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
/*
    is for parallel classes scope and should be implemented later
    public static String CurrentClassTestName(){
        String  ClassTestName = ClassTestNameThreadLocal.get();
        System.out.println(ClassTestName);
        return ClassTestName ;

    }


 */



}



