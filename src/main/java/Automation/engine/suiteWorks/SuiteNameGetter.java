package Automation.engine.suiteWorks;

import Automation.engine.xmlWorks.XmlParser;

public class SuiteNameGetter {

    public static String GetSuiteName(String SuiteRelativePath , String TagName , String AttName){

       String SuiteName =  XmlParser.FindXmlData(SuiteRelativePath , TagName , AttName) ;
        return SuiteName ;

    }


    public static void main(String[] args) {
       System.out.println(GetSuiteName("src/test/resources/testSuites/Login2.xml" , "suite" , "name"));
    }

}
