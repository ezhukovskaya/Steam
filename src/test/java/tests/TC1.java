package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.InstallPage;
import utils.waits.ExceptionTreat;

public class TC1 extends BaseTest {
    protected InstallPage installPage = new InstallPage();
    @Test
    public void testSteamDownloadApp() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToDownloadApp();
        Assert.assertTrue(installPage.isWelcomeToSteamDisplayed(),"Welcome to Steam page is not opened");
        installPage.downloadClient();
        ExceptionTreat.getFluentWait();
        Assert.assertTrue(installPage.isDownloaded(), "File hasn't been downloaded");
        Browser.close();
    }
}
