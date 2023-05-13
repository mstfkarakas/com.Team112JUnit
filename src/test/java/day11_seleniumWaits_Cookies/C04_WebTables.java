package day11_seleniumWaits_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;


public class C04_WebTables extends TestBase {

    @Test
    public void test01() {

//    1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

//    2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

//    3.Web table tum body’sini yazdirin
//      WebElement tumBody = driver.findElement(By.xpath(""));  // ???????

//    4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        Assert.assertEquals(10,rows.size());

//    5.Tum satirlari yazdirin
        for (WebElement eachrow : rows) {
            System.out.println(eachrow.getText());
        }

//    6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> thirdRowColoumnList = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13, thirdRowColoumnList.size());

//    7. 5.sutunu yazdirin
        List<WebElement> fifthColoumnElements = driver.findElements(By.xpath("//tbody/tr/td[5]"));

        System.out.println("==========================");
        for (WebElement eachElement : fifthColoumnElements) {
            System.out.println(eachElement.getText());
            System.out.println("------------------------");
        }

//    8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        WebElement rowColoumnCount = getElement(3,7);
        System.out.println(rowColoumnCount.getText()); // getElement metodu asagida.

        ReusableMethods.wait(5);

    }

    private WebElement getElement(int row, int coloumn) {

        String dynamicXpath = "//tbody/tr["+ row + "]/td[" + coloumn + "]";
        // String xpath = "//tbody/tr[3]/td[5]";

        WebElement istenenElement = driver.findElement(By.xpath(dynamicXpath));

        return istenenElement;
    }

}
