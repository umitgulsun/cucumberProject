package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static authApi.SchoolAuth.schoolAuth;

public class SchoollBaseUrl {
    public static RequestSpecification spec;

    public static void schollBeforeSpec()
    {
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).
                setBaseUri("http://164.92.252.42:8080").
                addHeader("Authorization", schoolAuth() ).build();
    }
}
