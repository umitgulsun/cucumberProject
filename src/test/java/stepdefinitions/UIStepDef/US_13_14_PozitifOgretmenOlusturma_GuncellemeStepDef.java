package stepdefinitions.UIStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SchoolTeacherAddPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US_13_14_PozitifOgretmenOlusturma_GuncellemeStepDef {

    SchoolTeacherAddPage schoolTeacherAddPage = new SchoolTeacherAddPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    public static String firstname;
    public static String surname;
    public static String birthplace;
    public static String email;
    public static String ssn;
    public static String phone;
    public static String birthday;
    public static String usernames;
    public static String passwords;
    public static List<String> sonSayfa = new ArrayList<>();
    public static List<String> ogretmenlist = new ArrayList<>();


    @Given("Kullanici menu butonuna tiklar")
    public void kullaniciMenuButonunaTiklar() throws InterruptedException {
        Driver.clickWithJS(schoolTeacherAddPage.menu);
        Thread.sleep(3000);
    }

    @Given("Kullanici ogretmen alanina tiklar")
    public void kullanici_ogretmen_alanina_tiklar() throws InterruptedException {
        Driver.clickWithJS(schoolTeacherAddPage.teacherManagementLink);
        Thread.sleep(2000);
    }


    @Given("dersler alanina ders bilgilerini fake girer")
    public void derslerAlaninaDersBilgileriniFakeGirer() throws InterruptedException {
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).build().perform();
        Thread.sleep(1000);

        schoolTeacherAddPage.ogretmenDersSecme.click();
        Thread.sleep(3000);
        schoolTeacherAddPage.ogretmenDersSecme.sendKeys("JAVA", Keys.ENTER);
    }

    @Given("name alanina bilgileri fake girer")
    public void nameAlaninaBilgileriFakeGirer() {
        firstname = faker.name().firstName();
        schoolTeacherAddPage.ogretmenName.sendKeys(firstname);
    }

    @Given("surname alanina surname bilgileri fake girer")
    public void surnameAlaninaSurnameBilgileriFakeGirer() {
        surname = faker.name().lastName();
        schoolTeacherAddPage.ogretmenSurName.sendKeys(surname);
    }

    @Given("email alanina email bilgileri fake girer")
    public void emailAlaninaEmailBilgileriFakeGirer() {
        email = "Madisen72@gmail.com";
        schoolTeacherAddPage.ogretmenEmail.sendKeys(email);
    }

    @Given("danisman alanina danisman bilgileri girer")
    public void danismanAlaninaDanismanBilgileriGirer() {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenDanisman);
    }

    @Given("birthplace alanina birthplace bilgileri girer")
    public void birthplaceAlaninaBirthplaceBilgileriGirer() {
        birthplace = faker.address().city();
        schoolTeacherAddPage.ogretmenBirthPlace.sendKeys(birthplace);
    }

    @Given("gender alanina gender bilgileri girer")
    public void genderAlaninaGenderBilgileriGirer() {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenGender);
    }

    @Given("birthday alanina birthday bilgileri girer")
    public void birthdayAlaninaBirthdayBilgileriGirer() {

        birthday = faker.number().numberBetween(10, 30) + "." + 12 + "." + faker.number().numberBetween(1970, 2002);
        schoolTeacherAddPage.ogretmenBirthDay.sendKeys(birthday);
    }

    @Given("phone alanina uc-uc-dort rakam seklinde bilgileri girer")
    public void phoneAlaninaUcUcDortRakamSeklindeBilgileriGirer() {
        phone = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4);
        schoolTeacherAddPage.ogretmenPhoneNumber.sendKeys(phone);
    }

    @Given("ssn alanina uc-iki-dort rakam seklinde bilgileri girer")
    public void ssnAlaninaUcIkiDortRakamSeklindeBilgileriGirer() {

        ssn = faker.number().digits(3) + "-" + faker.number().digits(2) + "-" + faker.number().digits(4);
        schoolTeacherAddPage.ogretmenSsn.sendKeys(ssn);
    }

    @Given("username alanina username bilgileri girer")
    public void usernameAlaninaUsernameBilgileriGirer() {
        schoolTeacherAddPage.ogretmenUserName.sendKeys(ConfigReader.getProperty("usernames"));
    }

    @Given("password alanina password bilgileri girer")
    public void passwordAlaninaPasswordBilgileriGirer() {
        passwords = faker.number().digits(8);
        schoolTeacherAddPage.ogretmenPassword.sendKeys(passwords);
    }

    @Then("submit tusuna tiklar")
    public void submitTusunaTiklar() throws InterruptedException {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenSubmitButton);
        Thread.sleep(5000);
    }


    @Then("ogretmenin olustugunu dogrular")
    public void ogretmenin_olustugunu_dogrular() throws InterruptedException {
        Thread.sleep(3000);
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenLastSayfaListe);
        Thread.sleep(3000);
        for (WebElement w : schoolTeacherAddPage.ogretmenLastSayfaWebelementList) {
            sonSayfa.add(w.getText());
        }
        ogretmenlist.add(ssn);
        ogretmenlist.add(phone);
        System.out.println("sonSayfa = " + sonSayfa);
        System.out.println("ogretmenlist = " + ogretmenlist);
        Assert.assertTrue(sonSayfa.containsAll(ogretmenlist));
    }


    @Given("olusturulan ogretmenin bilgilerinin bulundugu satirdaki edit butonuna tiklar")
    public void olusturulanOgretmeninBilgilerininBulunduguSatirdakiEditButonunaTiklar() throws InterruptedException {
        Thread.sleep(5000);
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).build().perform();
        Thread.sleep(2000);
        List<WebElement> SayfaninListesiSizeAl = Driver.getDriver().findElements(By.xpath("//*[@type='button']"));
        Driver.clickWithJS(Driver.getDriver().
                findElement(By.xpath("(//*[@type='button'])[" + SayfaninListesiSizeAl.size() + "]")));
        //    Driver.clickWithJS(Driver.getDriver().findElement(By.xpath("//*[text()='"+ssn+"']//following::text()[2]")));
        Thread.sleep(5000);
    }

    @Given("dersler alanina ders bilgilerini gunceller")
    public void derslerAlaninaDersBilgileriniGunceller() throws InterruptedException {
        Thread.sleep(5000);
       // Driver.getDriver().findElement(By.xpath("(//*[@class='css-tj5bde-Svg'])[2]")).click();
        schoolTeacherAddPage.ogretmenDersGuncelleme.sendKeys("JAVA", Keys.ENTER);
        Thread.sleep(1000);

    }

    @Given("name alanini gunceller")
    public void nameAlaniniGunceller() {

        firstname = faker.name().firstName();
        actions.moveToElement(schoolTeacherAddPage.ogretmenNameGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        schoolTeacherAddPage.ogretmenNameGuncelleme.sendKeys(firstname);
    }


    @Given("surname alanini gunceller")
    public void surnameAlaniniGunceller() {
        actions.moveToElement(schoolTeacherAddPage.ogretmenSurnameGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        surname = faker.name().lastName();
        schoolTeacherAddPage.ogretmenSurnameGuncelleme.sendKeys(surname);
    }

    @Given("email alanini gunceller")
    public void emailAlaniniGunceller() {
        actions.moveToElement(schoolTeacherAddPage.ogretmenEmailGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        email = faker.internet().emailAddress();
        schoolTeacherAddPage.ogretmenEmailGuncelleme.sendKeys(email);
    }

    @Given("birthplace alanini gunceller")
    public void birthplaceAlaniniGunceller() {
        actions.moveToElement(schoolTeacherAddPage.ogretmenBirthPlaceGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        birthplace = faker.address().city();
        schoolTeacherAddPage.ogretmenBirthPlaceGuncelleme.sendKeys(birthplace);
    }


    @Given("birthday alanini gunceller")
    public void birthdayAlaniniGunceller() {
        birthday = faker.number().numberBetween(10, 30) + "." + 12 + "." + faker.number().numberBetween(1970, 2002);
        schoolTeacherAddPage.ogretmenBirthDayGuncelleme.sendKeys(birthday);
    }

    @Given("phone alanini gunceller")
    public void phoneAlaniniGunceller() {
        //   actions.moveToElement(schoolTeacherAddPage.ogretmenPhoneGuncelleme).keyDown(Keys.CONTROL).sendKeys("a",Keys.DELETE).keyUp(Keys.CONTROL).perform();
        actions.moveToElement(schoolTeacherAddPage.ogretmenPhoneGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        phone = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4);
        schoolTeacherAddPage.ogretmenPhoneGuncelleme.sendKeys(phone);
    }

    @Given("ssn alanini gunceller")
    public void ssnAlaniniGunceller() {
        // actions.moveToElement(schoolTeacherAddPage.ogretmenSsnGuncelleme).keyDown(Keys.CONTROL).sendKeys("a",Keys.DELETE).keyUp(Keys.CONTROL).perform();
        actions.moveToElement(schoolTeacherAddPage.ogretmenSsnGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        ssn = faker.number().digits(3) + "-" + faker.number().digits(2) + "-" + faker.number().digits(4);
        schoolTeacherAddPage.ogretmenSsnGuncelleme.sendKeys(ssn);

    }

    @Given("username alanini gunceller")
    public void usernameAlaniniGunceller() {
        actions.moveToElement(schoolTeacherAddPage.ogretmenUsernameGuncelleme).doubleClick().click().sendKeys(Keys.BACK_SPACE).build().perform();
        usernames = faker.name().name();
        schoolTeacherAddPage.ogretmenUsernameGuncelleme.sendKeys(usernames);
    }

    @Given("password alanini gunceller")
    public void passwordAlaniniGunceller() throws InterruptedException {
        // actions.doubleClick(schoolTeacherAddPage.ogretmenPasswordGuncelleme).sendKeys(Keys.BACK_SPACE).build().perform();
        passwords = faker.number().digits(8);
        schoolTeacherAddPage.ogretmenPasswordGuncelleme.sendKeys(passwords);
    }

    @Given("gender alanini gunceller")
    public void genderAlaniniGunceller() {
      Driver.clickWithJS(schoolTeacherAddPage.ogretmenGenderGuncelleme);
    }


    @Then("submit tusuna basip dogrulama yapar")
    public void submitTusunaBasipDogrulamaYapar() throws InterruptedException {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenSubmitButtonGuncelleme);
        Thread.sleep(3000);
        Driver.clickWithJS(schoolTeacherAddPage.GuncellemedenSonraCikis);
        Thread.sleep(2000);
        List<WebElement> rowListe = Driver.getDriver().findElements(By.cssSelector(".table-responsive table tr"));
        Thread.sleep(2000);
        for (WebElement w:rowListe) {
            if (w.getText().contains(phone)) {
                Assert.assertTrue(w.getText().contains(phone));
                break;
            }
        }
    }


    @Given("{string} alanina gecerli bir email girer")
    public void alaninaGecerliBirEmailGirer(String arg0) {
        schoolTeacherAddPage.ogretmenEmail.sendKeys(ConfigReader.getProperty("email"));

    }
}
