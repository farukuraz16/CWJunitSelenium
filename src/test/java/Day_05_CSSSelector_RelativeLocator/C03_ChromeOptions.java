package Day_05_CSSSelector_RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C03_ChromeOptions {

    @Test
    public void chromeOptions(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");//başlıksız başsız görünmeyen modda çalışacak
         options.addArguments("start-maximized");//maximum boyut
         WebDriver driver = new ChromeDriver(options);

    }





}
