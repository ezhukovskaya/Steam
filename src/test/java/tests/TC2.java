package tests;

import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.AnyCategoryGamesPage;

public class TC2 extends BaseTest {
    private final int HIGH_DISCOUNT = 1;
    private final String BROWSING_ACTION = "BROWSING_ACTION";
    private AnyCategoryGamesPage anyCategoryGamesPage = new AnyCategoryGamesPage();

    @Test
    public void highestDiscountCalculationCheck() {
        Assert.assertTrue(mainPage.isHomePageDisplayed(), "The page is not opened");
        mainPage.goToMainMenu().goToGamesCategory().goToActions();
        Assert.assertTrue(anyCategoryGamesPage.genrePageIsDisplayed(BROWSING_ACTION), "Action page is not opened");
        anyCategoryGamesPage.topSellingClick();
        Assert.assertTrue(anyCategoryGamesPage.isTopSellingActive(), "Top Selling is not opened");
        anyCategoryGamesPage.theGameClick(anyCategoryGamesPage.getTopSellingGames(), HIGH_DISCOUNT);
        Assert.assertTrue(anyCategoryGamesPage.comparePrices(), "The prices are different");
        Browser.close();
    }
}
