package framework.browser;

import framework.utils.propertiesManager.XMLRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static volatile Browser instanceOfSingletonBrowserClass;
    private static final String LANGUAGE_IN_PROPERTY = "language";
    private static final String BROWSER = "browser";
    private static final String TIMEOUT = "timeout";
    private static final String PAGE = "page";
    private static String language;
    private static String browserName;
    static final Logger log = Logger.getLogger(Browser.class);

    /**
     * Конструктор
     */
    private Browser() {
        browserName = XMLRead.xmlReader(BROWSER);
        language = XMLRead.xmlReader(LANGUAGE_IN_PROPERTY);
        driver = BrowserFactory.getBrowser(browserName, language);
    }

    public static String getLanguage() {
        return language;
    }

    /**
     * возвращает значение драйвера
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * инициализация Singleton
     *
     * @return
     */
    public static Browser getInstance() {
        Browser localInstance = instanceOfSingletonBrowserClass;
        if (localInstance == null) {
            synchronized (Browser.class) {
                localInstance = instanceOfSingletonBrowserClass;
                if (localInstance == null) {
                    instanceOfSingletonBrowserClass = localInstance = new Browser();
                }
            }
        }
        return localInstance;
    }

    /**
     * переход на сайт
     */
    public static void goToUrl() {
        log.info("Go to " + PAGE);
        Browser.getDriver().get(XMLRead.xmlReader(PAGE));
    }

    /**
     * увеличение окна браузера на весь экран
     */
    public static void maximize() {
        log.info("Full screen mode is on");
        Browser.getDriver().manage().window().maximize();
    }

    /**
     * закрытие браузера
     */
    public static void close() {
        Browser.getDriver().close();
    }

    /**
     * ожидание
     */
    public static void setImplicitlyWait() {
        log.info("Timeout is " + XMLRead.xmlReader(TIMEOUT));
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(XMLRead.xmlReader(TIMEOUT)), TimeUnit.SECONDS);
    }

}
