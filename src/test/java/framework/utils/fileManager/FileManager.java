package framework.utils.fileManager;

import java.io.File;

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
