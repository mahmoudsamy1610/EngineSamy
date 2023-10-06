package Automation.engine.apiWorks;

import Automation.engine.reportingWorks.AllureStepLogger;
import Automation.utils.loggers.EngineLogger;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

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



}
