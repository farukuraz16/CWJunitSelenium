package Day_11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelExample  {
/*
Store the path of the file as string and open the file.
Open the workbook.
Open the first worksheet.
Go to the first row.
Create a cell on the 3rd column (2nd index) on the first row.
Write “POPULATION” on that cell.
Create a cell on the 2nd row 3rd cell(index2), and write data.
Create a cell on the 3rd row 3rd cell(index2), and write data.
Create a cell on the 4th row 3rd cell(index2), and write data.
Write and save the workbook.
Close the file.
Close the workbook.
 */

    @Test
    public void writeExcel() throws IOException {

    String path = "src/test/java/resources/excelfile.xlsx";

        // Dosyamizi aciyoruz
        FileInputStream fileInputStream = new FileInputStream(path);
        //Dosyamizi bir workbook haline getiriyoruz
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet2 = workbook.getSheetAt(1);//2. sheet
        Row row1 = sheet2.getRow(0);//1. satır
        Cell r1cell3 = row1.createCell(2);//3. hücreye erişiyoruz ve buraya değişiklik yapacağız
        r1cell3.setCellValue("POPULATION");

        //aynı sütunda olduğu için hep 3. hücreyi yani index 2 yi seçeceğiz..
        sheet2.getRow(1).createCell(2).setCellValue("Rusya'nın Popülasyonu");
        sheet2.getRow(2).createCell(2).setCellValue("Çin'in Popülasyonu");
        sheet2.getRow(3).createCell(2).setCellValue("ABD'nin Popülasyonu");

        //yukarıdaki değişikleri yazdırıyoruz-->>
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream); //workbookumuz yaptığımız değişiklikleri yazıyoruz.

        //dosyalarımızı kapatıyoruz..
        fileOutputStream.close();
        fileInputStream.close();

        //workbookumuzu kapatıyoruz.
        workbook.close();


    }
}
