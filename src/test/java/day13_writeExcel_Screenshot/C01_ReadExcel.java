package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // excel dosyalari bilgisayarimizda oldugu icin
        // Java'dan FileInputStream class'i yardimiyla ulasacagiz


        String filePath = "src/test/java/day12_webtables_excel/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));


        // satir ve sutun bilgisini parametre olarak alip
        // o hucredeki bilgiyi yazdiran bir method olusturun

        printData(25,2);
        printData(14,3);
    }

    private void printData(int row, int coloumn) throws IOException {

        String filePath = "src/test/java/day12_webtables_excel/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(row).getCell(coloumn));
    }
}
