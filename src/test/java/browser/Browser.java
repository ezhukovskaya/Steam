package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.propertiesManager.PropertiesRead;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static Browser instanceOfSingletonBrowserClass = null;
    private String browser = "browser";
    private String browserName = PropertiesRead.readFromPropertiesFile(browser);

    /**
     * Конструктор
     */
    private Browser() {
        BrowserFactory.getInstance();
        driver = BrowserFactory.getInstance().getBrowser(browserName);
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
        Browser.getDriver().get(PropertiesRead.readFromPropertiesFile("page"));
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
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesRead.readFromPropertiesFile("timeout")), TimeUnit.SECONDS);
    }


}
