package tests;

import browser.Browser;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.xml.sax.SAXException;
import pageObjects.pages.AnyCategoryGamesPage;
import pageObjects.pages.InstallPage;
import pageObjects.pages.MainPage;
import utils.propertiesManager.PropertiesRead;
import utils.propertiesManager.XMLRead;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class BaseTest {
    protected MainPage mainPage;
    static final Logger log = Logger.getLogger(BaseTest.class);
    @BeforeTest
    public void init()  {
        PropertyConfigurator.configure(XMLRead.xmlReader("file"));
        Browser.getInstance();
        PropertiesRead.propertiesRead(Browser.getLanguage());
        mainPage = new MainPage();
        Browser.implicitlyWait();
        Browser.goToUrl();
        log.info("Go to Steam page");
        Browser.maximize();
    }
    @AfterTest
    public void close(){
        Browser.close();
        log.info("Browser closes");
    }
}
