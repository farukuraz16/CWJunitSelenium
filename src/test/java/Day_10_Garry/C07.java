package Day_10_Garry;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.Set;

public class C07 extends BaseTest {
    /*
    1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2- Çizili alan üzerinde sağ click yapalım.
    3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4- Tamam diyerek Alert'i kapatalım.
    5- Elemental Selenium linkine tıklayalım.
    6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
 */

    @Test
    public void Test() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotspot = driver.findElement(By.id("hot-spot"));

        String firstPage= driver.getWindowHandle();
        Actions actions = new Actions(driver);
        actions.contextClick(hotspot).perform();


        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");

        driver.switchTo().alert().accept();

        WebElement elemental = driver.findElement(By.linkText("Elemental Selenium"));
        elemental.click();


        String secondPage="";
        Set<String> pages = driver.getWindowHandles();
        for (String str:pages
             ) {if (!str.equals(firstPage)){
                 secondPage=str;
        }

        }
        driver.switchTo().window(secondPage);

        WebElement head = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(head.getText(),"Elemental Selenium");

    }
}
