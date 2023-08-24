package Automation.engine.suiteWorks;

import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.reportingworks.TestNgListener;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class SuitePathGetter  {

    public static String GetSuitePathByName (String SuiteName) {

        String SuiteRelativePath = PropertyGetter.GetPropertyValue( "SuitePath" ,SuiteName);

        return SuiteRelativePath ;
    }


}
