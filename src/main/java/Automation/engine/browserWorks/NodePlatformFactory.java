package Automation.engine.browserWorks;

import Automation.utils.loggers.EngineLogger;
import Automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NodePlatformFactory {

    public static WebDriver SetNodePlatformType(String NodePlatformType, String NodeBrowserType  ) {
        EngineLogger.EngineInfo("Selected node platform type is found : " + NodePlatformType);
        AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);


        if (NodePlatformType.equalsIgnoreCase("Windows 10")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            }catch (Exception E){
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }


        } else if (NodePlatformType.equalsIgnoreCase("Windows 11")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            }catch (Exception E) {
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }

        } else if (NodePlatformType.equalsIgnoreCase("MacOs")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            }catch (Exception E) {
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }

        } else if (NodePlatformType.equalsIgnoreCase("Linux")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            }catch (Exception E) {
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }

        } else {
            EngineLogger.EngineError("Invalid platform selected : " + NodePlatformType);
            AllureStepLogger.logStep("Selecting node platform " + NodePlatformType);
            Assert.fail("Invalid platform selected : " + NodePlatformType);
        }

            return null;
    }

}

