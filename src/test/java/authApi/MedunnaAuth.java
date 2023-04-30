package authApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MedunnaAuth
{

    public static String medAuth(){
        String auth="https://medunna.com/api/authenticate";
        Map<String,String> bodyauth=new HashMap<>();
        bodyauth.put("password","Batch.103");
        bodyauth.put("username","batch_yuzuc");

        Response response=given().body(bodyauth).contentType(ContentType.JSON).when().post(auth);
        return response.jsonPath().getString("id_token");
    }


}
