package framework.browser;

import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("page");
    private static final int TIMEOUT = Integer.parseInt(PropertiesRead.readFromFrameworkConfig("timeout"));

    static final Logger log = Logger.getLogger(Browser.class);


    public static WebDriver getBrowser() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser();
        }
        return driver;
    }

    /**
     * переход на сайт
     */
    public static void goToUrl() {
        log.info("Go to " + PAGE);
        getBrowser().get(PAGE);
    }

    /**
     * увеличение окна браузера на весь экран
     */
    public static void maximize() {
        log.info("Full screen mode is on");
        getBrowser().manage().window().maximize();
    }

    /**
     * закрытие браузера
     */
    public static void close() {
        getBrowser().close();
    }

    /**
     * ожидание
     */
    public static void setImplicitlyWait() {
        log.info("Timeout is " + TIMEOUT);
        getBrowser().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

}
