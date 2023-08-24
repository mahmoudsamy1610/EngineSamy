package Automation.engine.suiteWorks;

import Automation.engine.xmlWorks.XmlParser;

import java.util.List;

public class SuiteNameGetter {


    public static  List<String> GetSuiteName(String SuiteRelativePath){

       List<String> SuiteName =  XmlParser.FindXmlData(SuiteRelativePath ,"suite" , "name") ;
        return SuiteName ;

    }


    public static void main(String[] args) {
       System.out.println(GetSuiteName("src/test/resources/testSuites/Login2.xml"));
    }



}
