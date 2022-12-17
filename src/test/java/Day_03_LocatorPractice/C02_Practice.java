package Day_03_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {
//    Create the driver with BeforeClass and make it static inside the class.
//    Go to http://www.google.com
//    Type "Green Mile" in the search box and print the number of results.
//    Type "Premonition" in the search box and print the number of results.
//    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//    Close with AfterClass.

    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Before
    public void beforeEach() {
        driver.get("http://www.google.com");

    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }

    @Test
    public void test01(){
        //    Type "Green Mile" in the search box and print the number of results.

        //WebElement search=driver.findElement(By.xpath(" //input[@name='q']"));
        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys("Green Mile"+ Keys.ENTER);

        WebElement result=driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());
    }



}
