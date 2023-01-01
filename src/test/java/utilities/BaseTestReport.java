package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.rmi.server.ExportException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BaseTestReport {

    protected WebDriver driver;

    protected ExtentReports extentReports;//raporlama işlemini gerçekleştirir

    protected ExtentHtmlReporter extentHtmlReporter;//raporu html olarak düzenler

    protected ExtentTest extentTest;//teslerimizin pass veya fail olduğunu saklar.. ekran görüntüleri için de kullanılır..


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //extent report objelerimizi de oluşturuuyoruz.
        extentReports = new ExtentReports();

        // Kaydedecegimiz dosya icin tarih stringi olusturuldu
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport_" + currentDate + ".html";

        // HTML raporu olusturacak obje dosya yoluyla initialize edildi
        extentHtmlReporter = new ExtentHtmlReporter(filePath);

        // Raporlama yapan extentreport objemize HTML reporter baglandi
        extentReports.attachReporter(extentHtmlReporter);

        // Rapor ile alakali ekstra opsiyonel bilgiler verildi
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");

        // HTML raporunda goruntulemek istedigimiz konfigurasyonlar yapildi
        extentHtmlReporter.config().setDocumentTitle("CWReports");
        extentHtmlReporter.config().setReportName("Test Run Report");
    }

    @After
    public void tearDown() {
        driver.quit();
        extentReports.flush();
    }

}
