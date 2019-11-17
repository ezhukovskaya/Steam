package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import pageObjects.pages.AnyCategoryGamesPage;
import pageObjects.pages.InstallPage;
import pageObjects.pages.MainPage;
import utils.propertiesManager.PropertiesRead;
import utils.waits.ExceptionTreat;
import org.apache.log4j.Logger;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SteamAppDownload {
    private final int LOW_DISCOUNT = 0;
    private final int HIGH_DISCOUNT = 1;
    private static final Logger LOGGER = Logger.getLogger(SteamAppDownload.class);
    private MainPage mainPage;
    private InstallPage installPage;
    private AnyCategoryGamesPage anyCategoryGamesPage;
    @BeforeTest
    public void init() throws ParserConfigurationException, SAXException, IOException {
        PropertiesRead.propertiesRead();
        mainPage = new MainPage();
        installPage = new InstallPage();
        anyCategoryGamesPage = new AnyCategoryGamesPage();
        Browser.getInstance();
        Browser.implicitlyWait();
        Browser.goToUrl();
        LOGGER.info("Steam page is opened");
        Browser.maximize();
    }

    @Test
    public void testSteamDownloadApp() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToDownloadApp();
        LOGGER.info("Clicked to download page");
        Assert.assertTrue(installPage.isWelcomeToSteamDisplayed(),"Welcome to Steam page is not opened");
        installPage.downloadClient();
        ExceptionTreat.getExceptionTimeoutTreat();
        Assert.assertTrue(installPage.isDownloaded(), "File hasn't been downloaded");
        Browser.close();
    }

    @Test
    public void highestDiscountCalculationCheck() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.gamesCategoryPerform();
        mainPage.goToActions();
        Assert.assertTrue(anyCategoryGamesPage.actionPageIsDisplayed(),"Action page is not opened");
        anyCategoryGamesPage.topSellingClick();
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(), HIGH_DISCOUNT);
        Assert.assertTrue(anyCategoryGamesPage.comparePrices(),"The prices are different");
        Browser.close();
    }

    @Test
    public void lowestDiscountCalculationCheck(){
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.gamesCategoryPerform();
        mainPage.goToIndie();
        anyCategoryGamesPage.topSellingClick();
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(),LOW_DISCOUNT);
        Assert.assertTrue(anyCategoryGamesPage.comparePrices(), "The prices are different");
        Browser.close();
    }
}
