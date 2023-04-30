package stepdefinitions.UIStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SchoolTeacherAddPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.UIStepDef.US_13_14_PozitifOgretmenOlusturma_GuncellemeStepDef.sonSayfa;

public class US_13_NegatifOgretmenOlusturmaStepDef {
    SchoolTeacherAddPage schoolTeacherAddPage = new SchoolTeacherAddPage();
    Actions actions = new Actions(Driver.getDriver());
    public static List<String> ssnListesi = new ArrayList<>();


    @Given("{string} ve \"<ders>\"alanina ders bilgileri girer")
    public void ve_ders_alanina_ders_bilgileri_girer(String string) throws InterruptedException {
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).build().perform();
        Thread.sleep(3000);
        schoolTeacherAddPage.ogretmenDersSecme.sendKeys(string, Keys.ENTER);
        Thread.sleep(1000);
    }

    @Given("{string} alanina bilgileri girer")
    public void alaninaBilgileriGirer(String arg0) throws InterruptedException {

        schoolTeacherAddPage.ogretmenName.sendKeys(arg0);
    }

    @Given("{string} alanina surname bilgileri girer")
    public void alaninaSurnameBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenSurName.sendKeys(arg0);
    }

    @Given("{string} alanina birthplace bilgileri girer")
    public void alaninaBirthplaceBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenBirthPlace.sendKeys(arg0);
    }

    @Given("{string} alanina email bilgileri girer")
    public void alanina_email_bilgileri_girer(String string) {
        schoolTeacherAddPage.ogretmenEmail.sendKeys(string);
    }

    @Given("{string} alanina gender bilgileri girer")
    public void alaninaGenderBilgileriGirer(String arg0) {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenGender);
    }

    @Given("{string} alanina birthday bilgileri girer")
    public void alaninaBirthdayBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenBirthDay.sendKeys(arg0);
    }

    @Given("{string} alanina uc-uc-dort rakam seklinde bilgileri girer")
    public void alaninaUcUcDortRakamSeklindeBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenPhoneNumber.sendKeys(arg0);
    }

    @Given("{string} alanina uc-iki-dort rakam seklinde bilgileri girer")
    public void alaninaUcIkiDortRakamSeklindeBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenSsn.sendKeys(arg0);
        ssnListesi.add(arg0);
    }

    @Given("{string} alanina danisman bilgileri girer")
    public void alanina_danisman_bilgileri_girer(String string) {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenDanisman);
    }

    @Given("{string} alanina username bilgileri girer")
    public void alaninaUsernameBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenUserName.sendKeys(arg0);
    }

    @Given("{string} alanina password bilgileri girer")
    public void alaninaPasswordBilgileriGirer(String arg0) throws InterruptedException {
        schoolTeacherAddPage.ogretmenPassword.sendKeys(arg0);
        Thread.sleep(2000);
    }


    @Then("girilen ogretmen bilgilerinin kaydolmadigini dogrular")
    public void girilenOgretmenBilgilerininKaydolmadiginiDogrular() {
        for (WebElement w : schoolTeacherAddPage.ogretmenLastSayfaWebelementList) {
            sonSayfa.add(w.getText());
            Assert.assertFalse("Ssn nolu Testimiz kaldi", ssnListesi.contains(w.getText()));
        }

        System.out.println(sonSayfa);
        System.out.println(ssnListesi);
    }

    @Then("close the application")
    public void closeTheApplication() {
        Driver.closeDriver();
    }




    @Then("sayfayi {string} numarasına gore olusup olusmadıgını kontrol eder")
    public void sayfayiNumarasınaGoreOlusupOlusmadıgınıKontrolEder(String arg0) throws InterruptedException {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenLastSayfaListe);
        Thread.sleep(2000);
        List<WebElement> rowListe = Driver.getDriver().findElements(By.cssSelector(".table-responsive table tr"));
        Thread.sleep(2000);
        for (WebElement w:rowListe) {
            System.out.println(w.getText());
            if (w.getText().contains(arg0)) {
                Assert.assertFalse(w.getText().contains(arg0));
            }
        }
        Thread.sleep(5000);
     //actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
     //        sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
     //        sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
     //        sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
     //        sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).build().perform();
     //Thread.sleep(2000);
     //List<WebElement> SayfaninListesiSizeAl = Driver.getDriver().findElements(By.xpath("//*[@type='button']"));
     //Driver.clickWithJS(Driver.getDriver().
     //        findElement(By.xpath("(//*[@type='button'])[" + SayfaninListesiSizeAl.size() + "]")));
     ////    Driver.clickWithJS(Driver.getDriver().findElement(By.xpath("//*[text()='"+ssn+"']//following::text()[2]")));
     //Thread.sleep(5000);
    }
}
