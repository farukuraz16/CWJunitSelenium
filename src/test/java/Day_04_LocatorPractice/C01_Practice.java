package Day_04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice {

    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.
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
    public void test() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement alertLink = driver.findElement(By.xpath("//a[@id='alerts']"));
        alertLink.click();
        String alertsURL= driver.getCurrentUrl();
        System.out.println(alertsURL);

        //geri gitmek için.. bir önceki sayfaya gitmek için..
        driver.navigate().back();
        String homeURL= driver.getCurrentUrl();
        System.out.println(homeURL);

        WebElement basicAjaxlink= driver.findElement(By.id("basicajax"));
        basicAjaxlink.click();
        String basicAjaxURL = driver.getCurrentUrl();
        System.out.println(basicAjaxURL);
        driver.findElement(By.id("lteq30")).sendKeys("20" + Keys.ENTER);

        WebElement submittedValuesText = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(submittedValuesText.isDisplayed());

    }


}
