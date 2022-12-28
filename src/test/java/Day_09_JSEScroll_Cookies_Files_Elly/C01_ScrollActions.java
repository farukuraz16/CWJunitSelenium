package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C01_ScrollActions extends BaseTest {

    @Test
    public void scrollDownUp(){
        driver.get("https://www.amazon.com.tr/");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        act.sendKeys(Keys.PAGE_DOWN).perform();
        act.sendKeys(Keys.PAGE_UP).perform();
        act.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void scrollArrowUpDown () throws InterruptedException {
        driver.get("https://amazon.com");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);

    }
}
