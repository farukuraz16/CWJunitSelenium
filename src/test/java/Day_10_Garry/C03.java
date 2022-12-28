package Day_10_Garry;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03 extends BaseTest {
    /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir method oluşturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
    ● Bir method oluşturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" içermediğini test edin.
    ● Bir method oluşturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin içerdiğini doğrulayın.
 */

    @Test
    public void task() {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        acceptAlert();
        dismissAlert();
        sendKeysAlert();
    }

    private void sendKeysAlert() {
        WebElement alert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alert.click();
        driver.switchTo().alert().sendKeys("Faruk");
        driver.switchTo().alert().accept();


        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Faruk"));



    }

    private void dismissAlert() {
        WebElement alert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alert.click();
        driver.switchTo().alert().dismiss();


        Assert.assertFalse(driver.findElement(By.id("result")).getText().contains("successfuly"));



    }

    private void acceptAlert() {
        WebElement alert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alert.click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");


    }
}
