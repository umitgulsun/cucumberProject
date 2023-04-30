package authApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SchoolAuth {

    public static String schoolAuth(){

        String auth="http://164.92.252.42:8080/auth/login";
        Map<String,String> bodyauth=new HashMap<>();
        bodyauth.put("password","12345678");
        bodyauth.put("username","AdminB103");

        Response response=given().contentType(ContentType.JSON).body(bodyauth).post(auth);
       return response.jsonPath().get("token");
    }

}
