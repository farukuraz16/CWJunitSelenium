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

public class C06_RadioButton {
    WebDriver driver;

    @Test
    public void checkboxes(){
        //    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Click 'Kadin'
//    Click 'Erkek'
//      Validate 'Kadin' is not selected and 'Erkek' is selected.
        driver.get("https://www.facebook.com/");

//a[@data-testid='open-registration-form-button']
//a[contains(@data-testid,'registration-form')]

        WebElement registerButton = driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]"));
    registerButton.click();
        WebElement kadinRadio = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        WebElement erkekRadio = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));

        kadinRadio.click();

        erkekRadio.click();

        Assert.assertTrue(erkekRadio.isSelected());
        Assert.assertTrue(!kadinRadio.isSelected());

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
