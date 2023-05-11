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

    static WebDriver driver;

    @BeforeClass // @BeforeClass ve @AfterClass static olmak zorundadir.
    public static void setUp() {
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

        String expectedWord = "Nutella";
        WebElement nutellaResults= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String nutellaResultsSTR = nutellaResults.getText();


        if (nutellaResultsSTR.contains(expectedWord)) {
            System.out.println("Nutella search test PASSED");
        }else {
            System.out.println("Nutella search test FAILED");

        }

    }

    @Test
    public void test03() {
        WebElement nutellaResults= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String nutellaResultsSTR = nutellaResults.getText();
        System.out.println(nutellaResultsSTR);
        String[] nutellaResultsArr = nutellaResultsSTR.split(" ");
        String resultCountSTR = nutellaResultsArr[2];

        int resultCountINT = Integer.parseInt(nutellaResultsSTR);

        int expectedresultCount = 50;

        if (resultCountINT>expectedresultCount) {
            System.out.println("test 3 PASSED");
        }else {
            System.out.println("test 3 FAILED");

        }

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }


}
