package stepdefinitions.apiStefDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pojos.OgretmenOlusturPojo;
import pojos.OgretmenResponsePojo;

import java.util.ArrayList;
import java.util.List;

import static base_urls.SchoollBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.UIStepDef.US_13_14_PozitifOgretmenOlusturma_GuncellemeStepDef.*;

public class PostApiTeacherStepDef {

    OgretmenOlusturPojo expectedData;
    OgretmenResponsePojo ogretmenResponsePojo;
    public static int userId;
    public static List<Object> listeTeacherId=new ArrayList<>();
    Faker faker=new Faker();
    @Given("ogretmen olusturmak icin post istegi gonderilir")
    public void ogretmen_olusturmak_icin_post_istegi_gonderilir() {
 //firstname=faker.name().firstName();
 //surname=faker.name().lastName();
 //email=faker.internet().emailAddress();
 //birthplace=faker.address().city();
 //birthday=faker.number().numberBetween(1970,2002)+"-02-04";
 //phone=faker.number().digits(3)+"-"+faker.number().digits(3)+"-"+faker.number().digits(4);
 //ssn=faker.number().digits(3)+"-"+faker.number().digits(2)+"-"+faker.number().digits(4);
 //usernames=faker.name().name();
 //passwords=faker.number().digits(8);

        listeTeacherId.add(2);
        spec.pathParams("first","teachers","second","save");
        expectedData=new OgretmenOlusturPojo("2000-02-04","Adana","Pedro14@hotmail.com","MALE",true,listeTeacherId,"Kasım","p12345678","135-135-1973","569-25-7894","Gulek","kargalar");
        ogretmenResponsePojo=new OgretmenResponsePojo(expectedData,"Teacher saved successfully","CREATED");
        Response response=given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        userId=response.jsonPath().getInt("object.userId");

    }


}
