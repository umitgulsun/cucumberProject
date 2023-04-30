package stepdefinitions.apiStefDef;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static base_urls.SchoollBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.apiStefDef.PostApiTeacherStepDef.userId;

public class DeleteApiStepDef {

    @Given("delete teacher")
    public void delete_teacher() {

        spec.pathParams("first","teachers","second","delete","third",userId);

        Response response=given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();
    }


}
