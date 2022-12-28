package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseTest {//abstract olmasa da olur.. yeni method yazılmayacağı için...
    protected WebDriver driver;
    //    Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
    //    TestBase Class'ı sadece extends ile inherit ederek kullanacağız. Dolayısıyla oluşturduğumuz driver variable'i için protected access modifier seçiyoruz.
    @Before
    public void setup() {
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
