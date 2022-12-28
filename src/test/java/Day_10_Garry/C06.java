package Day_10_Garry;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C06 extends BaseTest {


    @Test
    public void test() throws InterruptedException {
        /*
    1- https://html.com/tags/iframe/ sayfasına gidelim.
    2- Video'yu görecek kadar aşağı inin.
    3- Videoyu izlemek için Play tuşuna basın.
    4- Videoyu çalıştırdığınızı test edin.
*/
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        WebElement iframe= driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(iframe);

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        button.click();

        Assert.assertFalse(button.isDisplayed());



    }
}
