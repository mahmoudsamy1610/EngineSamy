package Automation.engine.setupWorks;

import Automation.engine.browserWorks.NodePlatformFactory;
import Automation.engine.gridWorks.NodeCapCoupler;
import Automation.engine.propertyWorks.PropertyGetter;
import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuiteTestCapGetter;
import Automation.engine.xmlWorks.XmlParser;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import java.util.List;

public class ParaGridRunScope implements ITestListener {


    public static WebDriver SetParaGridRunScope(){

        String PomRelativePath = PropertyGetter.GetPropertyValue("RunOptions" , "PomRelativePath");
        String ParaScope = XmlParser.FindXmlTag(PomRelativePath,"parallel");
        WebDriver driver = null;

        if (ParaScope.equalsIgnoreCase("suites")){

        String CurrentSuiteName = SuiteDataGetterByRun.CurrentSuiteName();
            List<String> NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(CurrentSuiteName);
            List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentSuiteName);
            String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
           String  NodePlatformType = NodeCaps[0][0];
           String NodeBrowserType = NodeCaps[0][1];

            driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType , NodeBrowserType);

        }
        else if (ParaScope.equalsIgnoreCase("tests") || ParaScope.equalsIgnoreCase("classes") ){

            String CurrentTestName = SuiteDataGetterByRun.CurrentTestName();
            List<String> NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(CurrentTestName);
            List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentTestName);
            String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
            String  NodePlatformType = NodeCaps[0][0];
            String NodeBrowserType = NodeCaps[0][1];

            driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType , NodeBrowserType);

        }
/*
        Should be implemented later

        else if (ParaScope.equalsIgnoreCase("classes")){

            String CurrentTestName = SuiteDataGetterByRun.CurrentTestName();
            List<String> NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(CurrentTestName);
            List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentTestName);
            String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
            String  NodePlatformType = NodeCaps[0][0];
            String NodeBrowserType = NodeCaps[0][1];

            driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType , NodeBrowserType);

        }
 */
        else {
            System.out.println("Invalid parallel Grid test scope provided");
        }

        return driver ;
    }


    }





