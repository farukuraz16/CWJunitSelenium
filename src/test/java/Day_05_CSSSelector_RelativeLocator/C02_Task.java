package Day_05_CSSSelector_RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_Task {
    //https://www.teknosa.com/ adresine gidiniz.
    // Arama çubuğuna ‘’oppo’’ yazıp ENTER tıklayınız.
    // Sonuç sayısını yazdırınız.
    // Çıkan ilk ürüne tıklayınız.
    // Sepete ekleyiniz.
    // Sepetime gite tıklayınız.
    // Konsolda "Sipariş Özeti" WebElement’inin text’ini yazdırınız.
    // Alışverişi tamamlayınız.
    // Son olarak "Teknosa’ya Hoş Geldiniz" WebElement’inin text’ini yazdırınız.
    // Driver’ı kapatınız.
    WebDriver driver;

    @Test
    public void Test() {
        driver.get("https://www.teknosa.com/");
        WebElement aramaAlanı = driver.findElement(By.name("s"));
        aramaAlanı.sendKeys("oppo" + Keys.ENTER);//input[@name='s']

        WebElement sonucSayısı = driver.findElement(By.className("plp-info"));//div[@class='plp-info']

        System.out.println("sonucSayısı.getText() = " + sonucSayısı.getText());


        WebElement ilkUrun = driver.findElement(By.className("prd-link"));
        ilkUrun.click();

        //WebElement sepetEkle = driver.findElement(By.id("addToCartButton"));     //button[@id='addToCartButton']));
        WebElement sepetEkle = driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]"));     //button[@id='addToCartButton']));
        // (//button[@id='addToCartButton'])[1]
        sepetEkle.click();

        WebElement sepeteGit = driver.findElement(By.xpath("//a[@class='btn btn-secondary']"));//a[@class='btn btn-secondary']
        sepeteGit.click();

        WebElement siparişÖzet = driver.findElement(By.xpath("//div[@class='cart-sum-body']"));//div[@class='cart-sum-body']
        System.out.println("siparişÖzet.getText() = " + siparişÖzet.getText());

        WebElement alışverişTamamla = driver.findElement(By.partialLinkText("Alışverişi Tamamla"));
        alışverişTamamla.click();

        WebElement hosgeldiniz = driver.findElement(By.xpath("//div[@class='lrp-title']"));
        System.out.println(hosgeldiniz.getText());
    }

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
