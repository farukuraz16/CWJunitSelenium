package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C03_RobotClass extends BaseTest {

    @Override
    public void tearDown() {

    }

    @Test
    public void upload() throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement input = driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("/Users/faruk/IdeaProjects/CWJunitSelenium/src/test/java/resources/robot.pages");

        Robot robot = new Robot();

        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);//tuşa bas
        robot.keyPress(KeyEvent.VK_S);

        Thread.sleep(2000);


        robot.keyRelease(KeyEvent.VK_CONTROL);//tuştan çek
        robot.keyRelease(KeyEvent.VK_S);

        Thread.sleep(2000);


        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_LEFT);//sol ok
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

    }
}
