package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C10_FileUploadAssertElement extends BaseTest {
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

        //tüm mesajları bir liste atıyoruz..
        List<WebElement> messageList = driver.findElements(By.tagName("h3"));//tagname yanlış yazılırsa hatayı aşağıda görebilriz

        Assert.assertEquals("mesaj bulunamadı",1,messageList.size());

        WebElement uploadMessage = messageList.get(0);
        Assert.assertTrue(uploadMessage.isDisplayed());
        Assert.assertEquals("mesaj yok", "File Uploaded!",uploadMessage.getText());
//"File Uploaded!"

    }
}
