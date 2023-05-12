package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_06_RadioButton {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }

    @After
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("Mustafa");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Male']")).click();
        Thread.sleep(3000);

    }
}
