package automation.engine.browserWorks;

import automation.utils.loggers.EngineLogger;
import automation.engine.setupWorks.SetupFactory;
import org.openqa.selenium.WebDriver;

public class BrowserRunner {


    public static WebDriver StartBrowser(){

        try {
            EngineLogger.EngineInfo("---------- Preparing WebDiver requirements ------------");
                WebDriver driver;
                driver = SetupFactory.Run();

                    return driver;
                }
                catch (Exception E ){
                    EngineLogger.EngineExceptionError("(unknown) Error while Preparing WebDiver requirements" , E);
                }
        return  null ;
    }


    public static void main(String[] args) {
        StartBrowser();

    }


}
