package tests;

import browser.Browser;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.xml.sax.SAXException;
import pageObjects.pages.AnyCategoryGamesPage;
import pageObjects.pages.InstallPage;
import pageObjects.pages.MainPage;
import utils.propertiesManager.PropertiesRead;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class BaseTest {
    protected final int LOW_DISCOUNT = 0;
    protected final int HIGH_DISCOUNT = 1;
    protected final String BROWSING_ACTION = "BROWSING_ACTION";
    protected final String BROWSING_INDIE = "BROWSING_INDIE";
    protected String expectedGameGenre;
    protected MainPage mainPage;
    protected InstallPage installPage;
    protected AnyCategoryGamesPage anyCategoryGamesPage;
    protected static final Logger log = Logger.getLogger(BaseTest.class);
    @BeforeTest
    public void init() throws ParserConfigurationException, SAXException, IOException {
        Browser.getInstance();
        PropertiesRead.propertiesRead(Browser.getLanguage());
        mainPage = new MainPage();
        installPage = new InstallPage();
        anyCategoryGamesPage = new AnyCategoryGamesPage();
        Browser.implicitlyWait();
        Browser.goToUrl();
        log.info("lalalala");
        Browser.maximize();
    }
    @AfterTest
    public void close(){
        Browser.close();
    }
}
