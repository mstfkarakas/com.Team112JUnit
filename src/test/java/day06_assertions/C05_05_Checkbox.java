package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_05_Checkbox {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	   https://the-internet.herokuapp.com/checkboxes
    //	b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //	c. Checkbox1 seçili değilse onay kutusunu tıklayın ve secili oldugunu test edin
    //	d. Checkbox2 seçili değilse onay kutusunu tıklayın ve secili oldugunu test edin

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        Thread.sleep(1000);
        Assert.assertTrue(checkbox1.isSelected());

        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected());

        // Thread.sleep(3000);
    }
}
