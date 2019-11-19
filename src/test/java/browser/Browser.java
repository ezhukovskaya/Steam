package browser;

import org.openqa.selenium.WebDriver;
import utils.propertiesManager.XMLRead;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static Browser instanceOfSingletonBrowserClass = null;
    private static final String LANGUAGE_IN_PROPERTY = "language";
    private static final String BROWSER = "browser";
    private static final String TIMEOUT = "timeout";
    private static String language;
    private static String browserName;

    /**
     * Конструктор
     */
    private Browser() {
        browserName = XMLRead.xmlReader(BROWSER);
        language = XMLRead.xmlReader(LANGUAGE_IN_PROPERTY);
        driver = BrowserFactory.getBrowser(browserName, language);
    }

    public static String getLanguage(){
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
        if (instanceOfSingletonBrowserClass == null) {
            instanceOfSingletonBrowserClass = new Browser();
        }
        return instanceOfSingletonBrowserClass;
    }

    /**
     * переход на сайт
     */
    public static void goToUrl() {
        Browser.getDriver().get(XMLRead.xmlReader("page"));
    }

    /**
     * увеличение окна браузера на весь экран
     */
    public static void maximize() {
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
    public static void implicitlyWait() {
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(XMLRead.xmlReader(TIMEOUT)), TimeUnit.SECONDS);
    }

}
