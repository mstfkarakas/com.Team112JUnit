package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionMethods {

    static WebDriver driver;

    @BeforeClass
    // @BeforeClass and @AfterClass kullanan methodlar static olmak zorundadir.

    public static void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("SetUp method'u calisti");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
        System.out.println("tearDown methos'u calisti");
    }

    @Test
    public void test01() {       // 1.method'da amazon'a gidip, amazona gittigimizi test edin
        driver.get("https://www.amazon.com");
        String expectedWord = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedWord));

    }

    @Test // test01'de amazon.com'a gittik, bu yuzden test02 kendi kendine calismaz.
    public void test02() {      // 2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        String expectedWord = "Nutella";
        WebElement searchResult = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String searchResultSTR = searchResult.getText();

        Assert.assertTrue(searchResultSTR.contains(expectedWord));
    }

    @Test
    public void test03() {      // 3.method'da nutella arama sonuc sayisinin 45'den fazla oldugunu test edin
        WebElement searchResult = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String searchResultSTR = searchResult.getText();

        //  System.out.println(searchResultSTR);  // "48 results for 'Nutella'" cikti. Burdan 48 sayisini integer olarak almaliyiz:

        String[] searchResultArr = searchResultSTR.split(" "); // [48, results, for, 'Nutella', ...]
        String resultCountStr = searchResultArr[0]; // "48"
        int resultCountInt = Integer.parseInt(resultCountStr); // 48

        int expectedResultCount = 45;

        Assert.assertTrue(resultCountInt > expectedResultCount);
    }
}
