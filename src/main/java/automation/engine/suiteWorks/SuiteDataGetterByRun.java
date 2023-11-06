package automation.engine.suiteWorks;

import automation.utils.loggers.EngineLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;

public  class SuiteDataGetterByRun implements ITestListener {

    public static ThreadLocal<String> SuiteNameThreadLocal = new ThreadLocal<>();
    public static ThreadLocal<String> TestNameThreadLocal = new ThreadLocal<>();
    //public static ThreadLocal<String> ClassTestNameThreadLocal = new ThreadLocal<>();



    @Override
    public void onStart(ITestContext TestContext) {
        EngineLogger.EngineInfo("Creating separate thread for listing <Tests> and <Suites> names");

            SuiteNameThreadLocal.set(TestContext.getSuite().getName());
            TestNameThreadLocal.set(TestContext.getName());
            // ClassTestNameThreadLocal.set(TestContext.getClass().getName());

    }



    public static String CurrentSuiteName() {
        EngineLogger.EngineInfo("Fetching list of values of <Suites> names by Xml run context");

        String SuiteName = null;

        try {
            SuiteName = SuiteNameThreadLocal.get();

            if (SuiteName != null) {
                System.out.println("Current running suite : " +SuiteName);
            }
            else {
                EngineLogger.EngineError("Cannot find any value for <Suite> name by running");
                }

        } catch (Exception E) {
           EngineLogger.EngineExceptionError("Cannot find any value for <Suite> name by running " , E);
        }
        return SuiteName;
    }

    public static String CurrentTestName() {
        EngineLogger.EngineInfo("Fetching list of values of <Tests> names  by Xml run context");

        String TestName = null;
        try {
            TestName = TestNameThreadLocal.get();
            if (TestName != null) {
                System.out.println(TestName);
            } else {
                EngineLogger.EngineError("Cannot find any value for <Test> name by running");
            }
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Cannot find any value for <Test> name by running " , E);
        }
        return TestName;
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



