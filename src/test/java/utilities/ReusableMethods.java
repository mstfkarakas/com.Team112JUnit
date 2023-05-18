package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void wait(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }

    }

    public static void screenShotFullPage(WebDriver driver) {
        // Tum sayfanin screenshot'ini almak icin:

        // 1-TakeScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2-Resmi kaydedecegimiz klasor ve dosya ismi olusturalim
        // Her resim cektiginde eskisini silip yenisini eklememesi icin tarih ve zaman girelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ldt.format(dtf);
        String filePath = "target/screenshots/fullPageSS" + date + ".jpeg";

        File entirePageScreenshot = new File(filePath);
        // 3-tss method'u kullanarak ekran goruntusu alip, gecici dosyaya kaydet
        File temporaryFile = tss.getScreenshotAs(OutputType.FILE);
        // 4-gecici dosyayi ana dosyaya kopyala
        try {
            FileUtils.copyFile(temporaryFile,entirePageScreenshot);
        } catch (IOException e) {

        }
    }

    public static void takeElementScreenshot(WebElement searchResultElement) {

        // arama sonuclarinin Screenshot'ini alin
        // 1- Locate et. (Yukarda locate ettik.)
        // 2- Kaydedecegimiz dosyayi olustur
    /*
    Lets' add here the date and time as the file name just like we did with the above method:
    */
                LocalDateTime ldt = LocalDateTime.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String date = ldt.format(dtf);
                String filePath = "target/screenshots/elementSS" + date + ".jpeg";


        File elementSS = new File(filePath);

        // 3- Gecici dosyayi olusturup, element uzerinden screenshot yapalim
        File tempFile = searchResultElement.getScreenshotAs(OutputType.FILE);

        // 4- Gecici dosyayi hedef dosyaya kopyala
        try {
            FileUtils.copyFile(tempFile,elementSS);
        } catch (IOException e) {

        }
    }
}
