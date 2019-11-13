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
    private static String countryInProperty = "country.language";
    private static String country = PropertiesRead.readFromPropertiesFile(countryInProperty);
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
            driver = getChromeInstance(language, country);
        }
        if (browserName.equals(firefox)) {
            driver = getFirefoxInstance(language, country);
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
    private ChromeDriver getChromeInstance(String language, String country) {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--lang="+ language +"-"+country);
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
    private FirefoxDriver getFirefoxInstance(String language, String country) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", downloadFilePath);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        firefoxProfile.setPreference("pdfjs.disabled", true);
        firefoxOptions.setProfile(firefoxProfile);
        //firefoxOptions.addArguments("--lang="+ language +"-"+country);
        return new FirefoxDriver(firefoxOptions);
    }

    public static String getDownloadFilePath(){
        return downloadFilePath;
    }
}
