package stepdefinitions.UIStepDef;

import io.cucumber.java.en.Given;
import pages.SchoolLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_13_LoginStepDef {
    SchoolLoginPage schoolLoginPage=new SchoolLoginPage();

    @Given("Kullanici anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("schoolUrl"));
    }

    @Given("Kullanici Anasayfada logine tiklar")
    public void kullaniciAnasayfadaLogineTiklar() {

    try {
        schoolLoginPage.menu.click();
        schoolLoginPage.logout.click();
        schoolLoginPage.logoutYesButton.click();
    } catch (Exception e) {

    }
        schoolLoginPage.LoginAnasayfaLinki.click();

    }

    @Given("{string} ve {string} girer")
    public void veGirer(String arg0, String arg1) throws InterruptedException {
        schoolLoginPage.username.sendKeys(ConfigReader.getProperty(arg0));
        schoolLoginPage.password.sendKeys(ConfigReader.getProperty(arg1));
    }

    @Given("login tusuna tiklar")
    public void loginTusunaTiklar() {
        Driver.clickWithJS(schoolLoginPage.LoginButton);
    }

}
