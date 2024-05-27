package automation.engine.webDriverWorks;

import automation.utils.loggers.EngineLogger;
import automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class NodePlatformFactory {

    public static WebDriver SetNodePlatformType_2(String NodePlatformType, String NodeBrowserType) {
        EngineLogger.EngineInfo("Selected node platform type is found : " + NodePlatformType);
        AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);

        if (NodePlatformType.equalsIgnoreCase("Windows 10")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType, E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType, E);
            }


        } else if (NodePlatformType.equalsIgnoreCase("Windows 11")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType, E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType, E);
            }

        } else if (NodePlatformType.equalsIgnoreCase("MacOs")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType, E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType, E);
            }

        } else if (NodePlatformType.equalsIgnoreCase("Linux")) {

            try {
                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                return driver;

            } catch (Exception E) {
                EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType, E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType, E);
            }

        } else {
            EngineLogger.EngineError("Invalid platform selected : " + NodePlatformType);
            AllureStepLogger.logStep("Selecting node platform " + NodePlatformType);
            Assert.fail("Invalid platform selected : " + NodePlatformType);
        }

        return null;
    }


    public static WebDriver SetNodePlatformType(String NodePlatformType, String NodeBrowserType) {

        try {
            EngineLogger.EngineInfo("Selected node platform type is found : " + NodePlatformType);
            AllureStepLogger.logStep("Selected platform : " + NodePlatformType);


            if (NodePlatformType.equalsIgnoreCase("Windows 10")) {
                return NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            } else if (NodePlatformType.equalsIgnoreCase("Windows 11")) {
                return NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            } else if (NodePlatformType.equalsIgnoreCase("MacOs")) {
                return NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            } else if (NodePlatformType.equalsIgnoreCase("Linux")) {
                return NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            } else {
                EngineLogger.EngineError("Invalid platform selected : " + NodePlatformType);
                throw new IOException();
            }

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Cannot find a node for selected platform type : " + NodePlatformType, E);
            AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
            Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType, E);

            return null;
        }
    }
}
