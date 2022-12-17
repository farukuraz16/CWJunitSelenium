package Day_04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task_02 {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.
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
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//*[@id='calculatetest']")).click();
        driver.getCurrentUrl();
        WebElement firstInput = driver.findElement(By.xpath("//*[@id=\"number1\"]"));
        firstInput.sendKeys("10");
        WebElement secondInput = driver.findElement(By.xpath("//*[@id=\"number2\"]"));
        secondInput.sendKeys("20");

        driver.findElement(By.xpath("//*[@id=\"calculate\"]")).click();
        WebElement result = driver.findElement(By.xpath("//*[@id=\"answer\"]"));
        System.out.println("result = " + result.getText());

    }
}
