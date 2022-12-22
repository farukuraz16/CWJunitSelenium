package Day_06_Dropdown_SeleniumWait;

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

public class C04_BasicAuthentication {
    //username=admmin
    //password=admin
    //https://the-internet.herokuapp.com/basic_auth

    WebDriver driver;

    @Test
    public void basicAuth() {
        //https://USERNAME:PASSWORD@.....
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement content = driver.findElement(By.id("content"));
        Assert.assertTrue(content.isDisplayed());
        System.out.println("content.getText() = " + content.getText());
        Assert.assertTrue(content.getText().contains("Congratulations"));


    }


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
