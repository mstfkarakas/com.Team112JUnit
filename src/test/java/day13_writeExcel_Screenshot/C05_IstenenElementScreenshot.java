package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_IstenenElementScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        // Amazon'da nutella aratin
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        //sonuclarin Nutella icirdigini test edin
        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']"));
        String expectedWord = "Nutella";
        String actualWord = searchResultElement.getText();

        ReusableMethods.wait(3);

        Assert.assertTrue(actualWord.contains(expectedWord));

    // arama sonuclarinin Screenshot'ini alin
        // 1- Locate et. (Yukarda locate ettik.)
        // 2- Kaydedecegimiz dosyayi olustur
        File elementSS = new File("target/screenshots/elementSS.png");

        // 3- Gecici dosyayi olusturup, element uzerinden screenshot yapalim
        File tempFile = searchResultElement.getScreenshotAs(OutputType.FILE);

        // 4- Gecici dosyayi hedef dosyaya kopyala
        FileUtils.copyFile(tempFile,elementSS);

        // Bunu ReusableMethods'da method olarak olusturalim;
        ReusableMethods.takeElementScreenshot(searchResultElement);
    }
}
