package Automation.engine.setupWorks;

import Automation.engine.browserWorks.NodePlatformFactory;
import Automation.engine.gridWorks.NodeCapCoupler;
import Automation.engine.gridWorks.SuiteNodeWrapper;
import Automation.engine.gridWorks.TestNodeWrapper;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuiteTestCapGetter;
import Automation.engine.xmlWorks.XmlParser;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.List;

public class ParaRunSpace implements ITestListener {


    public static WebDriver  SetParaRunType(){

        String PomRelativePath = PropertyGetter.GetPropertyValue("RunOptions" , "PomRelativePath");
        String ParaScope = XmlParser.FindXmlTag(PomRelativePath,"parallel");
        WebDriver driver = null;

        if (ParaScope.equalsIgnoreCase("suites")){

/*
            List<String> NodePlatformTypes = SuiteNodeWrapper.WrapNodeSuitePlatforms();
            List<String> NodeBrowserTypes = SuiteNodeWrapper.WrapNodeSuiteBrowsers();
            String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
            String NodePlatformType = null;
            String NodeBrowserType = null ;

            for (String[] Couple : NodeCaps) {
                NodePlatformType = Couple[0];
                NodeBrowserType = Couple[1];

            }

 */
        String CurrentSuiteName = SuiteDataGetterByRun.CurrentSuiteName();
            List<String> NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(CurrentSuiteName);
            List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentSuiteName);
            String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
           String  NodePlatformType = NodeCaps[0][0];
           String NodeBrowserType = NodeCaps[0][1];


            driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType , NodeBrowserType);




        }else if (ParaScope.equalsIgnoreCase("tests")){

            /*
            List<String> NodePlatformTypes = TestNodeWrapper.WrapNodeTestPlatforms();
            List<String> NodeBrowserTypes = TestNodeWrapper.WrapNodeTestBrowsers();
            String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
            String NodePlatformType = null;
            String NodeBrowserType = null ;

            for (String[] Couple : NodeCaps) {
                NodePlatformType = Couple[0];
                NodeBrowserType = Couple[1];

            }

             */

            String CurrentTestName = SuiteDataGetterByRun.CurrentTestName();
            List<String> NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(CurrentTestName);
            List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentTestName);
            String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
            String  NodePlatformType = NodeCaps[0][0];
            String NodeBrowserType = NodeCaps[0][1];


            driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType , NodeBrowserType);


        }


        return driver ;
    }



}
