package tests;

import framework.browser.Browser;
import framework.utils.PropertiesRead;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    static final Logger log = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void init() {
        PropertyConfigurator.configure(PropertiesRead.readFromFrameworkConfig("file"));
        Browser.getBrowser();
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
