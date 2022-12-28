package Day_10_Garry;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Set;

public class C05 extends BaseTest {
    /*
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    ● Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.
    ● Sayfadaki textin "New Window" olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
    */

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement head = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(head.getText().contains("Opening a new window"));

        Assert.assertEquals(driver.getTitle(), "The Internet");

        String firstWindow = driver.getWindowHandle();

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        Set<String> allwindows = driver.getWindowHandles();
        String secondwindow="";
        for (String a:allwindows){
            if (!a.equals(firstWindow)){
                secondwindow=a;
            }
        }

        driver.switchTo().window(secondwindow);
        Assert.assertEquals(driver.getTitle(), "New Window");

        driver.switchTo().window(firstWindow);
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }
}
