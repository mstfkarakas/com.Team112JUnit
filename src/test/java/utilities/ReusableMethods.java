package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
}
