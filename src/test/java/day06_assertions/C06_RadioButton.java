package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();   // facebook'a driver ile gidince Cookies cikacak karsimiza.
    }

    @Test
    public void test01() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	   https://facebook.com

        driver.get("https://facebook.com");

        //	b. Cookies’i kabul edin
        //  driver.findElement(By.xpath("//button[@title='Only allow essential cookies']")).click();


        //	c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //	d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("//*[text()='Male']")).click();


        Thread.sleep(3000);
    }


}
