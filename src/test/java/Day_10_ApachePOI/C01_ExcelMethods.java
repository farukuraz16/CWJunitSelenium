package Day_10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {
    public static void main(String[] args) throws IOException {

        //Excel dosyamızın pathini aldık
        String path = "src/test/java/resources/excelfile.xlsx";

        //dosyamızı açtık
        FileInputStream fileInputStream = new FileInputStream(path);

        //açtığımız dosyayı excel workbooka çevirdik
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //çalışacağımız sheete geçiş yaptık
        Sheet sheet1 = workbook.getSheetAt(0);

        Row row1 = sheet1.getRow(0);

        Cell cell1 = row1.getCell(0);

        System.out.println("cell1 = " + cell1);
        System.out.println("cell1 = " + cell1.toString().toLowerCase());

    }


}
