package automation.engine.appDriverWorks;

import automation.utils.cmdWorks.CMDRunner;
import automation.utils.loggers.EngineLogger;

public class AppInstaller {

    public static void InstallApp(String AppRelativePath){

        EngineLogger.EngineInfo("Installing app to android studio session from path : " + AppRelativePath);

        try{

            CMDRunner.runCommand("adb install " + AppRelativePath );

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Error occured while installing app to android studio" , E);

        }

    }

    public static void main(String[] args) {
        InstallApp("src/main/resources/automationResources/apks/ApiDemos-debug.apk");
    }

}
