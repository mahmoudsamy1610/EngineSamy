package automation.engine.apiWorks;

import automation.engine.reportingWorks.AllureStepLogger;
import automation.utils.loggers.EngineLogger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;


public class Post {

    public static Response PostAnonymousRequest(String Route, Object object , String RequestName) {
        EngineLogger.EngineInfo("Firing request POST at route : " + Route);
        AllureStepLogger.logStep("Request : " + RequestName+ " , on : " +Route);

        Response response = null;

        try {
            RequestSpecification specs = RequestSpecs.GetRequestSpecs();
            response = given().spec(specs).body(object).when().post(Route)
                    .then().log().all().extract().response();
        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Firing request POST at route : " + Route, E);
            AllureStepLogger.logStep("Request : " + RequestName+ " , on : " +Route);
            Assert.fail("Failed to Request : " + RequestName+ " , on : " +Route  , E);
        }
        return response;
    }

    public static Response PostRequest(String Route, String AuthToken , Object object, String RequestName){
        EngineLogger.EngineInfo("Firing request POST at route : " + Route);
        AllureStepLogger.logStep("Request : " + RequestName+ " , on : " +Route);
        Response response = null;

        try {
            RequestSpecification specs = RequestSpecs.GetRequestSpecs();
             response = given().spec(specs).body(object).auth().oauth2(AuthToken).when().post(Route)
                    .then().log().all().extract().response();

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed Firing request POST at route : " + Route, E);
            AllureStepLogger.logStep("Request : " + RequestName+ " , on : " +Route);
            Assert.fail("Failed to Request : " + RequestName+ " , on : " +Route  , E);
        }
        return response;
    }


    public static Response PostFileCurlRequest(String Route, String RelativeFilePath , String UserName , String AccessKey , String RequestName){

        EngineLogger.EngineInfo("Firing request POST at route : " + Route);
        Response response = null;
        File appFile = new File(RelativeFilePath);

        try {
            RequestSpecification specs = RestAssured.given(); //here we got rid of the main request specs that inherits the domain of business
            response = given().spec(specs).multiPart("file", appFile).auth().preemptive().basic(UserName, AccessKey).when().post(Route)
                    .then().log().all().extract().response();

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed Firing request POST at route : " + Route, E);
            AllureStepLogger.logStep("Request : " + RequestName+ " , on : " +Route);
            Assert.fail("Failed to Request : " + RequestName+ " , on : " +Route  , E);
        }
        return response;
    }


}
