package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01() {


//    1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

//    2. flower.jpeg dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='flower.jpeg']")).click();
        ReusableMethods.wait(3);
//    3. Dosyanın başarıyla indirilip indirilmediğini test edelim
//       Test icin oncelikle dosyanin indirildiginde dosyaYolu ne olacak bunu olusturmaliyiz

        String filePath = System.getProperty("user.home") + "\\Downloads\\flower.jpeg";

        // Bir dosyanin bilgisayarimizda var oldugunu (exist) test etmek icin
        // Java'daki Files class'indan yardim alacagiz

        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }

    @Test
    public void test02(){

        // Masaustunde Merhabajava.docx dosyasi oldugunu test edin
        // dinamik dosya yolu olusturalim

        String filePath = System.getProperty("user.home") + "\\Desktop\\MerhabaJava.txt";

        // Assert edelim

        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}
