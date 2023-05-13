package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JavascriptAlerts {

    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    // Ilgili method'lari kullanin.

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1. alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // Alert'deki yazinin "I am a JS Alert" oldugunu tespit edip OK tusuna basalim.
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS Alert";
        Thread.sleep(1500);

        Assert.assertEquals(expectedAlertText,actualAlertText);

        // OK tusuna basip Alert'i kapatalim.
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02() throws InterruptedException {
        // Tekrar sayfaya gidelim. Refresh yapmak gibi birsey aslinda.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // cancel'a basip,
        driver.switchTo().alert().dismiss();

        // cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin.
        String expectedMessage = "You clicked: Cancel";
        String actualMessage = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();

        Assert.assertEquals(expectedMessage,actualMessage);
        Thread.sleep(1500);


    }

    @Test

    public void test03() throws InterruptedException {
        // Tekrar sayfaya gidelim. Refresh yapmak gibi birsey aslinda.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(1500);

        driver.switchTo().alert().accept();

        String expectedMessage = "Abdullah";
        String actualMessage = driver.findElement(By.xpath("//p[@id='result']")).getText(); // You entered: Abdullah

        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }

}
