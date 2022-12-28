package Day_09_JSEScroll_Cookies_Files_Elly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class C04_Cookies extends BaseTest {
    // Go to URL: https://kitchen.applitools.com/ingredients/cookie
    // Get Cookie.
    // Find the total number of cookies.
    // Print all the cookies.
    // Add Cookie.
    // Edit Cookie.
    // Delete Cookie.
    // Delete All Cookies.

    @Test
    public void testCookie (){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Cookie cookie = driver.manage().getCookieNamed("protein");//cookkie yi isimle cagirdik
        Assert.assertEquals("chicken",cookie.getValue());

        // Find the total number of cookies.
        Set<Cookie> allCookies =  driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);

        // Print all the cookies.
        allCookies.forEach(x-> System.out.println(x));

        for (Cookie c:allCookies         ) {
            System.out.println(c);
            System.out.println("c.getValue() = " + c.getValue());
            System.out.println("c.getName() = " + c.getName());
        }

        // Add Cookie.
        Cookie c1 = new Cookie("fruit","apple");//yeni cookie okuşturduk
        driver.manage().addCookie(c1);
        Assert.assertEquals(c1.getValue(),driver.manage().getCookieNamed(c1.getName()).getValue());

        System.out.println("Cookie added...");

        allCookies = driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());
        System.out.println("allCookies = " + allCookies);

        // Edit Cookie.
        Cookie editCookie = new Cookie(c1.getName(), "mango");
        driver.manage().addCookie(editCookie);
        Assert.assertEquals(editCookie.getValue(),driver.manage().getCookieNamed(c1.getName()).getValue());
        System.out.println("driver.manage().getCookieNamed(c1.getName()).getValue() = " + driver.manage().getCookieNamed(c1.getName()).getValue());

    }


    @Test
    public void deleteCookie(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies); //numOfCookies = 2

        Cookie ayran = new Cookie("drink","ayran");
        driver.manage().addCookie(ayran);
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());

        driver.manage().deleteCookie(ayran);
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());

        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());


    }


}
