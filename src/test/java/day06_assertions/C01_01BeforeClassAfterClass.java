package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_01BeforeClassAfterClass {
    // 3 ayri test method'u olusturun
    // 1.method'da amazon'a gidip, amazona gittigimizi test edin
    // 2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
    // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        String actualTitle = driver.getTitle();
        String expectedWord = "Amazon";

        if (actualTitle.contains(expectedWord)) {
            System.out.println("Entry to Amazon website PASSED");
        } else {
            System.out.println("Entry to Amazon website FAILED");
        }

    }

    @Test
    public void test02() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

    }

    @Test
    public void test03() {


    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }


}
