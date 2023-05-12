package day06_assertions;

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

public class C04_04_BestbuyAssertion {
      /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        ○ logoTest => BestBuy logosunun görüntülendigini test edin
        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teaDown() {
        driver.close();
    }

    @Test
    public void test01() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.bestbuy.com/";

        Assert.assertEquals(expectedURL, actualURL); // TRUE -> PASSED

    }

    @Test
    public void test02() {
        String actualTitle = driver.getTitle();
        String notExpectedWord = "Rest";

        Assert.assertFalse("Title doesn't contain 'Rest'", actualTitle.contains(notExpectedWord));
    }

    @Test
    public void test03() {

        WebElement logoElement = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());

    }

    @Test
    public void test04() {

        WebElement francaisLink = driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisLink.isDisplayed());
    }

}
