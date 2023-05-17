package day13_writeExcel_Screenshot;

import com.github.dockerjava.api.model.CpuStatsConfig;
import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C04_TakeScreenshotFullPage extends TestBase {
    @Test
    public void test01() throws IOException {

        driver.get("https://www.wisequarter.com/");

        String expectedWord = "wisequarter";
        String actualword = driver.getCurrentUrl();

        Assert.assertTrue(actualword.contains(expectedWord));

        ReusableMethods.screenShotFullPage(driver);



    }

}
