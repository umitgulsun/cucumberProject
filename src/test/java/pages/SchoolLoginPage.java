package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SchoolLoginPage {
    public SchoolLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement username;


    @FindBy(xpath = "(//*[text()='Teacher Management'])[2]")
    public WebElement teacherManagementLink;
    @FindBy(css = "[type='password']")
    public WebElement password;
    @FindBy(xpath = "(//*[text()='Login'])[2]")
    public WebElement LoginButton;
    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logout;

    @FindBy(xpath = "(//*[@type='button'])[28]")
    public WebElement editKapat;
    @FindBy(css = "[class='header_link ms-2']")
    public WebElement LoginAnasayfaLinki;
    @FindBy(xpath = "//*[text()='Menu']")
    public WebElement menu;

    @FindBy(xpath = "//*[text()='Yes']")
    public WebElement logoutYesButton;


}
