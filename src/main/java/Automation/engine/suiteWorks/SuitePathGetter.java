package Automation.engine.suiteWorks;

import Automation.engine.propertyWorks.PropertyGetter;

public class SuitePathGetter  {

    public static String GetSuitePathByName (String SuiteName) {

        String SuiteRelativePath = PropertyGetter.GetPropertyValue( "SuitePath" ,SuiteName);

        return SuiteRelativePath ;
    }


}
