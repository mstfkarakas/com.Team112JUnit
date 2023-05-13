package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {

//            1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
//
//            2 ) Bir metod olusturun: iframeTest
//              - “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
//              - Text Box’a “Merhaba Dunya!” yazin.
//              - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {  driver.close(); }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement actualText = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualText.isEnabled());
        Thread.sleep(2000);


        // normal locate yapip yazdirmayi denedigimizde NoSuchElementException verdi
        // yani elementi bulamadi
        // kontrol ederken istedigimiz webelement'in bir iframe icinde oldugunu gorduk
        // Bu durumda once o iframe'e switchTo() yapmaliyiz
        WebElement iFrameWebElement = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameWebElement);

        WebElement textBoxElement = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya!");
        Thread.sleep(2000);


        //	- TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        // Iframe'in icine girdikten sonra, oradan cik denilinceye kadar
        // driver iframe'in icinde kalir
        // eger disina cikmak isterseniz

        // driver.switchTo().parentFrame(); // bulundugu iframe'den bir ust html sayfasina gecer
        // bu daha cok ic icice iframe'ler oldugunda tercih edilir

        driver.switchTo().defaultContent(); // iFrame'den ANASAYFA'ya (bir ust html sayfaya) gecis yapar !!!!!!!!!!!!!
        WebElement elementalSeleniumLink = driver.findElement(By.xpath("//div[text()='Powered by ']"));

        Assert.assertTrue(elementalSeleniumLink.isDisplayed());
        System.out.println(elementalSeleniumLink.getText());


    }




}
