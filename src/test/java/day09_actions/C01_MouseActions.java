package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_MouseActions extends TestBase {

    @Test
    public void test01() {

//        1- Yeni bir class olusturalim: MouseActions
//        2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        3- Cizili alan uzerinde sag click yapin (Mouse hareketi oldugu icin Actions kullanmak lazim)
        Actions actions = new Actions(driver);
        WebElement dashedAreaElement = driver.findElement(By.id("hot-spot"));

        actions.contextClick(dashedAreaElement).perform();  //perform() olmazsa calismaz.

//        4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedMessage = "You selected a context menu";
        String actualMessage = driver.switchTo().alert().getText();

        Assert.assertTrue(actualMessage.equals(expectedMessage));
        ReusableMethods.wait(2);

//        5- Tamam diyerek alert’i kapatalim. (Yani accept ile kapatmak lazim)
        driver.switchTo().alert().accept();
        ReusableMethods.wait(2);

        String firstPageWHValue = driver.getWindowHandle();
//        6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        ReusableMethods.wait(2);

//        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim.
//        Bunun icin click yapmadan once, 6-'dan once, ilk sayfanin WindowHandle degerini almaliyim.
        String secondPageWHBValue = "";
        Set<String> firstAndSecondPagesWHValues = driver.getWindowHandles();

        for (String eachWH : firstAndSecondPagesWHValues) {
            if (!eachWH.equals(firstPageWHValue)) {
                secondPageWHBValue = eachWH;
            }
        }

        driver.switchTo().window(secondPageWHBValue); //driver'i ikinci sayfaya tasiyabildik.
        String expectedText = "Elemental Selenium";
        String actualText = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedText,actualText);

        ReusableMethods.wait(3);
    }

}

