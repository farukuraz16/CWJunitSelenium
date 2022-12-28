package Day_08_WindowHandles_Actions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import javax.swing.*;

public class C02_Actions extends BaseTest {

    @Test
    public void doubleClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());
    }

    @Test
    public void rightClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightClickMessage.isDisplayed());

    }

    @Test
    public void click() {
        driver.get("https://demoqa.com/buttons");
        WebElement click = driver.findElement(By.xpath("//button[.='Click Me']"));
        Actions actions = new Actions(driver);
        actions.click(click).perform();
        WebElement dynamicClick = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(dynamicClick.isDisplayed());

    }

}
