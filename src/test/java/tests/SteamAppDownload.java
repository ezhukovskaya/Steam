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

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.apache.log4j.Logger;

public class SteamAppDownload {
    private final int LOW_DISCOUNT = 0;
    private final int HIGH_DISCOUNT = 1;
    private final String BROWSING_ACTION = "BROWSING_ACTION";
    private final String BROWSING_INDIE = "BROWSING_INDIE";
    private String expectedGameGenre;
    private MainPage mainPage;
    private InstallPage installPage;
    private AnyCategoryGamesPage anyCategoryGamesPage;
    private static final Logger log = Logger.getLogger(SteamAppDownload.class);
    @BeforeTest
    public void init() throws ParserConfigurationException, SAXException, IOException {
        Browser.getInstance();
        PropertiesRead.propertiesRead(Browser.getLanguage());
        mainPage = new MainPage();
        installPage = new InstallPage();
        anyCategoryGamesPage = new AnyCategoryGamesPage();
        Browser.implicitlyWait();
        Browser.goToUrl();
        log.info("lalalala");
        Browser.maximize();
    }

    @Test
    public void testSteamDownloadApp() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToDownloadApp();
        log.info("lalalala");
        Assert.assertTrue(installPage.isWelcomeToSteamDisplayed(),"Welcome to Steam page is not opened");
        installPage.downloadClient();
        ExceptionTreat.getFluentWait();
        Assert.assertTrue(installPage.isDownloaded(), "File hasn't been downloaded");
        Browser.close();
    }

    @Test
    public void highestDiscountCalculationCheck() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToMainMenu().goToGamesCategory().goToActions();
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(BROWSING_ACTION),"Action page is not opened");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(),"Top Selling is not opened");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(), HIGH_DISCOUNT);
        Assert.assertTrue(anyCategoryGamesPage.comparePrices(),"The prices are different");
        Browser.close();
    }

    @Test
    public void lowestDiscountCalculationCheck(){
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToMainMenu().goToGamesCategory().goToIndie();
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(BROWSING_INDIE),"Indie page is not opened");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(),"Top Selling is not opened");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(),LOW_DISCOUNT);
        Assert.assertTrue(anyCategoryGamesPage.comparePrices(), "The prices are different");
        Browser.close();
    }
}
