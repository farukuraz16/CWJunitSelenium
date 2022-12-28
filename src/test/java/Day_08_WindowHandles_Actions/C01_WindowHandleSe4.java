package Day_08_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {

    // https://testproject.io/

    // https://blog.testproject.io/

    @Test
    public void newWindow(){
        driver.get("https://testproject.io/");

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://blog.testproject.io/");
    }


    @Test
    public void newTab(){
        driver.get("https://testproject.io/");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com/");
/*
// Yeni bir sekme olusturuldu
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        // Yeni sekmeden amazona gidildi
        newTab.get("https://www.amazon.com/");
 */
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test
    public void handleWindow(){
        driver.get("https://www.amazon.com/");
        String homePageHandle = driver.getWindowHandle();


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> handle = handles.iterator();

        while (handle.hasNext()){
            String currentTab = handle.next();

            driver.switchTo().window(currentTab);
            System.out.println("driver.getTitle() = " + driver.getTitle());


            if (!driver.getWindowHandle().equals(homePageHandle)){
                driver.close();
            }
            /*
             2. yol
            if (!driver.getTitle().contains("Spend")){
                driver.close();
            }
            */

        }

    }

}
