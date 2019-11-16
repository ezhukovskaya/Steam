package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import pageObjects.pages.ActionGamesPage;
import pageObjects.pages.InstallPage;
import pageObjects.pages.MainPage;
import utils.propertiesManager.PropertiesRead;
import utils.waits.ExceptionTreat;
import utils.waits.WebElementWait;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class SteamAppDownload {
    private MainPage mainPage;
    private InstallPage installPage;
    private ActionGamesPage actionGamesPage;
    @BeforeTest
    public void init() throws ParserConfigurationException, SAXException, IOException {
        PropertiesRead.propertiesRead();
        mainPage = new MainPage();
        installPage = new InstallPage();
        actionGamesPage = new ActionGamesPage();
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

    @Test
    public void highestDiscountCalculationCheck() {
        mainPage.gamesCategoryPerform();
        mainPage.goToActions();
        actionGamesPage.topSellingClick();
        actionGamesPage.theVeryGameClick(actionGamesPage.getTopSellingGames());
        Assert.assertTrue(actionGamesPage.comparePrices(),"The prices are different");
    }
}
