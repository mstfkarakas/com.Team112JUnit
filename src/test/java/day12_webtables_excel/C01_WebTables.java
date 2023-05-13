package day12_webtables_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01() {

        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        WebElement headerElement = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("headerElement.getText() = " + headerElement.getText());

        //  3. 3.sutunun basligini yazdirin
        List<WebElement> headersList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("================================");
        System.out.println(headersList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        WebElement completeTable = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println(completeTable.getText());


        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> dataList = driver.findElements(By.xpath("//div[@class='rt-td']"));

        int siraNo = 1;

        for (WebElement eachwebElement : dataList) {
            if (!(eachwebElement.getText().equals("") || eachwebElement.getText().equals(" "))) {
                System.out.println(siraNo + ". -" + eachwebElement.getText());
                siraNo++;
            }
        }

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> rowElementsList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("rowElementsList.size() = " + rowElementsList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        List<WebElement> coloumnList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("coloumnList.size() = " + coloumnList.size());
        //     Basta basliklar listesi olusturmustuk, onun size'ini alarak da yapabiliriz:
               System.out.println("headersList.size() = " + headersList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> thirdColumnDataList = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[3]"));

        for (WebElement eachwebElement : thirdColumnDataList) {
            if (!(eachwebElement.getText().equals("") || eachwebElement.getText().equals(" ")));{
                System.out.println(eachwebElement.getText());
            }
        }



        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //     index'i saydiralim, Kierra'yi bulunca , index'in 4 fazlasini yazdiralim.

        for (int i = 0; i < dataList.size(); i++) {
             if (dataList.get(i).getText().equals("Kierra")) {
                 System.out.println("The person's salary is " + dataList.get(i+4).getText() + " euros.");
             }
        }

        //10. Page sayfasinda bir method olusturun,
        //    Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin


        WebElement getElement = getElement(3,5);
        System.out.println(getElement.getText());

    }

    private WebElement getElement(int row, int coloumn) {

        String dynamicXpath = "(//div[@class='rt-tr-group'])[" + row + "]/div/div[" + coloumn + "]";
        WebElement istenenElement = driver.findElement(By.xpath(dynamicXpath));

        return istenenElement;
    }


}
