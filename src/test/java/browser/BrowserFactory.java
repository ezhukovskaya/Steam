package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.propertiesManager.PropertiesRead;
import utils.propertiesManager.XMLRead;

import java.util.HashMap;

public class BrowserFactory {
    private static BrowserFactory browserFactoryInstance = null;
    private static String chrome = "chrome";
    private static String firefox = "firefox";
    private static String languageInProperty = "locale.language";
    private static String language = PropertiesRead.readFromPropertiesFile(languageInProperty);
    private static String downloadFilePath = "/home/ITRANSITION.CORP/e.zhukovskaya/Downloads";

    /**
     * выбор драйвера для браузера, указанного в config
     *
     * @param browserName имя браузера
     * @return driver
     */
    public WebDriver getBrowser(String browserName) {
        browserName = browserName.toLowerCase();
        WebDriver driver = null;
        if (browserName.equals(chrome)) {
            driver = getChromeInstance(language);
        }
        if (browserName.equals(firefox)) {
            driver = getFirefoxInstance(language);
        } else {
            System.out.println("Браузер указан неверно");
        }

        return driver;
    }

    /**
     * инициализация Singleton
     *
     * @return
     */
    public static BrowserFactory getInstance() {
        if (browserFactoryInstance == null) {
            browserFactoryInstance = new BrowserFactory();
        }
        return browserFactoryInstance;
    }

    /**
     * установка драйвера для Chrome
     *
     * @return
     */
    private ChromeDriver getChromeInstance(String language) {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);
        chromePrefs.put("safebrowsing.enabled",true);
        chromeOptions.setExperimentalOption("prefs",chromePrefs);
        return new ChromeDriver(chromeOptions);
    }

    /**
     * установка драйвра для Firefox
     *
     * @return
     */
    private FirefoxDriver getFirefoxInstance(String language) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.download.dir", downloadFilePath);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-debian-package");
        firefoxOptions.addPreference("pdfjs.disabled", true);
        //firefoxOptions.addPreference("intl.accept_languages", language);
        return new FirefoxDriver(firefoxOptions);
    }

    public static String getDownloadFilePath(){
        return downloadFilePath;
    }
}
