package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01() {
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement ElementToMouseover = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);

        actions.moveToElement(ElementToMouseover).perform();
        ReusableMethods.wait(2);

        //3- “Create a list” butonuna basin
        driver.findElement(By.linkText("Create a List")).click();
        ReusableMethods.wait(2);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListsElement = driver.findElement(By.xpath("//div[@aria-level='1']"));

        Assert.assertTrue(yourListsElement.isDisplayed());

        //div[@aria-level='1']

    }
}
