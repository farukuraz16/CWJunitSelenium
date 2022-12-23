package Day_07_Iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_IframeExample {

    WebDriver driver;
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidiniz.
    // Web sitesini maximize yapınız.
    // İkinci emojiye tıklayınız.
    // Tüm ikinci emoji öğelerine tıklayınız.
    // Parent iframe geri dönünüz.
    // Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button’a basınız.
@Test
    public void iframeExample() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.switchTo().frame("emoojis");


        WebElement bearEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        bearEmoji.click();

   // WebElement secondEmojiTab = driver.findElement(By.xpath("//a[contains(@href,'nature')]"));
    //  secondEmojiTab.click();



    // Tüm ikinci emoji öğelerine tıklayınız.
    List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']//img"));
   // emojiList.forEach(WebElement::click); // her bir img elementine tiklaniyor


      for (WebElement emoji: emojiList) {emoji.click();}


        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='smiles']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='food']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='activities']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='places']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='objects']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='flags']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='hide']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//input[@id='active']")).sendKeys("Clarus");
        driver.findElement(By.xpath("//button[@id='send']")).click();

        /*
        WebElement applyButton = driver.findElement(By.id("send"));
        applyButton.click();
         */


    }

    @Before
    public void setup(){
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        driver.quit();
    }




}
