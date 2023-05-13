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

public class C03_WindowHandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium"));

        // linke tikladigimizda yeni sayfa acilacagindan
        // click yapmadan once ilk sayfanin WHD'ini alip kaydedelim
        String ilkSayfaWHDegeri = driver.getWindowHandle();

        // click yapinca yeni tab acilir ancak driver eski tab'da kalir
        // yeni tab'a driver'i gecirmek icin yeni tab'in WHD ihtiyacimiz var
        Set<String> ikiSayfaninWHDegerleriSeti = driver.getWindowHandles();
        String ikincisayfaninWHDegeri = "";

        for (String eachWH : ikiSayfaninWHDegerleriSeti) {
            if (!eachWH.equals(ilkSayfaWHDegeri)) {
                ikincisayfaninWHDegeri = eachWH;
            }
        }

        // foreach loop bittiginde ikinci sayfanin WHD'ini elde etmis olacagiz
        // bu degeri kullanarak, driver'i 2.sayfaya  gecirebiliriz
        driver.switchTo().window(ikincisayfaninWHDegeri);
        Thread.sleep(3000);

        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        String expectedTextSecondPage = "Elemental Selenium";
        String actualTextSecondPage = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertEquals(expectedTextSecondPage, actualTextSecondPage);
        Thread.sleep(2000);

        // ilk sayfaya geri donup
        driver.switchTo().window(ilkSayfaWHDegeri);

        // sayfadaki yazinin "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin.
        String expectedTextFirstPage = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualTextFirstPage = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedTextFirstPage, actualTextFirstPage);
        Thread.sleep(2000);



    }
}
