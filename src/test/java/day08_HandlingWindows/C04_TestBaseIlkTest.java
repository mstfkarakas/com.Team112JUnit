package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01(){
        // amazon'a gidin
        driver.get("https://www.amazon.com/");
        ReusableMethods.wait(3);

        // amazon'a gittiginizi test edin.

        String expectedWord = "amazon";
        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedWord));
        ReusableMethods.wait(1);

    }
}
