package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.propertiesManager.PropertiesRead;
import utils.propertiesManager.XMLRead;

import java.util.HashMap;

public class BrowserFactory {
    private static final String PATH = "path";
    private static final String XMLPATH = "xmlpath";
    private static String path;

    public static String download() {
        path = PropertiesRead.readFromPropertiesFile(XMLPATH);
        return XMLRead.xmlReader(PATH, path);
    }

    /**
     * выбор драйвера для браузера, указанного в config
     *
     * @param browserName имя браузера
     * @return driver
     */
    public static WebDriver getBrowser(String browserName, String language) {
        browserName = browserName.toLowerCase();
        WebDriver driver = null;
        if (browserName.equals("chrome")) {
            driver = getChromeInstance(language);
        }
        if (browserName.equals("firefox")) {
            driver = getFirefoxInstance(language);
        } else {
            System.out.println("Браузер указан неверно");
        }

        return driver;
    }

    /**
     * установка драйвера для Chrome
     *
     * @return
     */
    private static ChromeDriver getChromeInstance(String language) {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", download());
        chromePrefs.put("safebrowsing.enabled",true);
        chromePrefs.put("intl.accept_languages", language);
        chromeOptions.setExperimentalOption("prefs",chromePrefs);
        return new ChromeDriver(chromeOptions);
    }

    /**
     * установка драйвра для Firefox
     *
     * @return
     */
    private static FirefoxDriver getFirefoxInstance(String language) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.download.dir", download());
        firefoxOptions.addPreference("browser.download.useDownloadDir",true);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-debian-package");
        firefoxOptions.addPreference("pdfjs.disabled", true);
        firefoxOptions.addPreference("intl.accept_languages", language);
        return new FirefoxDriver(firefoxOptions);
    }
}
