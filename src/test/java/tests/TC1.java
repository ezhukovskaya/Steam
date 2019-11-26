package tests;

import framework.utils.FileManager;
import framework.utils.PropertiesRead;
import framework.utils.Waiter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.InstallPage;
import pageObjects.pages.MainPage;

public class TC1 extends BaseTest {
    private InstallPage installPage = new InstallPage();
    private MainPage mainPage = new MainPage();
    private String downloadFilePath = String.format(System.getProperty("user.dir"), PropertiesRead.readFromFrameworkConfig("path"));
    private String downloadFileName = "steam_latest.deb";

    @Test
    public void testSteamDownloadApp() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Download client page");
        mainPage.goToDownloadApp().installClick();
        Assert.assertTrue(installPage.isWelcomeToSteamDisplayed(), "Welcome to Steam page is not opened");
        log.info("Downloading the app");
        installPage.downloadClient();
        Waiter.waitUntilDownloaded();
        Assert.assertTrue(FileManager.isFileDownloaded(downloadFilePath, downloadFileName), "File hasn't been downloaded");
    }
}
