package Day_12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_Webtables extends BaseTest {

    @Override
    public void tearDown() {

    }

    @Test
    public void webtableexample() {
    /*
    Go to URL: http://demo.guru99.com/test/web-table-element.php
    To find third row of table
    To get 3rd row's 2nd column data
    Get all the values of a Dynamic Table
    */

        driver.get("http://demo.guru99.com/test/web-table-element.php");

        WebElement table = driver.findElement(By.className("dataTable"));

    //To find third row of table

        //table[@class='dataTable']//tr[3]
        //             .           //tr[3]
        WebElement row3 = table.findElement(By.xpath(".//tr[3]"));
//table elementinde aradığımız bir alt element olduğu için table elementini temsilen . koyuruyoruz
        //sonra locationın devamını yazıyoruz.

        System.out.println("row3.getText() = " + row3.getText());

        //To get 3rd row's 2nd column data
        WebElement row3cell3 = row3.findElement(By.xpath(".//td[3]"));
        System.out.println("row3cell3.getText() = " + row3cell3.getText());

        //    Get all the values of a Dynamic Table

        int satirSayisi= table.findElements(By.xpath(".//tr")).size();
        System.out.println("satirSayisi = " + satirSayisi);

        int sutunSayisi= row3.findElements(By.xpath(".//td")).size();
        System.out.println("sutunSayisi = " + sutunSayisi);


        for (int i = 1; i <=satirSayisi ; i++) {

            for (int j = 1; j <=sutunSayisi ; j++) {
                //her satırın sütunu
                By locator = By.xpath(".//tr["+i+"]//td["+j+"]");
                WebElement tableData = table.findElement(locator);

                System.out.print(tableData.getText() + " - ");
            }
            System.out.println();
        }



     /*
        for (int i = 1; i<=satirSayisi; i++){
            //her bir satir


            for (int j = 1; j<=sutunSayisi; j++){
                // her satirin sutunu
                By locator = By.xpath(".//tr["+ i +"]//td[" + j + "]");
                WebElement tableData = table.findElement(locator);
System.out.print(tableData.getText() + " ");
            }

            System.out.println();

        }
*/


    }
}
