package Day_05_CSSSelector_RelativeLocator;

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
import java.util.List;

public class C05_Checkboxes {
    WebDriver driver;

    @Test
    public void checkboxes(){
//    Go to URL: https://demoqa.com/
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.
        driver.get("https://demoqa.com/");

   WebElement elements= driver.findElement(By.xpath("//div[@class='card-up']"));
    //WebElement elements= driver.findElement(By.partialLinkText("Elements"));
    elements.click();

    WebElement checkbox = driver.findElement(By.xpath("(//span[@class='text'])[2]"));
    checkbox.click();

    WebElement homeCheckBox = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));//span[@class='rct-checkbox']
    homeCheckBox.click();
    Assert.assertTrue(homeCheckBox.isDisplayed());

    WebElement selected = driver.findElement(By.xpath("//span[text()='You have selected :']"));
    Assert.assertTrue(selected.isDisplayed());


    }

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
