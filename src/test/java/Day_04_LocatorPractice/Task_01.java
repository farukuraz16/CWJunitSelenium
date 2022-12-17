package Day_04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task_01 {

    //https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.

    WebDriver driver;

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

    @Test
    public void Test(){
        driver.get("https://id.heroku.com/login");
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("xxx@mail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("xxxxxx");

        driver.findElement(By.cssSelector("button[name='commit']")).click();

        WebElement loginValueText = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        if (loginValueText.getText().equals("There was a problem with your login.")){
            System.out.println("Kayıt Yapılamadı");

        }else System.out.println("Kayıt Yapıldı");



    }
}
