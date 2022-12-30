package Day_12_Screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class C02_Screenshots extends BaseTest {

    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://www.n11.com/");

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("test-output/Screenshots/n11Screenshot.png"));
    }

    @Test
    public void getElementScreenshot() throws IOException {
        /*
        Go to URL: https://opensource-demo.orangehrmlive.com/
Saving the image to  the path.
Getting screenshot of Orange HRM Logo.
Getting screenshot of  Orange HRM Page Section.
         */
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement logo = driver.findElement(By.className("orangehrm-login-branding"));
        File logoScreenShot = logo.getScreenshotAs(OutputType.FILE);

        //sektöre dosya adınatarih saat eklenir..
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String path = "test-output/Screenshots/logoScreenShot_"+date+".png";
        FileUtils.copyFile(logoScreenShot,new File(path));




    }
}
