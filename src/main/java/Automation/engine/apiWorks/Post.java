package Automation.engine.apiWorks;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class Post {

    public static Response PostRequest(Object object, String RequestUrl){

        RequestSpecification specs = RequestSpecs.GetRequestSpecs();

        Response response = given().spec(specs).body(object).when().post(RequestUrl)
                                        .then().log().all().extract().response();

        return response;
    }

}
