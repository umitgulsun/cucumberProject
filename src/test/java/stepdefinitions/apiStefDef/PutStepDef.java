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
import static stepdefinitions.UIStepDef.US_13_14_PozitifOgretmenOlusturma_GuncellemeStepDef.usernames;
import static stepdefinitions.apiStefDef.PostApiTeacherStepDef.userId;

public class PutStepDef {
    OgretmenOlusturPojo expectedData;
    OgretmenResponsePojo ogretmenResponsePojo;
    public static List<Object> listeTeacherId=new ArrayList<>();
    Faker faker=new Faker();

    @Given("put teacher credidentals")
    public void putTeacherCredidentals() {

        firstname=faker.name().firstName();
        surname=faker.name().lastName();
        email=faker.internet().emailAddress();
        birthplace=faker.address().city();
        birthday=faker.number().numberBetween(1970,2002)+"-02-04";
        phone=faker.number().digits(3)+"-"+faker.number().digits(3)+"-"+faker.number().digits(4);
        ssn=faker.number().digits(3)+"-"+faker.number().digits(2)+"-"+faker.number().digits(4);
        usernames=faker.name().name();
        passwords=faker.number().digits(8);
        listeTeacherId.add(2);
        spec.pathParams("first","teachers","second","update","third",userId);

        expectedData=new OgretmenOlusturPojo(birthday,birthplace,email,"MALE",true,listeTeacherId,firstname,passwords,phone,ssn,surname,usernames);
        ogretmenResponsePojo=new OgretmenResponsePojo(expectedData,"Teacher saved successfully","CREATED");
        System.out.println(expectedData);
        System.out.println(ogretmenResponsePojo);
        Response response=given(spec).body(expectedData).put("{first}/{second}/{third}");
        response.prettyPrint();
     /*   System.out.println(expectedData);
        OgretmenResponsePojo actualData=response.as(OgretmenResponsePojo.class);
        Assert.assertEquals(expectedData.getBirthDay(),actualData.getOgretmenOlusturPojo().getBirthDay());
        Assert.assertEquals(expectedData.getSsn(),actualData.getOgretmenOlusturPojo().getSsn());*/
    }


}
