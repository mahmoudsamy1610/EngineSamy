package Automation.engine.suiteWorks;

import Automation.engine.xmlWorks.XmlParser;

public class SuiteNameGetter {

    public static String GetSuiteName(String SuiteRelativePath){

       String SuiteName =  XmlParser.FindXmlData(SuiteRelativePath ,"suite" , "name") ;
        return SuiteName ;

    }


    public static void main(String[] args) {
       System.out.println(GetSuiteName("src/test/resources/testSuites/Login2.xml"));
    }

}
