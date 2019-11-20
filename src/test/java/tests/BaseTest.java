package tests;

import framework.browser.Browser;
import framework.utils.propertiesManager.XMLRead;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.pages.MainPage;

public abstract class BaseTest {
    protected MainPage mainPage;
    static final Logger log = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void init() {
        PropertyConfigurator.configure(XMLRead.xmlReader("file"));
        Browser.getInstance();
        mainPage = new MainPage();
        Browser.setImplicitlyWait();
        Browser.goToUrl();
        Browser.maximize();
    }

    @AfterTest
    public void close() {
        Browser.close();
        log.info("Browser closes");
    }
}
