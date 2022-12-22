package Day_06_Dropdown_SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {

    WebDriver driver;

    @Test
    public void getAllSelectedOptions() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement> allOptions = select.getAllSelectedOptions();
        allOptions.forEach(x -> System.out.println(x.getText()));
    }

    @Test
    public void getFirstSelectedOptions() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(3);
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

    }

    @Test
    public void getOptions() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Select select = new Select(driver.findElement(By.name("country")));

        List<WebElement> options = select.getOptions();
        for (WebElement element : options) {
            System.out.println(element.getText());

        }
    }

    @Test
    public void multipleSelect() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        System.out.println("select.isMultiple() = " + select.isMultiple());

        select.selectByValue("apple");
        select.selectByIndex(3);//grape

    }


    @Test
    public void selectByVisibleText() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //WebElement country = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        WebElement country = driver.findElement(By.name("country"));

        Select select = new Select(country);
        select.selectByVisibleText("NEPAL");

        System.out.println("select.isMultiple() = " + select.isMultiple());
        //çoklu seçim yapabiliyor muyuz yapamıyor muyuz? true/false...

    }

    @Test
    public void selectByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //WebElement country = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        WebElement country = driver.findElement(By.name("country"));

        Select select = new Select(country);
        select.selectByValue("TURKEY");


    }

    @Test
    public void selectByIndex() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //WebElement country = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        WebElement country = driver.findElement(By.name("country"));

        Select select = new Select(country);
        select.selectByIndex(5);//index 0 ile başlar


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

