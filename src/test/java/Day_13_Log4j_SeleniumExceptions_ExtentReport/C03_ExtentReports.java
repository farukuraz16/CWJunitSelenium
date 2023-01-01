package Day_13_Log4j_SeleniumExceptions_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTestReport;

public class C03_ExtentReports extends BaseTestReport {

    @Test
    public void test() {

        extentTest = extentReports.createTest("My Test","Bu bir açıklamadır");

        extentTest.info("Amazon'a gidiliyor...");

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kismina log4j yaziliyor");
        searchBox.sendKeys("log4j");

        extentTest.pass("Test geçerli");
        extentTest.fail("Test geçersiz");
        extentTest.skip("Testimiz skip edildi");


    }
}
