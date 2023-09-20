package Automation.engine.suiteWorks;

import Automation.engine.helpers.StringToListJoiner;
import Automation.engine.loggers.EngineLogger;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.xmlWorks.XmlParser;

import java.util.ArrayList;
import java.util.List;

public class SuiteDataGetterByXml {


    public static   List <String> GetSuiteNamesByXmlPath(String XmlRelativePath){
        EngineLogger.EngineInfo("Getting list of suite names from xml file path : " + XmlRelativePath);

        List <String> SuiteNames = new ArrayList<>();

        try {

            String SuitesDirPath = PropertyGetter.GetPropertyValue("RunOptions" , "SuitesDirRelativePath");
            List <String> SuiteNamesXml =  XmlParser.FindXmlAttributes(XmlRelativePath ,"suite-file" , "path") ;
            List <String> SuitePaths = StringToListJoiner.JoinStringToList(SuitesDirPath , SuiteNamesXml , "prefix" ) ;
            String SuiteName ;

            for (String SuitePath : SuitePaths) {
                SuiteName = GetSuiteNameBySuitePath(SuitePath);
                SuiteNames.add(SuiteName);
            }
        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to get list of suite names from xml file path : " + XmlRelativePath , E);
        }

        return SuiteNames ;
    }

    public static  List<String> GetTestNamesByXmlPath(String RunXmlRelativePath) {
        EngineLogger.EngineInfo("Getting list of suite names from xml file path : " + RunXmlRelativePath);

        List<String> TestNames = new ArrayList<>() ;

        try {
            List<String> SuitePaths = XmlParser.FindXmlAttributes(RunXmlRelativePath, "suite-file", "path");
            String TestSuitesRelativePath = PropertyGetter.GetPropertyValue("RunOptions", "SuitesDirRelativePath");
            TestNames = new ArrayList<>();

            for (String SuitePath : SuitePaths) {
                List<String> SuiteTestNames = GetTestNamesBySuitePath(TestSuitesRelativePath + SuitePath);
                TestNames.addAll(SuiteTestNames);

            }
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to get list of test names from xml file path : " + RunXmlRelativePath , E);
        }
        return TestNames;
    }


    public static  String GetSuiteNameBySuitePath(String SuiteRelativePath) {
        EngineLogger.EngineInfo("Getting suite single name from suite path : " + SuiteRelativePath);

        String SuiteName = null;

        try {
            SuiteName = XmlParser.FindXmlAttribute(SuiteRelativePath, "suite", "name");
        } catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to Get suite single name from suite path : " + SuiteRelativePath , E);
        }
        return SuiteName;

    }

    public static   List <String> GetTestNamesBySuitePath(String SuiteRelativePath) {
        EngineLogger.EngineInfo("Getting test list of  names from suite path : " + SuiteRelativePath);

        List<String> TestName = new ArrayList<>();
        try {
            TestName = XmlParser.FindXmlAttributes(SuiteRelativePath, "test", "name");
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to get test list of names from suite path : " + SuiteRelativePath, E);
        }
        return TestName;
    }



    public static void main(String[] args) {
        System.out.println(GetSuiteNamesByXmlPath("src/test/resources/testSuites/Run1.xml"));
        System.out.println(GetTestNamesByXmlPath("src/test/resources/testSuites/Run1.xml"));

    }



}
