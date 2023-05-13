package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_01_handleDropdownMenu {
    // ilgili ayarlari yapin
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
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'in java icerdigini test edin
        // Dropdown menuden istedigimiz option'i secebilmek icin oncelikle Select class'indan bir obje olusturmaliyiz
        // Ancak select objesi olusturmak icin Select class'inin constructor'i handle edecegimiz webelemnt'i istediginden

        // 1 - select objesi olusturmadan once dropdown webelemntini locate etmeliyiz
        WebElement dropDownWebElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- Select class'indan obje olusturalim
        Select select = new Select(dropDownWebElement);

        // 3- select objesini kullanarak istedigimiz method/method'lari calistirin. We can select a menu in 3 different ways;

    //    i-
        select.selectByVisibleText("Books");
    //    ii-select.selectByValue("search-alias=stripbooks-intl-ship");
    //    iii- select.selectByIndex(5);
        Thread.sleep(1500);

        // arama kutusuna java yazdirip aramayi yapin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        System.out.println(driver.getTitle());  // Amazon.com: Java
        // title'in java icerdigini test edin

        String expectedWord = "Java";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedWord));

        // dropdown menuden Books seceneginin secildigini test edin
        /*
           Locate ettigimiz elementi bulamazsa NoSuchElementException
           sayfa yenilendigi icin var olan bir elementi kullanamazsa StaleElementException verir
           bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir
         */

        dropDownWebElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownWebElement);

        String actualSelectedOption = select.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Books";

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);

        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin

        List<WebElement> optionsWebElementList = select.getOptions();
        int actualOptionsCount = optionsWebElementList.size();
        int expectedOptionsCount = 28;

        Assert.assertEquals(actualOptionsCount,expectedOptionsCount); // True/Passed

    }
}