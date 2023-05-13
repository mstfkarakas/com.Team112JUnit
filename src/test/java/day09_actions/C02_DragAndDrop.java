package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_DragAndDrop extends TestBase {

    @Test
    public void test01() {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMeElement = driver.findElement(By.id("draggable"));
        WebElement dragHereElement = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement,dragHereElement).perform();
        ReusableMethods.wait(2);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement afterDropText = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(afterDropText.isDisplayed());

    }
}
