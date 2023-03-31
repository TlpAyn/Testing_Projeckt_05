package case01_LoginTest;

import Utility.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestElements {
    public TestElements() {

        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    public List<WebElement> navMenu;
    @FindBy(xpath = "//ul[@style='display: block;']")
    public WebElement altaBlok;
    @FindBy(linkText = "Customers")
    public WebElement customers;
    @FindBy(xpath = "//p[text()=' Customers']")
    public WebElement customers2;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement addButton;
    @FindBy(xpath = "//input[@id='Email']")
    public WebElement Email;
    @FindBy(xpath = "(//div[@class='form-group row'])[9]")
    public WebElement newsletter;
    @FindBy(name = "save")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement vrfyText;
    @FindBy(xpath = "//div[@data-hideattribute='CustomerListPage.HideSearchBlock']/div[@class='search-text']")
    public WebElement searchFirstButton;
    @FindBy(id = "SearchEmail")
    public WebElement searchEmail;
    @FindBy(id = "SearchFirstName")
    public WebElement FirsName;
    @FindBy(id = "SearchLastName")
    public WebElement LastNAme;
    @FindBy(xpath = "//i[@class='fas fa-search' and @aria-hidden='true']")
    public WebElement searchClickAlt;
    @FindBy(xpath = "(//tr[@class='odd'])[1]/td[3]")
    public WebElement ilkiSatirilkName;
    @FindBy(xpath = "//a[@class='btn btn-default']")
    public List<WebElement> Edits;
    @FindBy(id = "LastName")
    public WebElement LastNAmeDuzeltme;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement vrfyTextSon;

}
