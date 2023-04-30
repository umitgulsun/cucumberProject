package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SchoolTeacherAddPage {

    public SchoolTeacherAddPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[text()='Menu']")
    public WebElement menu;
    @FindBy(xpath = "//*[text()='Teacher Management']")
    public WebElement teacherManagementLink;

    @FindBy(xpath = "//*[text()='Teacher updated Successful']")
    public WebElement succesfulText;

    @FindBy(id = "react-select-3-input")
    public WebElement ogretmenDersSecme;

    @FindBy(xpath = "(//*[@class=' css-qbdosj-Input'])[2]//input")
    public WebElement ogretmenDersGuncelleme;

    @FindBy(id = "name")
    public WebElement ogretmenName;
    @FindBy(id = "surname")
    public WebElement ogretmenSurName;
    @FindBy(xpath = "(//*[@id='surname'])[2]")
    public WebElement ogretmenSurnameGuncelleme;

    @FindBy(id = "email")
    public WebElement ogretmenEmail;

    @FindBy(xpath = "(//*[@id='email'])[2]")
    public WebElement ogretmenEmailGuncelleme;
    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement ogretmenSubmitButton;

    @FindBy(xpath = "(//*[text()='Submit'])[2]")
    public WebElement ogretmenSubmitButtonGuncelleme;

    @FindBy(xpath = "(//*[@id='name'])[2]")
    public WebElement ogretmenNameGuncelleme;

    @FindBy(xpath = "(//span[@aria-hidden='true'])[4]")
    public WebElement ogretmenLastSayfaListe;

    @FindBy(xpath = "//*[@class='table table-striped table-bordered table-hover']//td")
    public List<WebElement> ogretmenLastSayfaWebelementList;

    @FindBy(xpath = "//*[@type='button']")
    public List<WebElement> ogretmenListeSizeIcin;


    @FindBy(id = "birthPlace")
    public WebElement ogretmenBirthPlace;
    @FindBy(xpath = "(//*[@id='birthPlace'])[2]")
    public WebElement ogretmenBirthPlaceGuncelleme;

    @FindBy(id = "birthDay")
    public WebElement ogretmenBirthDay;

    @FindBy(xpath = "(//*[@id='birthDay'])[2]")
    public WebElement ogretmenBirthDayGuncelleme;

    @FindBy(name = "gender")
    public WebElement ogretmenGender;
    @FindBy(xpath = "(//*[@name='gender'])[4]")
    public WebElement ogretmenGenderGuncelleme;
    @FindBy(id = "phoneNumber")
    public WebElement ogretmenPhoneNumber;

    @FindBy(xpath = "(//*[@id='phoneNumber'])[2]")
    public WebElement ogretmenPhoneGuncelleme;
    @FindBy(id = "isAdvisorTeacher")
    public WebElement ogretmenDanisman;

    @FindBy(id = "ssn")
    public WebElement ogretmenSsn;

    @FindBy(xpath = "(//*[@id='ssn'])[2]")
    public WebElement ogretmenSsnGuncelleme;
    @FindBy(id = "username")
    public WebElement ogretmenUserName;
    @FindBy(xpath = "(//*[@id='username'])[2]")
    public WebElement ogretmenUsernameGuncelleme;
    @FindBy(id = "password")
    public WebElement ogretmenPassword;
    @FindBy(xpath = "(//*[@id='password'])[2]")
    public WebElement ogretmenPasswordGuncelleme;

    @FindBy(xpath = "(//*[@class='btn-close'])[3]")
    public WebElement GuncellemedenSonraCikis;


}
