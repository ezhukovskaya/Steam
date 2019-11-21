package framework.utils.waits;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class ExceptionTreat {

    public static void waitUntilDownloaded() {
        File f = new File("steam_latest.deb");
        await().atMost(10, SECONDS).until(() -> f.exists() && !f.isDirectory());
    }

}
