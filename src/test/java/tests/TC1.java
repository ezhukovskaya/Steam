package tests;

import framework.utils.waits.ExceptionTreat;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.InstallPage;

public class TC1 extends BaseTest {
    private InstallPage installPage = new InstallPage();

    @Test
    public void testSteamDownloadApp() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        log.info("Go to Download client page");
        mainPage.goToDownloadApp();
        Assert.assertTrue(installPage.isWelcomeToSteamDisplayed(), "Welcome to Steam page is not opened");
        log.info("Downloading the app");
        installPage.downloadClient();
        ExceptionTreat.waitUntilDownloaded();
        Assert.assertTrue(installPage.isDownloaded(), "File hasn't been downloaded");
    }
}
