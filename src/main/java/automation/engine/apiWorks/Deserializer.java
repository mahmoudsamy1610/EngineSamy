package automation.engine.apiWorks;

import io.restassured.response.Response;

public class Deserializer {

    public static Object Deserialize(Response response , Object ObjectAs){

        ObjectAs = response.body().as(Object.class);

        return ObjectAs;
    }


}
