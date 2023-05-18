package day13_writeExcel_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_JSExecutor extends TestBase {
    @Test
    public void test01(){

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // sell linkine JS executor kullanarak click yapin

        WebElement sellLink = driver.findElement(By.xpath("//a[text()='Gift Cards']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click()",sellLink);  // Internetten bulabilirsin: arguments[0].click()

        jse.executeScript("alert('Bu is bu kadar, yasasin!')");

        ReusableMethods.wait(3);


    }
}
