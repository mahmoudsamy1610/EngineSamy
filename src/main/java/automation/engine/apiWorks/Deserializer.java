package automation.engine.apiWorks;

import browserstack.shaded.org.json.JSONObject;
import io.restassured.response.Response;

public class Deserializer {

    public static Object Deserialize(Response response , Object ObjectAs){

        ObjectAs = response.body().as(Object.class);

        return ObjectAs;
    }

    public static String GetStringFromResponse(Response response , String Key){

        JSONObject jsonResponse = new JSONObject(response.getBody().asString());

        return jsonResponse.getString(Key);

    }

}
