package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TakeScreenshotTumSayfa extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon'a gidip
        driver.get("https://www.amazon.com/");
        // Nutella aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edin
        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']"));
        String expectedWord = "Nutella";
        String actualWord = searchResultElement.getText();

        ReusableMethods.wait(3);

        Assert.assertTrue(actualWord.contains(expectedWord));

/*
        // Tum sayfanin screenshot'ini almak icin:

        // 1-TakeScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2-Resmi kaydedecegimiz klasor ve dosya ismi olusturalim
        File entirePageScreenshot = new File("target/screenshots/entirePageSS.jpeg");
        // 3-tss method'u kullanarak ekran goruntusu alip, gecici dosyaya kaydet
        File temporaryFile = tss.getScreenshotAs(OutputType.FILE);
        // 4-gecici dosyayi ana dosyaya kopyala
        FileUtils.copyFile(temporaryFile,entirePageScreenshot);
*/
        ReusableMethods.screenShotFullPage(driver);

        ReusableMethods.wait(3);

    }
}
