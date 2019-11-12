package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.elements.Button;
import pageObjects.pages.MainPage;

public class SteamAppDownload {
    private MainPage mainPage;
    private Button button;
    @BeforeTest
    public void init() {
        mainPage = new MainPage();
        button = new Button();
        Browser.getInstance();
        Browser.implicitlyWait();
        Browser.goToUrl();
        Browser.maximize();
    }

    @Test
    public void testSteamDownloadApp() {
        mainPage.goToDownloadApp();
        Assert.assertTrue(button.getLogoButtonSteam().isDisplayed(), "The page hasn't loaded");
    }
}
