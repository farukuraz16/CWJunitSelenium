package Day_07_Iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_IframeExample {
    WebDriver driver;

    @Test
    public void iframeExample() {
//        Go to URL: https://the-internet.herokuapp.com/iframe
//        Verify the Bolded text contains "Editor"
//        Locate the text box
//        Delete the text in the text box
//        Type "Hi everyone"
//        Verify the text Elemental Selenium text is displayed on the page.

        //        Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //        Verify the Bolded text contains "Editor"
        WebElement textBold = driver.findElement(By.tagName("h3"));//html kodunda h3 1 tane olduğu için tagname ile çağırdık
        Assert.assertTrue(textBold.getText().contains("Editor"));

        //        Locate the text box
        driver.switchTo().frame(0);//sayfada 1 tane iframe var. zaten ilk iframe ile işimiz var. bu sebeple index no ile geçiş sağladık
        WebElement textBox = driver.findElement(By.id("tinymce"));

        //        Delete the text in the text box
        textBox.clear();

        //        Type "Hi everyone"
        textBox.sendKeys("Hi everyone");

        //        Verify the text Elemental Selenium text is displayed on the page.
        driver.switchTo().defaultContent();//iframeden çıkmalıyız. çünkü "Elemental Selenium" yazısı iframein dışında.
        Assert.assertTrue(driver.findElement(By.partialLinkText("Elemental")).isDisplayed());
        //"Elemental Selenium" yazısı bir link olduğu için partialLinkText metoduyla ulaştık.




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
