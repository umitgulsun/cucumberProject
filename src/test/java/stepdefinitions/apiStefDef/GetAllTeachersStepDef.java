package stepdefinitions.apiStefDef;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.OgretmenResponsePojo;

import java.util.ArrayList;
import java.util.List;

import static authApi.SchoolAuth.schoolAuth;
import static base_urls.SchoollBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.apiStefDef.PostApiTeacherStepDef.userId;

public class GetAllTeachersStepDef {
    List<Integer> listedekiogretmenler=new ArrayList<>();
    @Given("get all the teachers")
    public void getAllTheTeachers() {
        spec.pathParams("first","teachers","second","getAll");
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();
       // JsonPath jsonPath=response.jsonPath();
      // listedekiogretmenler=response.jsonPath().getList("userId");
      // Assert.assertTrue(listedekiogretmenler.contains(userId));
    }
}
