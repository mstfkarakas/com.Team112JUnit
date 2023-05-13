package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

//    ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

//    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "The Internet";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println("ilkSayfaHandleDegeri = " + ilkSayfaHandleDegeri);

//    ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(1500);

         /*
           Kontrolsuz acilan tab'a gecis yapmak icin
           1- ilk sayfada iken o sayfanin WHD alip kaydedin
           2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
           3- su anda elimizde 2 elementli bir Set var, elementlerden bir tanesi 1.sayfanin WHD. O zaman 1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
           4- bu sekilde 2.sayfanin WHD elde edildikten sonra, WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
         */

        Set<String> tumWHDegerlerSeti = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri = "";
        for (String eachWH : tumWHDegerlerSeti) {
            if (!eachWH.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri = eachWH;
            }
        }

//    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        String actualNewPageTitle = driver.getTitle();
        String expectedNewPageTitle = "New Window";
        Thread.sleep(1500);
        Assert.assertEquals(expectedNewPageTitle, actualNewPageTitle);

//    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualNewText = driver.findElement(By.tagName("h3")).getText();
        String expectedNewText = "New Window";
        Assert.assertEquals(expectedNewText,actualNewText);

//    ● Bir önceki pencereye geri döndükten sonra
        driver.switchTo().window(ilkSayfaHandleDegeri);

//    ● sayfa başlığının “The Internet” olduğunu doğrulayın.
        actualPageTitle = driver.getTitle();
        expectedPageTitle = "The Internet";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        Thread.sleep(1500);

    }
}