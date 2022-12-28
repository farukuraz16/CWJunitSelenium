package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C10_FileUpload extends BaseTest {
    @Test
    public void fileUpload() {
        /*
        Go to URL: https://the-internet.herokuapp.com/upload
Find the path of the file that you want to upload.
Click on Upload button.
Verify the upload message.
         */

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("/Users/faruk/Desktop/deneme/fileExist.png");

        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();

        WebElement message = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("File Uploaded!",message.getText());



    }
}
