package automation.engine.webDriverWorks;

import automation.utils.loggers.EngineLogger;
import org.openqa.selenium.WebDriver;

public class WebDriverStarter {


    public static WebDriver StartBrowser(){

        try {
            EngineLogger.EngineInfo("---------- Preparing WebDiver requirements ------------");
                WebDriver driver;
                driver = WebSetupFactory.Run();

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
