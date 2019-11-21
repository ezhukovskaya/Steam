package framework.utils.waits;

import framework.browser.Browser;
import framework.utils.propertiesManager.XMLRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class ExceptionTreat {
    private static final String TIMEOUT = "timeout";
    static final Logger log = Logger.getLogger(ExceptionTreat.class);

    public static void waitUntilDownloaded(){
        File f = new File("steam_latest.deb");
        await().atMost(10, SECONDS).until(() -> f.exists() && !f.isDirectory());
    }

}
