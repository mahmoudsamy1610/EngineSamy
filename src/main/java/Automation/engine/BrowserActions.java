package Automation.engine;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserActions {

    // test 1 changeaaa

    public static  WebDriver driver;
    // these variables are set in the properties file and in configuration
    public static boolean MaxWindow = Boolean.parseBoolean(GetProperty.GetPropertyValue("RunOptions","Maximize"));
    public static int WindowWidth = Integer.parseInt(GetProperty.GetPropertyValue("RunOptions","width"));
    public static int WindowHeight = Integer.parseInt(GetProperty.GetPropertyValue("RunOptions","height"));
    public static String  BrowserType = GetProperty.GetPropertyValue("RunOptions","BrowserType");
    public static String  ExecutionType = GetProperty.GetPropertyValue("RunOptions","ExecutionType");



    public static WebDriver StartBrowser(){


            try {
                WebDriver driver;
             driver = SetupFactory.Run(BrowserType , ExecutionType);
             Logger.logStep("Open " + BrowserType + " Browser");
             return driver;
                }
                catch (Exception e ){
                    Logger.logStep("Open browser");
                    Assert.fail("(unknown) Error while opening " + BrowserType + " browser");
                    System.out.println("(unknown) Error while opening " + BrowserType + " browser");

                }
        return  null ;
    }



    //Method to navigate to specific URL
    public static void goToUrl(WebDriver driver, String url , String PageName){
        try {
            driver.get(url);
            Logger.logStep("Go to " + PageName + " page" );
        }
        catch (TimeoutException toe) {
                 Logger.logStep("Go to " + PageName + " page" );
                 Assert.fail("(TimeOut) Error while navigating to " + PageName + " page");
                System.out.println("(TimeOut) Error while navigating to " + PageName + " page");

        }
        catch (Exception e){
            Logger.logStep("Go to " + PageName + " page" );
            Assert.fail("(unknown) Error while navigating to " + PageName + " page");
            System.out.println("(unknown) Error while navigating to " + PageName + " page");

        }
    }

    //Method to size the browser window
    public static void SetWindowSize(WebDriver driver) {

        if (MaxWindow == true ){
            try{
                driver.manage().window().maximize();
                Logger.logStep("Maximize browser window");
            }
            catch (Exception e){
                Logger.logStep("Maximize browser window");
                Assert.fail("unknown Error while maximizing browser window");
                System.out.println("unknown Error while maximizing browser window");
            }

        }else {
           try {
               Dimension dimension = new Dimension(WindowWidth, WindowHeight );
                driver.manage().window().setSize(dimension);
                Logger.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight );
           }
           catch (Exception e){
               Logger.logStep("Set windows size to Width = " + WindowWidth + " and,  Height = " +  WindowHeight);
               Assert.fail("unknown Error while controlling browser window dimensions");
               System.out.println("unknown Error while controlling browser window dimensions");
           }

        }

        }
    public static void Shutdown(WebDriver driver){
        try {
            Logger.logStep("Close " + BrowserType + " Browser");
            driver.close();
        }
        catch (Exception e) {
          Logger.logStep("Close " + BrowserType + " Browser");
          Assert.fail("Unknown Error while closing " + BrowserType + " browser");
          System.out.println("Unknown Error while closing " + BrowserType + " browser");}
         }


    }


