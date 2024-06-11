package automation.engine.appDriverWorks;

import automation.engine.apiWorks.Post;
import automation.utils.fileWorks.YamlFileReader;
import automation.utils.loggers.EngineLogger;
import automation.utils.propertyWorks.PropertyGetter;
import io.restassured.response.Response;
import org.testng.IExecutionListener;

import static io.restassured.RestAssured.given;

public class AppBrowserStackUploader  implements IExecutionListener {

    public static String UploadAppBrowserStack(String LocalFilePath) {

        String BStackUserName = YamlFileReader.ReadFromYamlFile ("appBrowserStack.yml" , "userName");
        String BStackAccessKey = YamlFileReader.ReadFromYamlFile ("appBrowserStack.yml" , "accessKey");
        String BStackUploadUrl = PropertyGetter.GetPropertyValue("Appium", "AppiumAppUploadPath");

        EngineLogger.EngineInfo("Calling browser stack POST api to upload app from path : " + LocalFilePath);

        Response response = Post.PostFileCurlRequest(BStackUploadUrl, LocalFilePath, BStackUserName, BStackAccessKey, "Upload app to browser stack");

        String AppUrl = null;

        try {

            if (response.statusCode() == 200) {
                AppUrl = response.toString();
                EngineLogger.EngineInfo("App uploaded successfully and response URL is : " + AppUrl);
            } else {
                throw new NullPointerException();
            }

        } catch (Exception E) {
            EngineLogger.EngineExceptionError(" Failed to call browser stack POST api to upload app from path : " + LocalFilePath, E);
        }
        return AppUrl;
    }


    public void onExecutionStart(){
        PropertyGetter.GetPropertyValue("Appium", "AppUnderTestPath");
        UploadAppBrowserStack("src/main/resources/automationResources/apks/ApiDemos-debug.apk");
        EngineLogger.EngineInfo("uploading app from local system director using browser stack upload APIs");
    }




    public static void main(String[] args) {
        UploadAppBrowserStack("src/main/resources/automationResources/apks/ApiDemos-debug.apk");

    }








}
