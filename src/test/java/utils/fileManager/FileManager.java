package utils.fileManager;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class FileManager {
    private static boolean downloadedStatus = false;
    public static boolean isFileDownloaded(String downloadPath, String fileName){
        File file = new File(downloadPath);
        File[] dirContents = file.listFiles();
        assert dirContents != null;
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                downloadedStatus = true;
            }
        }
        return downloadedStatus;
    }
}
