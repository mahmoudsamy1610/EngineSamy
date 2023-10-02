package Automation.engine.suiteWorks;

import Automation.utils.helpers.StringPicker;
import Automation.utils.helpers.StringToListJoiner;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.xmlWorks.XmlAttValueGetter;

import java.util.ArrayList;
import java.util.List;

public class SuiteDataGetterByXml {


    public static   List <String> GetSuiteNamesByXmlPath(String XmlRelativePath){
        EngineLogger.EngineInfo("Getting list of suite names from xml file path : " + XmlRelativePath);

        List <String> SuiteNames = new ArrayList<>();

        try {

            String SuitesDirPath = PropertyGetter.GetPropertyValue("EngineData", "SuitesDirRelativePath");
            List <String> SuiteNamesXml =  XmlAttValueGetter.FindXmlAttributeValues(XmlRelativePath ,"suite-file" , "path") ;
            List <String> SuiteNamesXmlRefined = StringPicker.ExtractStringsOfVariableLength(SuiteNamesXml , 2 );
            List <String> SuitePaths = StringToListJoiner.JoinStringToList(SuitesDirPath , SuiteNamesXmlRefined , "prefix" ) ;
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
            List<String> SuitePaths = XmlAttValueGetter.FindXmlAttributeValues(RunXmlRelativePath, "suite-file", "path");
            List <String> TestSuiteNamesXmlRefined = StringPicker.ExtractStringsOfVariableLength(SuitePaths , 2 );
            String TestSuitesRelativePath = PropertyGetter.GetPropertyValue("EngineData", "SuitesDirRelativePath");

            TestNames = new ArrayList<>();

            for (String SuitePath : TestSuiteNamesXmlRefined) {
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
            SuiteName = XmlAttValueGetter.FindXmlAttributeValue(SuiteRelativePath, "suite", "name");
        } catch (Exception E){
            EngineLogger.EngineExceptionError("Failed to Get suite single name from suite path : " + SuiteRelativePath , E);
        }
        return SuiteName;

    }

    public static   List <String> GetTestNamesBySuitePath(String SuiteRelativePath) {
        EngineLogger.EngineInfo("Getting test list of  names from suite path : " + SuiteRelativePath);

        List<String> TestName = new ArrayList<>();
        try {
            TestName = XmlAttValueGetter.FindXmlAttributeValues(SuiteRelativePath, "test", "name");
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to get test list of names from suite path : " + SuiteRelativePath, E);
        }
        return TestName;
    }



    public static void main(String[] args) {
     //   System.out.println(GetSuiteNamesByXmlPath("src/test/resources/testSuites/Run1.xml"));
        System.out.println(GetTestNamesByXmlPath("src/test/resources/runFiles/Run.xml"));

    }



}
