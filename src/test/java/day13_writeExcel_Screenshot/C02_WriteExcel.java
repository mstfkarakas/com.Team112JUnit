package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {
        // Excel dosyasindan kopyaladigimiz workbook objeci uzerinde degisiklik yapaboliriz. Excel'in kopyasi olan workbook'u olustruralim.

        String filePath = "src/test/java/day12_webtables_excel/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // 5. sutun olarak nufus basligi ile bir sutun olusturalim.

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        // 3. Satirdaki nufus bilgisini 1.5 milyon yapalim

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        // 7. Satirdaki nufus bilgisini 3 milyon yapalim

        workbook.getSheet("Sheet1").getRow(6).createCell(4).setCellValue("3000000");

        // yaptigimiz degisiklikler kopya workbook uzerinde
        // bu degisiklikleri excel dosyasina kaydetmek icin
        // bunun icin FileOutputStream class'ini kullanmaliyiz

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();

    }
}
