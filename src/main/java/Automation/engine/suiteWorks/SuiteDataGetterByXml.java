package Automation.engine.suiteWorks;

import Automation.engine.helpers.StringToListJoiner;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.xmlWorks.XmlParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuiteDataGetterByXml {


    public static   List <String> GetSuiteNamesByXmlPath(String XmlRelativePath){

        String SuitesDirPath = PropertyGetter.GetPropertyValue("RunOptions" , "SuitesDirRelativePath");
        List <String> SuiteNamesXml =  XmlParser.FindXmlAttributes(XmlRelativePath ,"suite-file" , "path") ;
        List <String> SuitePaths = StringToListJoiner.JoinStringToList(SuitesDirPath , SuiteNamesXml , "prefix" ) ;
        String SuiteName ;
        List <String> SuiteNames = new ArrayList<>();

        try {
            for (String SuitePath : SuitePaths) {
                SuiteName = GetSuiteNameByPath(SuitePath);
                SuiteNames.add(SuiteName);
            }
        }catch (Exception E){E.printStackTrace();}

        return SuiteNames ;

    }


    public static  String GetSuiteNameByPath(String SuiteRelativePath){

       String SuiteName =  XmlParser.FindXmlAttribute(SuiteRelativePath ,"suite" , "name") ;
        return SuiteName ;

    }

    public static   List <String> GetTestNamesBySuitePath(String SuiteRelativePath){

        List <String> TestName =  XmlParser.FindXmlAttributes(SuiteRelativePath ,"test" , "name") ;
        return TestName ;

    }



    public static  List<String> GetSuiteNamesByPom(String PomRelativePath){

        List<String> SuitePaths =  XmlParser.FindXmlTags(PomRelativePath ,"file") ;
        List <String> SuiteNames = new ArrayList<>();

        for (String SuitePath : SuitePaths) {
           String SuiteName = GetSuiteNameByPath(SuitePath) ;
            SuiteNames.add(SuiteName);
        }
        return SuiteNames ;

    }



    public static  List<String> GetTestNamesByPom(String PomRelativePath){

        List<String> SuitePaths =  XmlParser.FindXmlTags(PomRelativePath ,"file") ;
        List <String> TestNames = new ArrayList<>();

        for (String SuitePath : SuitePaths) {
            List <String> SuiteTestNames = GetTestNamesBySuitePath(SuitePath);
            TestNames.addAll(SuiteTestNames);

        }
        return TestNames ;
    }


    public static  List<String> GetTestNamesByRunXml(String RunXmlRelativePath){

        List<String> SuitePaths =  XmlParser.FindXmlAttributes(RunXmlRelativePath ,"suite-file" , "path") ;
        String TestSuitesRelativePath = PropertyGetter.GetPropertyValue("RunOptions" , "SuitesDirRelativePath");
        List <String> TestNames = new ArrayList<>();

        for (String SuitePath : SuitePaths) {
            List <String> SuiteTestNames = GetTestNamesBySuitePath(TestSuitesRelativePath+SuitePath);
            TestNames.addAll(SuiteTestNames);

        }
        return TestNames ;
    }



    public static void main(String[] args) {
        System.out.println(GetSuiteNamesByXmlPath("src/test/resources/testSuites/Run.xml"));
    }



}
