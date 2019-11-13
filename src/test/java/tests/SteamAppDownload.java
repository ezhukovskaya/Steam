package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.pages.InstallPage;
import pageObjects.pages.MainPage;
import utils.waits.ExceptionTreat;

public class SteamAppDownload {
    private MainPage mainPage;
    private InstallPage installPage;
    @BeforeTest
    public void init() {
        mainPage = new MainPage();
        installPage = new InstallPage();
        Browser.getInstance();
        Browser.implicitlyWait();
        Browser.goToUrl();
        Browser.maximize();
    }

    @Test
    public void testSteamDownloadApp() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToDownloadApp();
        Assert.assertTrue(installPage.isWelcomeToSteamDisplayed(),"Welcome to Steam page is not opened");
        installPage.downloadClient();
        ExceptionTreat.getExceptionTimeoutTreat();
        Assert.assertTrue(installPage.isDownloaded(), "File hasn't been downloaded");
        Browser.close();
    }
}
