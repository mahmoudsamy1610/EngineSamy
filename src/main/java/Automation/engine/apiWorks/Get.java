package Automation.engine.apiWorks;

import Automation.engine.reportingWorks.AllureStepLogger;
import Automation.utils.loggers.EngineLogger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Get {


    public static Response GetRequest(String Route, String AuthToken, String RequestName ){
        EngineLogger.EngineInfo("Firing request GET at route : " + Route+ " ,Authenticated by : " + AuthToken);
        AllureStepLogger.logStep("Request : " + RequestName+ " , on : " +Route);
        Response response = null;

        try {
            RequestSpecification specs = RequestSpecs.GetRequestSpecs();
            response = given().spec(specs).auth().oauth2(AuthToken).when().get(Route)
                    .then().log().all().extract().response();

        }catch (Exception E){
            EngineLogger.EngineExceptionError("Failed Firing request GET at route : " + Route+ " ,Authenticated by : " + AuthToken, E);
            AllureStepLogger.logStep("Request : " + RequestName+ " , on : " +Route);
            Assert.fail("Failed to Request : " + RequestName+ " , on : " +Route  , E);
        }
        return response;
    }

}
