package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C02_ScrolWithJSExecutor extends BaseTest {

    /*
    executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
    x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse saga hareket eder.
    y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel asagi kaydır
            js.executeScript("window.scrollTo(0, 0)");  // en asagiya gider
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // en asagiya gider
    // scrollTo : Verilen pixele gider.
    // scrollBy : Verilen kadar daha ileri gider.
    scrollIntoView () web sayfasindaki bir ogenin gorunurlulugune gore kaydirir
           js.executeScript("arguments[0].scrollIntoView();"  , webelement);
    */

    /*
    go to url : https://api.jquery.com/dblclick/
    double click on the blue square at the bottom of the page and then write the changed color.
     */
    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);

        WebElement blueBox = driver.findElement(By.cssSelector("body>div"));
        //iframe içinde bir tane body>div olduğu için bu şekilde yazdık.
        //normalde 4 tane var. ancak şu anda iframe içindeyiz. ve iframe içindeki body>div'i alacaktır.

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //sadece driver yazdığımızda altı kızarır. cast etmemiz gerekir.
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", blueBox);
        //blueBox elementine kadar aşağı doğru scroll yap...
        Thread.sleep(2000);
        System.out.println("blueBox color before = " + blueBox.getCssValue("background-color"));

        Actions act = new Actions(driver);
        act.doubleClick(blueBox).perform();
        Thread.sleep(2000);
        System.out.println("blueBox color after= " + blueBox.getCssValue("background-color"));


    }


}
