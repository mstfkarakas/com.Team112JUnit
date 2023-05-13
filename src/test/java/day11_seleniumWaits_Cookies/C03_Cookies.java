package day11_seleniumWaits_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void test01() {

        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin


        Set<Cookie> cookiesSet = driver.manage().getCookies();

        int siraNo = 1;

        for (Cookie eachCookie : cookiesSet) {
            System.out.println(siraNo + "- " + eachCookie);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size() > 5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedcookieValue = "USD";
        String actualcookieValue = "";

        for (Cookie eachcookie : cookiesSet) {
            if (eachcookie.getName().equals("i18n-prefs")) {
                actualcookieValue = eachcookie.getValue();
            }
        }
        Assert.assertEquals(expectedcookieValue, actualcookieValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        //   ve sayfaya ekleyin

        Cookie myCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(myCookie);


        cookiesSet = driver.manage().getCookies();
        siraNo = 1;

        for (Cookie eachCookie : cookiesSet) {
            System.out.println(siraNo + "- " + eachCookie);
            siraNo++;


        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        expectedcookieValue = "cikolatali";
        int cikolataliCookieCount=0;

        for (Cookie eachcookie : cookiesSet) {
            if (eachcookie.getName().equals("en sevdigim cookie")) {
                cikolataliCookieCount++;
            }
        }
        Assert.assertTrue(cikolataliCookieCount>0);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        cookiesSet = driver.manage().getCookies();

        int skinCookieCount=0;

        for (Cookie eachcookie : cookiesSet) {
            if (eachcookie.getName().equals("skin")){
                skinCookieCount++;

            }
        }
        Assert.assertEquals(0,skinCookieCount);


        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();

        Assert.assertEquals(0,cookiesSet.size() );


    }
}
