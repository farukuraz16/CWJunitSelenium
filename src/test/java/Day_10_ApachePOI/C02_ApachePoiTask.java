package Day_10_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePoiTask {
    /*
    //    Add the excel file on the resources folder.
//    Open the file.
//    Open the workbook using file input stream.
//    Open the first worksheet.
//    Go to first row.
//    Go to first cell on that first row and print.
//    Go to second cell on that first row and print.
//    Go to 2nd row first cell and assert if the data equal to Russia.
//    Go to 3rd row 2nd cell-chain the row and cell.
//    Find the number of used row.
//    Print country, area key value pairs as map object.
     */

    public static void main(String[] args) throws IOException {
        String path = "src/test/java/resources/excelfile.xlsx";

//    Open the file.

        FileInputStream fileInputStream = new FileInputStream(path);
//    Open the workbook using file input stream.

        Workbook workbook = WorkbookFactory.create(fileInputStream);


        //    Open the first worksheet.
//    Go to first row.


//    Go to first cell on that first row and print.
        Sheet sheet1 = workbook.getSheetAt(0);
        Row row1 = sheet1.getRow(0);

        Cell r1cell1 = row1.getCell(0);
//    Go to second cell on that first row and print.

        Cell r1cell2 = row1.getCell(1);

        System.out.println("r1cell1 = " + r1cell1);
        System.out.println("r1cell2 = " + r1cell2);

//    Go to 2nd row first cell and assert if the data equal to Russia.
        Row row2 = sheet1.getRow(1);
        Cell r2cell1 = row2.getCell(0);
        Assert.assertEquals("Rusya", r2cell1.toString());


//    Go to 3rd row 2nd cell-chain the row and cell.
        Cell r3cell2 = sheet1.getRow(2).getCell(1);
        System.out.println("r3cell2 = " + r3cell2);

        //    Find the number of used row.
        System.out.println("sheet1.getPhysicalNumberOfRows() = " + sheet1.getPhysicalNumberOfRows());//satır sayısını verir
        System.out.println("sheet1.getLastRowNum() = " + sheet1.getLastRowNum());//index numberı verir


//    Print country, area key value pairs as map object.
        int totalRows = sheet1.getPhysicalNumberOfRows();
        Map<String,String> countryAreas = new HashMap<>();

        for (int row = 1; row < totalRows ; row++) {
            String country = sheet1.getRow(row).getCell(0).toString();

            //System.out.println(row + ". sıradaki ülke = " + country);

            String area = sheet1.getRow(row).getCell(1).toString();
            System.out.println("Country = " + country+ " - Area = " + area);

            //ülke adı ve yüzölçümü değerlerini hashmap'e ekliyoruz.
            countryAreas.put(country,area);
        }
        System.out.println("countryAreas = " + countryAreas);
    }
}
