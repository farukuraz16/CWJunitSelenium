package Day_11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class C02_WriteExcelExample02 {
    /*
    Create an object of File class to open xlsx file.
Create an object of FileInputStream class to read excel file.
Create an object of FileInputStream class to read excel file.
Creating workbook instance that refers to .xlsx file.
Creating a Sheet object.
Get all rows in the sheet.
Create a row object to retrieve row at index 3.
Create a cell object to enter value in it using cell Index.
Write the data in excel using output stream.
     */

    @Test
    public void test() throws IOException {

        //dosyamızın pathini aldık
        String filePath = "src/test/java/resources/excelData.xlsx";
        //dosyamızın pathini kullanarak bir file oluşturduk.
        File file = new File(filePath);
        //dosyamızı açtık
        FileInputStream fis = new FileInputStream(file);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet information = workbook.getSheet("informationData");//sheet ismiyle sheet oluşturduk..

        //total row sayısını bulduk
        int totalrowNumber = information.getLastRowNum()- information.getFirstRowNum();

        System.out.println("totalrowNumber = " + totalrowNumber);



        Row row5 = information.createRow(4);//getRow methodu kullanırsak içinde bir işlem yapamayız

        row5.createCell(0).setCellValue("faruk");
        row5.createCell(1).setCellValue("uraz");
        row5.createCell(2).setCellValue("uraz@gmail.com");
        row5.createCell(3).setCellValue("mail");
        row5.createCell(4).setCellValue("12343456");
        row5.createCell(5).setCellValue("addddrrrreeeesss");

        //yaptığımız değişillikleri uygulayabilmek için outputstream oluşturmalıyız..
        FileOutputStream fos = new FileOutputStream(file);

        //FileOutputStream oluşturduktan sonra workbookumuza yazma işlemini gerçekleştirebiliriz.
        workbook.write(fos);

        //ardından tüm işlemleri kapatıroyurz.
        fis.close();
        fos.close();
        workbook.close();

    }
}
