package Automation.engine.browserWorks;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class NodePlatformFactory {

    @Parameters(value = {"NodePlatformType", "NodeBrowserType"})
    public static WebDriver SetNodePlatformType(String NodePlatformType, String NodeBrowserType) {


        if (NodePlatformType.equalsIgnoreCase("Windows 10")) {

            WebDriver driver ;
          driver =   NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            return driver;


        } else if (NodePlatformType.equalsIgnoreCase("Windows 11")) {

            WebDriver driver ;
            driver =   NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            return driver;

        } else if (NodePlatformType.equalsIgnoreCase("MacOs")) {

            WebDriver driver ;
            driver =   NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            return driver;

        } else if (NodePlatformType.equalsIgnoreCase("Linux")) {

            WebDriver driver ;
            driver =   NodeBrowserFactory.SetNodeBrowserType(NodePlatformType, NodeBrowserType);
            return driver;

        } else {
            Assert.fail("Invalid Platform selection for this node");
            System.out.println("Invalid Platform selection for this node");
        }

            return null;
    }

}

