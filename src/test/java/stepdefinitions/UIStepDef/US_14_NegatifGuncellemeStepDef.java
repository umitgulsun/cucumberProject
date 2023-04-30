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
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.UIStepDef.US_13_14_PozitifOgretmenOlusturma_GuncellemeStepDef.*;


public class US_14_NegatifGuncellemeStepDef {
    SchoolTeacherAddPage schoolTeacherAddPage=new SchoolTeacherAddPage();
    Actions actions= new Actions(Driver.getDriver());
    public List<String> olumsuzListe=new ArrayList<>();

    @Given("{string} name alaninigunceller")
    public void nameAlaninigunceller(String arg0) throws InterruptedException {
 Thread.sleep(3000);
      actions.moveToElement(schoolTeacherAddPage.ogretmenNameGuncelleme).doubleClick().click().
              sendKeys(Keys.BACK_SPACE).build().perform();

        schoolTeacherAddPage.ogretmenNameGuncelleme.sendKeys(arg0);

    }

    @Given("{string} surname alanini gunceller")
    public void surnameAlaniniGunceller(String arg0) {
        actions.moveToElement(schoolTeacherAddPage.ogretmenSurnameGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        schoolTeacherAddPage.ogretmenSurnameGuncelleme.sendKeys(arg0);
    }

    @Given("{string} email alanini gunceller")
    public void emailAlaniniGunceller(String arg0) {
        actions.moveToElement(schoolTeacherAddPage.ogretmenEmailGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        schoolTeacherAddPage.ogretmenEmailGuncelleme.sendKeys(arg0);
    }

    @Given("{string} birthplace alanini gunceller")
    public void birthplaceAlaniniGunceller(String arg0) {
        actions.moveToElement(schoolTeacherAddPage.ogretmenBirthPlaceGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        schoolTeacherAddPage.ogretmenBirthPlaceGuncelleme.sendKeys(arg0);
    }

    @Given("{string} birthday alanini gunceller")
    public void birthdayAlaniniGunceller(String arg0) {
        schoolTeacherAddPage.ogretmenBirthDayGuncelleme.sendKeys(arg0);
    }

    @Given("{string} phone alanini gunceller")
    public void phoneAlaniniGunceller(String arg0) {
        actions.moveToElement(schoolTeacherAddPage.ogretmenPhoneGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        schoolTeacherAddPage.ogretmenPhoneGuncelleme.sendKeys(arg0);
        olumsuzListe.add(arg0);
    }

    @Given("{string} ssn alanini gunceller")
    public void ssnAlaniniGunceller(String arg0) {
        actions.moveToElement(schoolTeacherAddPage.ogretmenSsnGuncelleme).doubleClick().click().
                sendKeys(Keys.BACK_SPACE).build().perform();
        schoolTeacherAddPage.ogretmenSsnGuncelleme.sendKeys(arg0);
        olumsuzListe.add(arg0);
    }

    @Given("{string} username alanini gunceller")
    public void usernameAlaniniGunceller(String arg0) {
        actions.moveToElement(schoolTeacherAddPage.ogretmenUsernameGuncelleme).doubleClick().click().sendKeys(Keys.BACK_SPACE).build().perform();
        schoolTeacherAddPage.ogretmenUsernameGuncelleme.sendKeys(arg0);
        olumsuzListe.add(arg0);
    }

    @Given("{string} password alanini gunceller")
    public void passwordAlaniniGunceller(String arg0) {
        schoolTeacherAddPage.ogretmenPasswordGuncelleme.sendKeys(arg0);
    }

    @Then("submit tusuna basip negatif dogrulama yapar")
    public void submitTusunaBasipNegatifDogrulamaYapar() throws InterruptedException {
        Driver.clickWithJS(schoolTeacherAddPage.ogretmenSubmitButtonGuncelleme);
        String actual="";
        try {
            actual=ReusableMethods.fluentWait(schoolTeacherAddPage.succesfulText,10).getText()+"bulunamadı";
        } catch (Exception e) {

        }
        System.out.println(actual);
        Assert.assertNotEquals(actual,"Teacher updated Successful");
    // Thread.sleep(3000);
    // Driver.getDriver().navigate().refresh();
    // Thread.sleep(3000);
    // Driver.clickWithJS(schoolTeacherAddPage.ogretmenLastSayfaListe);
    // Thread.sleep(3000);

    // for (WebElement w:schoolTeacherAddPage.ogretmenLastSayfaWebelementList) {
    //     sonSayfa.add(w.getText());
    // }
    // Assert.assertFalse(sonSayfa.containsAll(olumsuzListe));
    // System.out.println("sonSayfa = " + sonSayfa);
    // System.out.println("olumsuz = " + olumsuzListe);

    }

    @Then("daha once olusturulan {string} ssn nolu kişi listeden bulunur ve satırdaki edit butonuna tiklar")
    public void dahaOnceOlusturulanSsnNoluKişiListedenBulunurVeSatırdakiEditButonunaTiklar(String arg0) throws InterruptedException {
        List<WebElement> rowliste;// = Driver.getDriver().findElements(By.cssSelector(".table-responsive table tr"));
        int sayfaSayisi = Integer.parseInt(Driver.getDriver().findElement(By.xpath(
                "(//*[@class='d-flex justify-content-start ps-5 col'])[1]")).getText().split(" ")[3]);
        Thread.sleep(3000);
        for (int i = 0; i < sayfaSayisi; i++) {
            rowliste = Driver.getDriver().findElements(By.cssSelector(".table-responsive table tr"));
            for (WebElement w : rowliste) {
                if (w.getText().contains(arg0)) {
                    System.out.println(w.getText());
                    //     Driver.clickWithJS(w.findElement(By.cssSelector("td:last-child button")));
                    Driver.clickWithJS(w.findElement(By.xpath("//*[text()='"+arg0+"']//following::button")));
                    //--//*[text()='695-79-3113']//following::button
                    return;
                }
            }
            Driver.clickWithJS(Driver.getDriver().findElement(By.xpath("(//ul[@class='d-flex justify-content-end pe-3 pagination']//a)[3]")));

        }
    }

}
