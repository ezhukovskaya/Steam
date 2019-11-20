package framework.utils.waits;

import framework.browser.Browser;
import framework.utils.propertiesManager.XMLRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ExceptionTreat {
    private static final String TIMEOUT = "timeout";
    static final Logger log = Logger.getLogger(ExceptionTreat.class);

    public static FluentWait<WebDriver> getFluentWait() {
        log.info(TIMEOUT + XMLRead.xmlReader(TIMEOUT) + "seconds");
        return new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(Integer.parseInt(XMLRead.xmlReader(TIMEOUT))))
                .pollingEvery(Duration.ofSeconds(Integer.parseInt(XMLRead.xmlReader(TIMEOUT))))
                .ignoring(ElementNotVisibleException.class, ElementNotInteractableException.class);
    }

}
