package framework.utils.fileManager;

import org.apache.log4j.Logger;

import java.io.File;

public class FileManager {
    static final Logger log = Logger.getLogger(FileManager.class);

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File downloadedFile = null;
        File file = new File(downloadPath);
        File[] dirContents = file.listFiles();
        assert dirContents != null;
        log.info("Checked if file is in the folder");
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                downloadedFile = dirContent;
            }
        }
        assert downloadedFile != null;
        return (downloadedFile.getName().equals(fileName));
    }
}
