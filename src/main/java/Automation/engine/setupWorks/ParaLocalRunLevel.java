package Automation.engine.setupWorks;

import Automation.engine.browserWorks.BrowserFactory;
import Automation.engine.config.ConfigFilePath;
import Automation.utils.loggers.EngineLogger;
import Automation.utils.propertyWorks.PropertyGetter;
import Automation.engine.suiteWorks.SuiteDataGetterByRun;
import Automation.engine.suiteWorks.SuiteTestCapGetter;
import Automation.utils.xmlWorks.XmlTagValueGetter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import java.io.IOException;
import java.util.List;

public class ParaLocalRunLevel implements ITestListener {


    public static WebDriver SetParaLocalRunLevel() throws IOException {

        String PomRelativePath = PropertyGetter.GetPropertyValue("EngineData", "PomRelativePath");
      //  String XmlRunConfigFile = PropertyGetter.GetPropertyValue("RunOptions" , "ConfigXmlFile");
       // String XmlRunConfigDir = PropertyGetter.GetPropertyValue("RunOptions" , "RunXmlDirPath");
        String RunConfigFilePath = ConfigFilePath.GetConfigFilePath();
        String ParaLevel = XmlTagValueGetter.GetAdjacentXmlTagValue(PomRelativePath,"profile" , "file" , RunConfigFilePath , "parallel");
        WebDriver driver = null;

        EngineLogger.EngineInfo("Deciding local parallel run level : " + ParaLevel);


        if (ParaLevel.equalsIgnoreCase("suites")) {

            String NodeBrowserType = null;

            try {
                String CurrentSuiteName = SuiteDataGetterByRun.CurrentSuiteName();
                List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentSuiteName);
                NodeBrowserType = NodeBrowserTypes.get(0);

                driver = BrowserFactory.SetBrowserType(NodeBrowserType);
            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Found an error while receiving inputs deciding browser : "
                        + NodeBrowserType + " , on local Parallel level : " + ParaLevel, E);
            }
        }
        else if (ParaLevel.equalsIgnoreCase("tests") || ParaLevel.equalsIgnoreCase("classes") ) {

            String NodeBrowserType = null;

            try {
                String CurrentTestName = SuiteDataGetterByRun.CurrentTestName();
                List<String> NodeBrowserTypes = SuiteTestCapGetter.CatchBrowsers(CurrentTestName);
                NodeBrowserType = NodeBrowserTypes.get(0);

                driver = BrowserFactory.SetBrowserType(NodeBrowserType);
            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Found an error while receiving inputs deciding browser : "
                        + NodeBrowserType + " , on local Parallel level : " + ParaLevel, E);
            }
        }
/*
        Should be implemented later

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
            throw new IOException();
        }

        return driver ;
    }

    public static void main(String[] args) {
        try {
            SetParaLocalRunLevel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }





