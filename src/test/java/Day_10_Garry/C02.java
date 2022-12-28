package Day_10_Garry;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.awt.event.KeyEvent;

public class C02 extends BaseTest {
    /*
    1. "https://facebook.com" adresine gidin.
    2. "Create New Account" butonuna basın.
    3. "firstName" giriş kutusuna bir isim yazın.
    4. "surname" giriş kutusuna bir soyisim yazın.
    5. "email" giriş kutusuna bir email yazın.
    6. "email" onay kutusuna emaili tekrar yazın.
    7. Bir şifre girin.
    8. Tarih için gün seçin.
    9. Tarih için ay seçin.
    10. Tarih için yıl seçin.
    11. Cinsiyeti seçin.
    12. İşaretlediğiniz cinsiyetin seçili, diğer cinsiyet kutularının seçili olmadığını doğrulayın.
    13. Sayfayı kapatın.
*/

    @Override
    public void tearDown() {

    }

    @Test
    public void facebook() {
        driver.get("https://facebook.com");
        /*
        WebElement cookies = driver.findElement(By.xpath("//*[.='Temel ve isteğe bağlı çerezlere izin ver']"));
        cookies.click();
         */
        WebElement newAccount = driver.findElement(By.xpath("//div[.='Yeni Hesap Oluştur']"));
        newAccount.click();
        WebElement name = driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        String email = faker.internet().emailAddress();

        actions.click(name)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("12").sendKeys(Keys.TAB)
                .sendKeys("Kasım").sendKeys(Keys.TAB)
                .sendKeys("1980").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='-1 ']")).isSelected());


    }
}
