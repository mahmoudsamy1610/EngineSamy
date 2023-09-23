package Automation.engine.setupWorks;

import Automation.engine.browserWorks.NodePlatformFactory;
import Automation.engine.gridWorks.NodeCapCoupler;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.utils.suiteWorks.SuiteDataGetterByRun;
import Automation.utils.suiteWorks.SuiteTestCapGetter;
import Automation.utils.xmlWorks.XmlParser;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import java.util.List;

public class ParaGridRunLevel implements ITestListener {


    public static WebDriver SetParaGridRunLevel(){

        String PomRelativePath = PropertyGetter.GetPropertyValue("RunOptions" , "PomRelativePath");
        String ParaLevel = XmlParser.FindXmlTag(PomRelativePath,"parallel");
        WebDriver driver = null;

        EngineLogger.EngineInfo("Deciding Selenium Grid parallel run level : " + ParaLevel);


        if (ParaLevel.equalsIgnoreCase("suites")) {

            String NodePlatformType = null;
            String NodeBrowserType = null;

            try {
                String CurrentSuiteName = SuiteDataGetterByRun.CurrentSuiteName();
                List<String> NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(CurrentSuiteName);
                List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentSuiteName);
                String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
                NodePlatformType = NodeCaps[0][0];
                NodeBrowserType = NodeCaps[0][1];

                driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType, NodeBrowserType);

            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Found an error while receiving inputs deciding grid node caps : "
                        + NodePlatformType + " / " + NodeBrowserType+  " , on Parallel level : " + ParaLevel, E);
            }

        }
        else if (ParaLevel.equalsIgnoreCase("tests") || ParaLevel.equalsIgnoreCase("classes") ) {

            String NodePlatformType = null;
            String NodeBrowserType = null;

            try {
                String CurrentTestName = SuiteDataGetterByRun.CurrentTestName();
                List<String> NodePlatformTypes = SuiteTestCapGetter.CatchPlatforms(CurrentTestName);
                List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentTestName);
                String[][] NodeCaps = NodeCapCoupler.CoupleNodeCap(NodePlatformTypes, NodeBrowserTypes);
                NodePlatformType = NodeCaps[0][0];
                NodeBrowserType = NodeCaps[0][1];

                driver = NodePlatformFactory.SetNodePlatformType(NodePlatformType, NodeBrowserType);

            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Found an error while receiving inputs deciding grid node caps : "
                        + NodePlatformType + " / " + NodeBrowserType + " , on Parallel level : " + ParaLevel, E);
            }

        }
/*
        Should be implemented later [Class scope parallel run]
        Facing issues with Threading

        else if (ParaLevel.equalsIgnoreCase("classes")){

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
            EngineLogger.EngineError("Invalid Parallel level keyword inserted : " + ParaLevel) ;
        }

        return driver ;
    }

    public static void main(String[] args) {
        SetParaGridRunLevel();
    }

    }





