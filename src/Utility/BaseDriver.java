package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemler()
    {

        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
      // driver = new ChromeDriver(options);
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();


        //     driver = new FirefoxDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(20);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver,
                Duration.ofSeconds(20));
        loginTest();
    }

    void loginTest() {

        System.out.println("Login Test");


        driver.get("https://admin-demo.nopcommerce.com/login");

        WebElement inputEmail = driver.findElement(By.id("Email"));
        inputEmail.clear();
        inputEmail.sendKeys("admin@yourstore.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys("admin");

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginBtn.click();



    }
    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(5);
        driver.quit();
    }
}
