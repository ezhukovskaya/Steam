package browser;

import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import utils.propertiesManager.PropertiesRead;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static Browser instanceOfSingletonBrowserClass = null;
    private static final String LANGUAGE_IN_PROPERTY = "language";
    private static final String BROWSER = "browser";
    private static final String PAGE = "page";
    private static final String TIMEOUT = "timeout";
    private static String language;
    private static String browserName;

    /**
     * Конструктор
     */
    private Browser() {
        PropertiesRead.propertiesRead();
        browserName = PropertiesRead.readFromPropertiesFile(BROWSER);
        language = PropertiesRead.readFromPropertiesFile(LANGUAGE_IN_PROPERTY);
        driver = BrowserFactory.getBrowser(browserName, language);
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
    public static Browser getInstance() throws IOException, SAXException, ParserConfigurationException {
        if (instanceOfSingletonBrowserClass == null) {
            instanceOfSingletonBrowserClass = new Browser();
        }
        return instanceOfSingletonBrowserClass;
    }

    /**
     * переход на сайт
     */
    public static void goToUrl() {
        Browser.getDriver().get(PropertiesRead.readFromPropertiesFile(PAGE));
    }

    /**
     * увеличение окна браузера на весь экран
     */
    public static void maximize() {
        Browser.getDriver().manage().window().maximize();
    }

    /**
     * переход на заданную вкладку
     *
     * @param tabNumber номер вкладки
     * @param tabs      массив вкладок
     */
    public static void switchTo(int tabNumber, ArrayList<String> tabs) {
        Browser.getDriver().switchTo().window(tabs.get(tabNumber));
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
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesRead.readFromPropertiesFile(TIMEOUT)), TimeUnit.SECONDS);
    }
}
