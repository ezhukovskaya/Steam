package tests;

import browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 extends BaseTest{
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
}
