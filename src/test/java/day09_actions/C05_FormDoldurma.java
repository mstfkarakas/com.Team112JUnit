package day09_actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormDoldurma extends TestBase {

    @Test
    public void test01() {
        // facebook.com sayfasina gidin
        driver.get("https://www.facebook.com/");

        // cookies'i kabul et

        // yeni hesap olustur butonuna basin
        driver.findElement(By.linkText("Create new account")).click();

        // ilgili alanlari faker kutuphanesinden degerlerle doldurup
        WebElement firstNameBox = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String emailAddress = faker.internet().emailAddress(); //Bunu onden urettik cunku, kayitolurken emaili girince, sonradan bir kutu daha acip emaili tekrar istiyor.
        ReusableMethods.wait(3);
        actions.click(firstNameBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(emailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(emailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)  // Bu arada ki ?'ne gidiyor
                .sendKeys(Keys.TAB)  // Dogum gunu rakam olarak
                .sendKeys("11")
                .sendKeys(Keys.TAB) // Dogum ayi
                .sendKeys("Apr")
                .sendKeys(Keys.TAB) // Dogum yili
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)   // lands on Female
                .sendKeys(Keys.RIGHT) // jumps to Male

                .perform();

        // kaydol butonuna basin
        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();

        // Kayit olamadiginizi test edin
        // WebElement hataMesajElementi= driver.findElement(By.id("reg_error_inner"));
        // Assert.assertTrue(hataMesajElementi.isDisplayed());

        ReusableMethods.wait(10);
    }
}
