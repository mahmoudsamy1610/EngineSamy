package Automation.engine.browserWorks;

import Automation.engine.loggers.Loggers;
import Automation.engine.reportingWorks.AllureStepLogger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class NodePlatformFactory {

    public static WebDriver SetNodePlatformType(String NodePlatformType, String NodeBrowserType  ) {


        if (NodePlatformType.equalsIgnoreCase("Windows 10")) {

            try {
                Loggers.Info("Selected node platform type is found : " + NodePlatformType);

                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);

                return driver;
            }catch (Exception E){
                Loggers.ExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }


        } else if (NodePlatformType.equalsIgnoreCase("Windows 11")) {

            try {
                Loggers.Info("Selected node platform type is found : " + NodePlatformType);

                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                return driver;
            }catch (Exception E) {
                Loggers.ExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }

        } else if (NodePlatformType.equalsIgnoreCase("MacOs")) {

            try {
                Loggers.Info("Selected node platform type is found : " + NodePlatformType);

                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                return driver;
            }catch (Exception E) {
                Loggers.ExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }

        } else if (NodePlatformType.equalsIgnoreCase("Linux")) {

            try {
                Loggers.Info("Selected node platform type is found : " + NodePlatformType);

                WebDriver driver;
                driver = NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                return driver;
            }catch (Exception E) {
                Loggers.ExceptionError("Cannot find a node for selected platform type : " + NodePlatformType , E);
                AllureStepLogger.logStep("Selected node platform type is found : " + NodePlatformType);
                Assert.fail("Cannot find a node for selected platform type : " + NodePlatformType , E);
            }

        } else {
            Loggers.Error("Invalid platform selected : " + NodePlatformType);
            AllureStepLogger.logStep("Selecting node platform " + NodePlatformType);
            Assert.fail("Invalid platform selected : " + NodePlatformType);
        }

            return null;
    }

}

