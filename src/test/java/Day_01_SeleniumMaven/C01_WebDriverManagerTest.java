package Day_01_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {
    public static void main(String[] args) throws InterruptedException {
        // Set Path.
        // Create chrome driver.
        // Maximize the window.
        // Open google home page https://www.google.com/
        // Verify that you are Google in the title.


        //WebDriverManager classını kullanarak chromedriver binary indirdik
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        String title = driver.getTitle();

        if (title.equals("Google")) System.out.println("Title test PASSED");
        else System.out.println("Title test FAILED");

        Thread.sleep(5000);

        driver.quit();

    }
}
