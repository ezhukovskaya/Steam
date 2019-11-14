package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import pageObjects.pages.InstallPage;
import pageObjects.pages.MainPage;
import utils.propertiesManager.PropertiesRead;
import utils.waits.ExceptionTreat;
import utils.waits.WebElementWait;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SteamAppDownload {
    private MainPage mainPage;
    private InstallPage installPage;
    @BeforeTest
    public void init() throws ParserConfigurationException, SAXException, IOException {
        PropertiesRead.propertiesRead();
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

    @Test
    public void highestDiscountCalculationCheck() throws ParserConfigurationException, SAXException, IOException {
        Browser.getInstance();
        Browser.implicitlyWait();
        Browser.goToUrl();
        Browser.maximize();
        mainPage.gamesCategoryPerform();
        mainPage.goToActions();
    }
}
