package Day_10_Garry;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C08 extends BaseTest {
/*
    1- https://demoqa.com/droppable adresine gidelim.
    2- "Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım.
    3- "Drop here" yazısı yerine "Dropped!" olduğunu test edin.
*/

    @Test
    public void test() {
        driver.get("https://demoqa.com/droppable");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(drag,drop).perform();

Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Dropped!']")).getText(),"Dropped!");



    }
}
