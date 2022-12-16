package Day_02_WebElementLocators;

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

public class C01_Locators {
    WebDriver driver;//diğer classlardan ulaşılabilmesi için before ve test classlarının dışında obje oluşturuyoruz.

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 10 saniye boyunce denemeye devam eder..


        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void idLocator() {
        //id locator --> session_key
        //session_key --> linkedin sayfasındaki html kodların arasından aldık. kullanıcı adı veya email girilen yeri temsil ediyor.
        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("clarusway selenium dersinden selamlar");
    }

    @Test
    public void nameLocator() {
        WebElement password = driver.findElement(By.name("session_password"));
        password.sendKeys("cw_passs");
    }

    @Test
    public void classLocator() {
        //input__input
        WebElement classLoc = driver.findElement(By.className("input__input"));
        classLoc.sendKeys("Class Locator Test ");

    }

    @Test
    public void tagLocator() {
//        WebElement email = driver.findElement(By.tagName("input"));
        //  email.sendKeys("Tag Locator Test");

        List<WebElement> emailList = driver.findElements(By.tagName("input"));
        //birden fazla input olduğu için List'e atama yaptık. ordan da 2. inputu çektik...
        WebElement email = emailList.get(1);
        email.sendKeys("Tag Locator Test");
    }

    @Test
    public void linkTextLocator (){
        WebElement forgetPass= driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
        forgetPass.click();
    }

    @Test
    public void partiallinkTextLocator (){
        WebElement forgetPass= driver.findElement(By.partialLinkText("unuttun"));
        forgetPass.click();
    }

    @Test
    public void absoluteXPath(){
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
email.sendKeys("Faruk bu konuyu tamamladı");
    }


    @Test
    public void relativeXPath(){
        WebElement email = driver.findElement(By.xpath("//input[@name=\"session_key\"]"));
        email.sendKeys("Faruk bu konuyu tamamladı");
    }



}
