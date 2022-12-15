package Day_01_SeleniumMaven;

import org.junit.*;

public class C02_JunitAnnotations {
    // 1. test
    // 2. test
    // 3. test
    // 4. test (gelistirme asamasinda bu yuzden rapora dahil olmasin)

    // Her testimizden once ve sonra calismasi gereken kod bloklarimiz (methodlarimiz) mevcut
    // Tum testlerin oncesinde ve sonrasinda calismasi gereken methodlarimiz mevcut.

//        1. @Test -> Marks a method as a TEST CASE.
//        2. @Before : Runs before EACH @Test annotation.
//        3. @After : Runs after EACH @Test annotation.
//        4. @BeforeClass : Runs before each class only once.
//        5. @AfterClass : Runs after each class only once.
//        6. @Ignore : Skipping a test case.


    @Test
    public void test01() {
        System.out.println("Test01 yapılıyor.");
    }

    @Test
    public void test02() {
        System.out.println("Test02 yapılıyor.");
    }

    @Test
    public void test03() {
        System.out.println("Test03 yapılıyor.");
    }

    @Test
    @Ignore
    public void test04() {
        System.out.println("Test04.. geliştirme aşamasında....");
    }

    @Before
    public void before(){
        System.out.println("Test öncesi kod bloğu çalıştı...");
    }

    @After
    public void after(){
        System.out.println("Test sonrası kod bloğu çalıştı...");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Testler/Classlar öncesi kod bloğu çalıştı. beforClass ");
    }
@AfterClass
    public static void afterClass(){
        System.out.println("Testler/Classlar sonrası kod bloğu çalıştı. afterClass ");
    }

}
