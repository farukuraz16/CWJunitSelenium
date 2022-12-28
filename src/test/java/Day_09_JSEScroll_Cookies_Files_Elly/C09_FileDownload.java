package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C09_FileDownload extends BaseTest {

    @Test
    public void fileDownload() throws InterruptedException {
/*
        Go to URL: https://opensource-demo.orangehrmlive.com/
        Username : Admin
Password : admin123
        Login page valid credentials.
        Download sample CSV file.
        Verify if the file downloaded successfully.
  */

        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement name = driver.findElement(By.name("username"));
        name.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        login.click();

        WebElement PMI = driver.findElement(By.xpath("(//a[@class=\"oxd-main-menu-item\"])[2]"));
        PMI.click();

        WebElement config = driver.findElement(By.xpath("//span[text()='Configuration ']"));
        config.click();

        WebElement dataImport = driver.findElement(By.linkText("Data Import"));
        dataImport.click();

        WebElement download = driver.findElement(By.linkText("Download"));
        download.click();

        Thread.sleep(3000);//dosyanın inmesi için bekliyoruz..

        String filePath = "/Users/faruk/Downloads/importData.csv";

        Assert.assertTrue("indirilen dosya bulunamadı", Files.exists(Paths.get(filePath)));





    }
}
