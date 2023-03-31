package case01_LoginTest;

import Utility.BaseDriver;
import Utility.Tools;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.tools.Tool;
import java.security.Key;
import java.util.List;

public class Tests extends BaseDriver {

    TestElements ts = new TestElements();


    int sayi = (int) (Math.random() * 10000);
    String MailAdresse = "ttt" + sayi + "@gmail.com";
    JavascriptExecutor js = (JavascriptExecutor) driver;


    @Test(priority = 1)
    void test1() {

        Assert.assertTrue(ts.logout.getText().equals("Logout"));


    }

    @Test(priority = 2)
    void test2_Check_LeftNAv_Menu() {
        driver.manage().deleteAllCookies();


        for (int i = 1; i < ts.navMenu.size(); i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(ts.navMenu));
            ts.navMenu.get(i).click();

            Assert.assertTrue(ts.altaBlok.isDisplayed());
        }
    }

    @Test(priority = 3)
    void test3_Create_Customer() {


        WebElement customers = driver.findElement(By.linkText("Customers"));
        wait.until(ExpectedConditions.elementToBeClickable(customers));
        customers.click();


        WebElement customers2 = driver.findElement(By.xpath("//p[text()=' Customers']"));
        wait.until(ExpectedConditions.elementToBeClickable(customers2));
        customers2.click();

        WebElement addButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();


        WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
        wait.until(ExpectedConditions.elementToBeClickable(Email));

        Email.sendKeys(MailAdresse);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("123456").
                sendKeys(Keys.TAB).
                sendKeys("Tahsin").
                sendKeys(Keys.TAB).
                sendKeys("Yilmaz").
                sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).
                sendKeys(Keys.TAB).
                sendKeys("3/7/1996").
                sendKeys(Keys.TAB).
                sendKeys("HanselinFAbrik").
                sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).perform();

        WebElement newsletter = driver.findElement(By.xpath("(//div[@class='form-group row'])[9]"));
        newsletter.click();

        actions.sendKeys(Keys.DOWN).
                sendKeys(Keys.ENTER).perform();

        WebElement saveButton = driver.findElement(By.name("save"));

        saveButton.click();
        WebElement vrfyText = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"));

        Assert.assertTrue(vrfyText.getText().contains("successfully."));
    }

    @Test(priority = 4)
    void test4_EditCustomer() {
        //   WebElement customers = driver.findElement(By.linkText("Customers"));
        //    wait.until(ExpectedConditions.elementToBeClickable(customers));
        //   customers.click();

        //   WebElement customers2 = driver.findElement(By.xpath("//p[text()=' Customers']"));

        //   customers2.click();

        //  WebElement OpenVerify = driver.findElement(By.xpath("//div[@style='display: none;']"));

        WebElement searchFirstButton = driver.findElement(By.xpath("//div[@data-hideattribute='CustomerListPage.HideSearchBlock']/div[@class='search-text']"));
        searchFirstButton.click();
//        if (OpenVerify.isEnabled()) {
//
//        }


        WebElement searchEmail = driver.findElement(By.id("SearchEmail"));
        wait.until(ExpectedConditions.visibilityOf(searchEmail));
        searchEmail.sendKeys(MailAdresse);
        WebElement FirsName = driver.findElement(By.id("SearchFirstName"));
        wait.until(ExpectedConditions.visibilityOf(FirsName));
        FirsName.sendKeys("Tahsin");
        WebElement LastNAme = driver.findElement(By.id("SearchLastName"));
        wait.until(ExpectedConditions.visibilityOf(LastNAme));
        LastNAme.sendKeys("Yilmaz");


        WebElement searchClickAlt = driver.findElement(By.xpath("//i[@class='fas fa-search' and @aria-hidden='true']"));
        searchClickAlt.click();


        WebElement ilkiSatirilkName = driver.findElement(By.xpath("(//tr[@class='odd'])[1]/td[3]"));
        wait.until(ExpectedConditions.visibilityOf(ilkiSatirilkName));

        Assert.assertEquals("Tahsin Yilmaz", ilkiSatirilkName.getText());


        List<WebElement> Edits = driver.findElements(By.xpath("//a[@class='btn btn-default']"));

        Edits.get(0).click();

        WebElement LastNAmeDuzeltme = driver.findElement(By.id("LastName"));
        LastNAmeDuzeltme.sendKeys("Yilmazz");

        WebElement saveButton = driver.findElement(By.name("save"));
        saveButton.click();

        WebElement vrfyTextSon = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"));

        Assert.assertTrue(vrfyTextSon.getText().contains("successfully."));

    }

    @Test(priority = 5)
    void test5_DeleteCustomer() {

        WebElement searchFirstButton = driver.findElement(By.xpath("//div[@data-hideattribute='CustomerListPage.HideSearchBlock']/div[@class='search-text']"));
        searchFirstButton.click();


        Tools.Bekle(1);
        WebElement Email = driver.findElement(By.id("SearchEmail"));
        Email.sendKeys(MailAdresse);
        Tools.Bekle(1);
        WebElement FirsName = driver.findElement(By.id("SearchFirstName"));
        FirsName.sendKeys("Tahsin");
        Tools.Bekle(1);
        WebElement LastNAme = driver.findElement(By.id("SearchLastName"));
        LastNAme.sendKeys("Yilmaz");
        Tools.Bekle(1);

        WebElement searchClickAlt = driver.findElement(By.xpath("//i[@class='fas fa-search' and @aria-hidden='true']"));
        searchClickAlt.click();


        List<WebElement> Edits = driver.findElements(By.xpath("//a[@class='btn btn-default']"));

        Edits.get(0).click();

        WebElement deleteButton = driver.findElement(By.id("customer-delete"));
        deleteButton.click();
        //button[@class='btn btn-danger float-right']
        WebElement deleteButtonVerify = driver.findElement(By.xpath("//button[@class='btn btn-danger float-right']"));
        deleteButtonVerify.click();

        WebElement vrfyTextSon = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"));

        Assert.assertTrue(vrfyTextSon.getText().contains("successfully."));

    }

    @Test(priority = 6)
    void test6_SearchTest() {

        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search.sendKeys("Shipments");

        WebElement searchClick = driver.findElement(By.xpath("//strong[text()='Shipments']"));
        searchClick.click();


        //strong[text()='Shipments']

        // WebElement ShipmentsText = driver.findElement(By.xpath("//h1[@class='float-left']"));

        Assert.assertTrue(driver.getCurrentUrl().contains("ShipmentList"));

    }


}



