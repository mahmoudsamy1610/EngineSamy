package automation.engine.appDriverWorks;

import automation.engine.gridWorks.HubGridLauncher;
import automation.utils.cmdWorks.CMDRunner;
import automation.utils.loggers.EngineLogger;
import automation.utils.propertyWorks.PropertyGetter;
import lombok.SneakyThrows;
import org.testng.IExecutionListener;

public class AndroidStudioLauncher implements IExecutionListener {

    public static void StartAndroidStudio() throws Exception {

        String AndroidStudioAbsolutePath = PropertyGetter.GetPropertyValue("Appium", "AndroidStudioLocalPath");

        EngineLogger.EngineInfo("------------Starting Android Studio -----------------");

        try {
            Runnable AndroidStudioTask = () -> {
                CMDRunner.runCommand(AndroidStudioAbsolutePath);} ;
            Thread AndroidStudioThread = new Thread(AndroidStudioTask);
            AndroidStudioThread.start();
            Thread.sleep(10000);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while starting android studio " , E );
            throw new Exception();
        }

    }

    public static void StartAndroidSession() throws Exception {

        String EmulatorAbsolutePath = PropertyGetter.GetPropertyValue("Appium", "AndroidEmulatorPath");
        String AvdName = PropertyGetter.GetPropertyValue("Appium", "AndroidAvdName");

        try {
            EngineLogger.EngineInfo("Starting Android Session for :  " + AvdName);


            Runnable LaunchDevice = () -> {
                CMDRunner.runCommand( EmulatorAbsolutePath + " -avd " + AvdName);} ;
            Thread DeviceThread = new Thread(LaunchDevice);
            DeviceThread.start();
            Thread.sleep(10000);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("An error occurred while starting android session for device : " + AvdName , E );
            throw new Exception();
        }

    }

    public static void InstallApp() throws InterruptedException {
        String AppRelativePath = PropertyGetter.GetPropertyValue("Appium" , "AppUnderTestPath" );

        Runnable InstallTask = () -> {
            AppInstaller.InstallApp(AppRelativePath);} ;
        Thread InstallThread = new Thread(InstallTask);
        InstallThread.start();
        Thread.sleep(10000);


    }


    @SneakyThrows
    public void onExecutionStart(){
        EngineLogger.EngineInfo("uploading app from local system director using browser stack upload APIs");
        StartAndroidStudio();
        StartAndroidSession();
        InstallApp();

    }

    public static void main(String[] args) throws Exception {
        StartAndroidStudio();
        StartAndroidSession();
        InstallApp();
    }

}
