package framework.utils;
import org.apache.log4j.Logger;

import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class Waiter {
    static final Logger log = Logger.getLogger(Waiter.class);
    public static void waitUntilDownloaded() {
        File f = new File("steam_latest.deb");
        log.info("waiting 10 sec until file is downloaded");
        await().atMost(10, SECONDS).until(() -> f.exists() && !f.isDirectory());
    }

    public static void waitUntilInvisible(By by) {
        log.info("Wait " + PropertiesRead.readFromFrameworkConfig("timeout") + " seconds");
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Integer.parseInt(PropertiesRead.readFromFrameworkConfig("timeout")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
