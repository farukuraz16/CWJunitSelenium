package Day_13_Log4j_SeleniumExceptions_ExtentReport;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class C02_Log4jDemo {
    public static void main(String[] args) {
//istediğimiz configirasyonların gelmesi için "log4j.properties" belgesinde gerekli seçimi yapıyoruz.
        //ALL yazarsak tüm loglar gelecektir. INFO yazarsak INFO Ve sonrası gelecektir.
        PropertyConfigurator.configure("log4j.properties");

        Logger logger = LogManager.getLogger(C02_Log4jDemo.class.getName());
        
        logger.trace("Trace Mesajı");
        logger.debug("Debug Mesajı");
        logger.info("Info Mesajı");
        logger.warn("Warn Mesajı");
        logger.error("Error Mesajı");
        logger.fatal("Fatal Mesajı");



    }
}
