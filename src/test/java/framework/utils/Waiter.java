package framework.utils;

import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class Waiter {

    public static void waitUntilDownloaded() {
        File f = new File("steam_latest.deb");
        await().atMost(10, SECONDS).until(() -> f.exists() && !f.isDirectory());
    }

    public static void waitUntilInvisible(By by) {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Integer.parseInt(PropertiesRead.readFromFrameworkConfig("timeout")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
