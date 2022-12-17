package Day_04_LocatorPractice;

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

public class C02_CSSPractice {
    //http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()
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
    public void cssTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

//100 defa tıklayacacağız..aşağıdaki methodu çağırıyoruz..
        creatElements(100);

        deleteButtonsAndValidate(40);
    }


    public void creatElements(int amount) {
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < amount; i++) {
            addElementButton.click();

        }

    }

    public void deleteButtonsAndValidate(int amount) {

        //sayfadaki delete button sayısını saklarız..
        //bizden istenen sayı kadar delete buttonu sileriz..
        //kalan button sayısını buluruz.
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int deleteButtonsCount = deleteButtons.size();
        for (int i = 0; i < amount; i++) {
            deleteButtons.get(i).click();
        }

        List<WebElement> deleteButtonsAfter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int deleteButtonsAfterCount = deleteButtonsAfter.size();
//        System.out.println("deleteButtonsAfterCount = " + deleteButtonsAfterCount);
        Assert.assertEquals(deleteButtonsCount - amount, deleteButtonsAfterCount);
    }
}


