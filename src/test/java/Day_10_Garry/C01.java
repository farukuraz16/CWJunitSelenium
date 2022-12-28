package Day_10_Garry;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C01 extends BaseTest {

    /*
    1- https://www.amazon.com/ sayfasına gidelim.
    2- Arama kutusunu locate edelim.
    3- "Samsung headphones" ile arama yapalım.
    4- Bulunan sonuç sayısını yazdıralım.
    5- İlk ürünü tıklayalım.
    6- Sayfadaki tüm ürün başlıklarını yazdıralım.,
 */

    @Test
    public void test() {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Type C converter"+ Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("result.getText() = " + result.getText());

        WebElement firstPro = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        firstPro.click();

        driver.navigate().back();

        List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w:products
             ) {
            System.out.println("w.getText() = " + w.getText());

        }


    }




}

