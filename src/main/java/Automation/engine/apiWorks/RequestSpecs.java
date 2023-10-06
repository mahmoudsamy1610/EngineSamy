package Automation.engine.apiWorks;

import Automation.engine.setupWorks.EnvManagerApi;
import Automation.utils.loggers.EngineLogger;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RequestSpecs {


    public static RequestSpecification GetRequestSpecs() {
        EngineLogger.EngineInfo("Parsing Api request specification");

        RequestSpecification requestSpecs = null;

        try {
            String Domain = EnvManagerApi.SelectApiEnvironment();
            requestSpecs = given().baseUri(Domain).contentType(ContentType.JSON).log().all();

            if (requestSpecs == null){
                EngineLogger.EngineError("Failed Parsing Api request specification");
                throw new NullPointerException();
            }

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Parsing Api request specification", E);
        }
        return requestSpecs;
    }

}
