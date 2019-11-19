package utils.waits;

import browser.Browser;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import utils.propertiesManager.XMLRead;
import java.time.Duration;

public class ExceptionTreat {
    private static ExceptionTreat exceptionTreat;

    /**
     * ожидание + обработка исключения
     */
    public static void getExceptionTimeoutTreat() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
        public static FluentWait<WebDriver> getFluentWait() {
            return new FluentWait<>(Browser.getDriver())
                    .withTimeout(Duration.ofSeconds(Integer.parseInt(XMLRead.xmlReader("timeout"))))
                    .pollingEvery(Duration.ofSeconds(Integer.parseInt(XMLRead.xmlReader("timeout"))))
                    .ignoring(ElementNotVisibleException.class, ElementNotInteractableException.class);
        }

}
