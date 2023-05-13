package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {


        String filePath = "C:\\Users\\mstfk\\Desktop\\ms004-2205en-v2-f-Mustafa.pdf";

        FileInputStream fis = new FileInputStream(filePath);


        /*
            File testlerinde genellikle dowloads'a indirilecek bir dosyanin indirildigini test etmek
            veya masaustundeki bir dosyanin web'e upload edilebildigini test etmek isteriz.

            Ancak herkesin bilgisayirinin ismi, kullanici isimleri gibi farkliliklar
            olacagindan testler tek bir bilgisayarda calisacak gibi yazilmak zorunda kalinir.

            Bu karisikligin onune gecebilmek icin Java iki basit kod blogu sunmus
         */

        System.out.println(System.getProperty("user.dir"));  // C:\Users\mstfk\IdeaProjects\com.Team112JUnit
        // o anda calisan dosyanin (C01_FileInputStreeam) yolunu verir

        // kullanicinin temel path'ini verir.
        System.out.println(System.getProperty("user.home")); // C:\Users\mstfk


        // Masaustune gitmek istersek
        // /Users/ahmetbulutluoz + /Desktop eklememiz yeterlidir

        // Downloads'a gitmek istersek
        // /Users/ahmetbulutluoz + /Downloads eklememiz yeterlidir

        // Kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibi detaylara takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayardan alacak sekilde olustururuz

        // dosyaYolu="/Users/ahmetbulutluoz/Desktop/MerhabaJava.docx";

        String dynamicFilePath = System.getProperty("user.home") + "\\Desktop\\ms004-2205en-v2-f-Mustafa.pdf";
        System.out.println(dynamicFilePath);

    }
}
