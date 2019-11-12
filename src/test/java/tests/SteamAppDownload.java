package tests;

import browser.Browser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.pages.MainPage;

public class SteamAppDownload {
    private MainPage mainPage;
    @BeforeTest
    public void init() {
        mainPage = new MainPage();
        Browser.getInstance();
        Browser.implicitlyWait();
        Browser.goToUrl();
        Browser.maximize();
    }

    @Test
    public void testSteamDownloadApp() {
        mainPage.goToDownloadApp();

    }
}
